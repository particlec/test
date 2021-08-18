package com.utyun.smarthome.vo;

import java.util.List;

public class FunctionList {
    private int objectId;
    private String fullName;
    private String functionName;
    private String functionKey;
    private String className;
    private String returnDataType;
    private List<ParamList> paramList;
    private int isSynchronize;
    public void setObjectId(int objectId) {
        this.objectId = objectId;
    }
    public int getObjectId() {
        return objectId;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public String getFullName() {
        return fullName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }
    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionKey(String functionKey) {
        this.functionKey = functionKey;
    }
    public String getFunctionKey() {
        return functionKey;
    }

    public void setClassName(String className) {
        this.className = className;
    }
    public String getClassName() {
        return className;
    }

    public void setReturnDataType(String returnDataType) {
        this.returnDataType = returnDataType;
    }
    public String getReturnDataType() {
        return returnDataType;
    }

    public void setParamList(List<ParamList> paramList) {
        this.paramList = paramList;
    }
    public List<ParamList> getParamList() {
        return paramList;
    }

    public void setIsSynchronize(int isSynchronize) {
        this.isSynchronize = isSynchronize;
    }
    public int getIsSynchronize() {
        return isSynchronize;
    }
}
