package com.utyun.smarthome.vo;

import java.util.List;

public class JsonVO {
    private List<FunctionList> functionList;
    private List<VariableList> variableList;
//    private StatusMachineObject statusMachineObject;
//    private List<LogicList> logicList;
//    private ParameterData parameterData;
    public void setFunctionList(List<FunctionList> functionList) {
        this.functionList = functionList;
    }
    public List<FunctionList> getFunctionList() {
        return functionList;
    }

    public void setVariableList(List<VariableList> variableList) {
        this.variableList = variableList;
    }
    public List<VariableList> getVariableList() {
        return variableList;
    }

//    public void setStatusMachineObject(StatusMachineObject statusMachineObject) {
//        this.statusMachineObject = statusMachineObject;
//    }
//    public StatusMachineObject getStatusMachineObject() {
//        return statusMachineObject;
//    }
//
//    public void setLogicList(List<LogicList> logicList) {
//        this.logicList = logicList;
//    }
//    public List<LogicList> getLogicList() {
//        return logicList;
//    }
//
//    public void setParameterData(ParameterData parameterData) {
//        this.parameterData = parameterData;
//    }
//    public ParameterData getParameterData() {
//        return parameterData;
//    }
}
