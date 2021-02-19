package com.fiserv.api.ipp.documgmt.helper;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

import javax.enterprise.context.ApplicationScoped;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;

import static com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider.DEFAULT_ANNOTATIONS;

@ApplicationScoped
public class ClientProducer {
    private JacksonJaxbJsonProvider jsonProvider;

    private SSLContext createUnsafeSSLContext() {
        final TrustManager[] trustManagers = { new X509TrustManager() {

            @Override
            public void checkClientTrusted(final X509Certificate[] x509Certificates, final String s) {
                // no-op
            }

            @Override
            public void checkServerTrusted(final X509Certificate[] x509Certificates, final String s) {
                // no-op
            }

            @Override
            public X509Certificate[] getAcceptedIssuers() {
                return null;
            }
        } };
        try {
            final SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, trustManagers, new java.security.SecureRandom());
            return sslContext;
        } catch (final NoSuchAlgorithmException | KeyManagementException e) {
            throw new IllegalStateException(e);
        }
    }

    public ClientProducer() {
        ObjectMapper mapper = new ObjectMapper();

        mapper.registerModule(new JavaTimeModule());
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        mapper.configure(SerializationFeature.CLOSE_CLOSEABLE, true);
        mapper.disable(DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE);
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

        this.jsonProvider = new JacksonJaxbJsonProvider(mapper, DEFAULT_ANNOTATIONS);
    }

    @Produces
    public Client produceClient() {
       return ClientBuilder
                .newBuilder()
                .hostnameVerifier((host, session) -> true)
                .sslContext(createUnsafeSSLContext())
                .register(jsonProvider)
                .register(CustomObjectMapperResolver.class)
                .build();
    }
}
