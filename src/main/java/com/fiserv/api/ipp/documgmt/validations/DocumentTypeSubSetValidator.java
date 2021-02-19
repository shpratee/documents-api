package com.fiserv.api.ipp.documgmt.validations;

import com.fiserv.api.ipp.documgmt.model.DocumentTypeEnum;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

public class DocumentTypeSubSetValidator implements ConstraintValidator<DocumentTypeSubset, DocumentTypeEnum> {
        private DocumentTypeEnum[] subset;

        @Override
        public void initialize(DocumentTypeSubset constraint) {
            this.subset = constraint.anyOf();
        }

        @Override
        public boolean isValid(DocumentTypeEnum value, ConstraintValidatorContext context) {
            return value == null || Arrays.asList(subset).contains(value);
        }
}