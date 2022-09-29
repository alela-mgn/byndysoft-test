package com.byndyusoft.test.service.model;

public class ResultDto {
    private final Double value;
    private final String errorMessage;

    private ResultDto(Builder builder) {
        this.value = builder.value;
        this.errorMessage = builder.errorMessage;
    }

    public Double getValue() {
        return value;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Double value;
        private String errorMessage;

        public Builder value(Double value) {
            this.value = value;
            return this;
        }

        public Builder errorMessage(String errorMessage) {
            this.errorMessage = errorMessage;
            return this;
        }

        public ResultDto build() {
            return new ResultDto(this);
        }
    }
}
