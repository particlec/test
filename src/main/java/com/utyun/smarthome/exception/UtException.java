//package com.ut.fieldmodeltool.exception;
//
//import lombok.extern.apachecommons.CommonsLog;
//
///**
// * @author litingting
// */
//@CommonsLog
//public class UtException extends RuntimeException implements UtError {
//
//    private static final long serialVersionUID = 6261717628275330608L;
//    private final int utCode;
//    private final String utMsg;
//    private final String service;
//
//    public UtException(UtError error, String msg, Throwable cause) {
//        super(msg == null ? error.getUtMsg() : msg, cause);
//        this.service = error.getUtService();
//        this.utCode = error.getUtCode();
//        this.utMsg = msg == null ? error.getUtMsg() : msg;
//    }
//
//    public UtException(String message) {
//        this(UtExceptionEnum.DEFAULT_EXCEPTION, message, null);
//    }
//
//    public UtException(UtError error, String message) {
//        this(error, message, null);
//    }
//
//    public UtException(UtError error) {
//        this(error, null, null);
//    }
//
//    @Override
//    public int getUtCode() {
//
//        return utCode;
//    }
//
//    @Override
//    public String getUtMsg() {
//
//        return utMsg;
//    }
//
//    @Override
//    public String getUtService() {
//        return service;
//    }
//}

