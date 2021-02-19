package com.fiserv.api.ipp.documgmt.model;
/*
 * Copyright (C) 2013 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

public class DocumentData {

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }

    @NotBlank(message = "Document name must not be missing.")
    @Length(min = 1, max = 255, message = "Length of Document name must be between 1 and 255. ")
    private String name;

    @NotBlank(message = "Document content must not be missing.")
    private String content;
}
