package com.dchristofolli.checkpoint.exception;

import org.springframework.http.HttpStatus;

import java.util.Map;

public final class ErrorModelBuilder {
    String message;
    String error;
    HttpStatus status;
    Map<String, String> formErrors;

    private ErrorModelBuilder() {
    }

    public static ErrorModelBuilder anErrorModel() {
        return new ErrorModelBuilder();
    }

    public ErrorModelBuilder withMessage(String message) {
        this.message = message;
        return this;
    }

    public ErrorModelBuilder withError(String error) {
        this.error = error;
        return this;
    }

    public ErrorModelBuilder withStatus(HttpStatus status) {
        this.status = status;
        return this;
    }

    public ErrorModelBuilder withFormErrors(Map<String, String> formErrors) {
        this.formErrors = formErrors;
        return this;
    }

    public ErrorModel build() {
        return new ErrorModel(message, error, status, formErrors);
    }
}
