package com.example.feedserver.helpers.exceptions;

public enum FeedExceptionTypes {
    ;


    private final ExceptionLevel exceptionLevel;
    private final UserType userType;
    private final String causeUserId;

    FeedExceptionTypes(ExceptionLevel exceptionLevel, UserType userType, String causeUserId) {
        this.exceptionLevel = exceptionLevel;
        this.userType = userType;
        this.causeUserId = causeUserId;
    }

    public ExceptionLevel getExceptionLevel() {
        return exceptionLevel;
    }

    public UserType getUserType() {
        return userType;
    }

    public String getCauseUserId() {
        return causeUserId;
    }

    //    public static final String USER = "USER";
//    public static final String STUDENT = "STUDENT";
//    public static final String COMMANDER = "COMMANDER";
//    public static final String MAKAS = "MAKAS";
//    public static final String RAMAD = "RAMAD";
//    public static final String RAAN = "RAAN";
//    public static final String SYSTEM = "SYSTEM";
}
