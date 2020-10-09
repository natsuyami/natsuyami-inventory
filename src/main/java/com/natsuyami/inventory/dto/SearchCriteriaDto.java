package com.natsuyami.inventory.dto;

public class SearchCriteriaDto {
    private String key;
    private String operation;
    private String value;

    public SearchCriteriaDto() {}

    public SearchCriteriaDto(String key, String operation, String value) {
        this.key = key;
        this.operation = operation;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("{\"key\" : ");
        builder.append("\"" + key + "\", ");
        builder.append("\"operation\" : ");
        builder.append("\"" + operation + "\", ");
        builder.append("\"value\" : ");
        builder.append("\"" + value + "\"");
        builder.append("}");
        return builder.toString();
    }
}
