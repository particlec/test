package com.utyun.smarthome.vo;

public class VariableList {

    private int objectId;
    private String variableName;
    private String variableKey;
    private int eventType;
    private String dataType;
    private String valueDescription;
    private String defaultValue;

    public void setObjectId(int objectId) {
        this.objectId = objectId;
    }

    public int getObjectId() {
        return objectId;
    }

    public void setVariableName(String variableName) {
        this.variableName = variableName;
    }

    public String getVariableName() {
        return variableName;
    }

    public void setVariableKey(String variableKey) {
        this.variableKey = variableKey;
    }

    public String getVariableKey() {
        return variableKey;
    }

    public void setEventType(int eventType) {
        this.eventType = eventType;
    }

    public int getEventType() {
        return eventType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getDataType() {
        return dataType;
    }

    public void setValueDescription(String valueDescription) {
        this.valueDescription = valueDescription;
    }

    public String getValueDescription() {
        return valueDescription;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public String getDefaultValue() {
        return defaultValue;
    }
}