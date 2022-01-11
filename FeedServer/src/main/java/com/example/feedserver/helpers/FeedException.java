package com.example.feedserver.helpers;

import com.example.feedserver.helpers.exceptions.ExceptionLevel;
import com.example.feedserver.helpers.exceptions.UserType;

import java.security.PrivilegedActionException;

public class FeedException extends Exception {

    private ExceptionLevel exceptionLevel;
    private UserType userType;


    private void insertValues(ExceptionLevel exceptionLevel, UserType userType) {
        this.exceptionLevel = exceptionLevel;
        this.userType = userType;
    }

    public FeedException() {
        super();
        this.insertValues(ExceptionLevel.ERROR, UserType.SYSTEM);
    }

    public FeedException(UserType userType) {
        super();
        this.insertValues(ExceptionLevel.ERROR, userType);
    }

    public FeedException(ExceptionLevel exceptionLevel) {
        super();
        this.insertValues(exceptionLevel, UserType.SYSTEM);
    }

    public FeedException(ExceptionLevel exceptionLevel, UserType userType) {
        super();
        this.insertValues(exceptionLevel, userType);
    }

    public FeedException(String message) {
        super(message);
        this.insertValues(ExceptionLevel.ERROR, UserType.SYSTEM);
    }

    public FeedException(String message, UserType userType) {
        super(message);
        this.insertValues(ExceptionLevel.ERROR, userType);
    }

    public FeedException(String message, ExceptionLevel exceptionLevel) {
        super(message);
        this.insertValues(exceptionLevel, UserType.SYSTEM);
    }

    public FeedException(String message, ExceptionLevel exceptionLevel, UserType userType) {
        super(message);
        this.exceptionLevel = exceptionLevel;
        this.userType = userType;
    }

    public FeedException(String message, Throwable cause, ExceptionLevel exceptionLevel, UserType userType) {
        super(message, cause);
        this.exceptionLevel = exceptionLevel;
        this.userType = userType;
    }

    public FeedException(Throwable cause, ExceptionLevel exceptionLevel, UserType userType) {
        super(cause);
        this.exceptionLevel = exceptionLevel;
        this.userType = userType;
    }

    public FeedException(Throwable cause) {
        super(cause);
        this.exceptionLevel = ExceptionLevel.ERROR;
        this.userType = UserType.SYSTEM;
    }

    public FeedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, ExceptionLevel exceptionLevel, UserType userType) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.exceptionLevel = exceptionLevel;
        this.userType = userType;
    }


    public ExceptionLevel getExceptionLevel() {
        return exceptionLevel;
    }

    public UserType getUserType() {
        return userType;
    }

    /**
     * Returns a short description of this throwable.
     * The result is the concatenation of:
     * <ul>
     * <li> the {@linkplain Class#getName() name} of the class of this object
     * <li> ": " (a colon and a space)
     * <li> the result of invoking this object's {@link #getLocalizedMessage}
     *      method
     * </ul>
     * If {@code getLocalizedMessage} returns {@code null}, then just
     * the class name is returned.
     *
     * @return a string representation of this throwable.
     */
    @Override
    public String toString() {
        return "FEED EXCEPTION - " + super.toString() +
                "\nexception level: " + this.exceptionLevel.getType() +
                "\ncause type: " + this.userType.getType();
    }
}
