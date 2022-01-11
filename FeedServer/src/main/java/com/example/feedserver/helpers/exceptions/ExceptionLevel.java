package com.example.feedserver.helpers.exceptions;

public enum ExceptionLevel {
    UNKNOWN(0, "UNKNOWN"),
    INFO(1000, "INFO"),
    DEBUG(2000, "DEBUG"),
    WARN(3000, "WARN"),
    ERROR(4000, "ERROR"),
    FATAL(5000, "FATAL");


    private final Integer levelCode;
    private final String generalType;

    ExceptionLevel(Integer levelCode, String generalType) {
        this.levelCode = levelCode;
        this.generalType = generalType;
    }

    public Integer getLevelCode() {
        return levelCode;
    }

    public String getGeneralType() {
        return generalType;
    }

    public String getType() {
        return this.name();
    }


    public static ExceptionLevel getExceptionLevel(Integer levelCode) {
        if (levelCode < 0) return UNKNOWN;
        for (ExceptionLevel exceptionLevel :
                ExceptionLevel.class.getEnumConstants()) {
            if (levelCode.equals(exceptionLevel.getLevelCode())) {
                return exceptionLevel;
            }
        }
        return getGeneralExceptionLevel(levelCode);
    }


    public static ExceptionLevel getGeneralExceptionLevel(Integer levelCode) {
        if (levelCode < 0) return UNKNOWN;
        for (ExceptionLevel exceptionLevel :
                ExceptionLevel.class.getEnumConstants()) {
            if (levelCode.equals(exceptionLevel.levelCode - exceptionLevel.getLevelCode() % 1000)) {
                return exceptionLevel;
            }
        }
        return UNKNOWN;
    }

    /**
     * uses the getExceptionLevel() method, and then applies the getType() method on the return value
     * if the @param levelCode points to an unknown exceptionLevel it would return the value that references the exception level UNKNOWN
     * this scan is a bit harder then getGeneralExceptionLevelName(), but get more accurate result
     *
     * @param levelCode the level that shows what is the level of the exception
     * @return general exception level type as string
     */
    public static String getExceptionLevelName(Integer levelCode) {
        return getExceptionLevel(levelCode).getType();
    }

    /**
     * uses the getGeneralExceptionLevel() method, and then applies the getGeneralType() method on the return value
     * if the @param levelCode points to an unknown exceptionLevel it would return the value that references the exceptionLevel UNKNOWN
     * this is the lightest scan
     *
     * @param levelCode the level that shows what is the level of the exception
     * @return general exception level type as string
     */
    public static String getGeneralExceptionLevelName(Integer levelCode) {
        return getExceptionLevel(levelCode).getGeneralType();
    }
}
