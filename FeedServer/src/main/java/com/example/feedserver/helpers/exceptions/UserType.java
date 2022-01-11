package com.example.feedserver.helpers.exceptions;

public enum UserType {
    UNSPECIFIED(0, "UNSPECIFIED"),
    UNKNOWN(10, "UNSPECIFIED"),
    VIEWER(20, "UNSPECIFIED"),
    GUEST(30, "UNSPECIFIED"),
    USER(100, "user"),
    STUDENT(200, "student"),
    COMMANDER(300, "commander"),
    MAKAS(400, "makas"),
    RAMAD(500, "ramad"),
    RAAN(600, "raan"),
    SYSTEM(1000, "system"),
    SYSTEM_MANAGER(1100, "system manager"),
    DEVELOPER(1200, "developer");


    private final Integer levelCode;
    private final String generalType;

    UserType(Integer userLevel, String generalType) {
        this.levelCode = userLevel;
        this.generalType = generalType;
    }

    public Integer getLevelCode() {
        return levelCode;
    }

    public String getGeneralType() {
        return generalType;
    }

    public String getType() {
        return "name(): " + this.name() + "\ntoString(): " + this.toString();
    }


    public static UserType getUserType(Integer levelCode) {
        if (levelCode < 0) return UNKNOWN;
        for (UserType userType :
                UserType.class.getEnumConstants()) {
            if (levelCode.equals(userType.getLevelCode())) {
                return userType;
            }
        }
        return getGeneralUserType(levelCode);
    }


    public static UserType getGeneralUserType(Integer levelCode) {
        if (levelCode < 0) return UNKNOWN;
        for (UserType userType :
                UserType.class.getEnumConstants()) {
            if (userType.getLevelCode().equals(levelCode - levelCode % 100)) {
                return userType;
            }
        }
        return UNKNOWN;
    }

    /**
     * uses the getUserType() method, and then applies the getType() method on the return value
     * if the @param levelCode points to an unknown userType it would return the value that references the user UNKNOWN
     * this scan is a bit harder then getUserGeneralTypeName(), but get more accurate result
     *
     * @param levelCode the level that shows which user caused the problem
     * @return general user type as string
     */
    public static String getUserTypeName(Integer levelCode) {
        return getUserType(levelCode).getType();
    }

    /**
     * uses the getGeneralUserType() method, and then applies the getGeneralType() method on the return value
     * if the @param levelCode points to an unknown userType it would return the value that references the user UNKNOWN
     * this is the lightest scan
     *
     * @param levelCode the level that shows which user caused the problem
     * @return general user type as string
     */
    public static String getGeneralUserTypeName(Integer levelCode) {
        return getGeneralUserType(levelCode).getGeneralType();
    }
}