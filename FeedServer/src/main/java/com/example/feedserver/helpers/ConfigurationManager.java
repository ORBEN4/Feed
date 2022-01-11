package com.example.feedserver.helpers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.lang.Nullable;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;

import java.io.IOException;
import java.util.Properties;

//@PropertySource("classpath:application.properties")
public class ConfigurationManager {
//    @Autowired
//    private Environment environment;
    private static ConfigurationManager instance = null;
    private final Properties properties;


    public static ConfigurationManager getInstance() throws FeedException {
        if (instance == null) {
            instance = new ConfigurationManager();
        }
        return instance;
    }

    private ConfigurationManager() throws FeedException {
        try {
            this.properties = new Properties();
            this.properties.load(this.getClass().getClassLoader().getResourceAsStream("application.properties"));
        } catch (IOException e) {
            throw new FeedException("failed to load configuration");
        }
    }

    public boolean isInitialized() {
        return this.properties != null;
    }
//
//    public String[] getActiveProfiles() {
//        return this.environment.getActiveProfiles();
//    }
//
//    public String[] getDefaultProfiles() {
//        return this.environment.getDefaultProfiles();
//    }
//
//    /**
//     * @param profiles
//     * @deprecated
//     */
//    @Deprecated
//    public boolean acceptsProfiles(String... profiles) {
//        return this.environment.acceptsProfiles(profiles);
//    }
//
//    public boolean acceptsProfiles(Profiles profiles) {
//        return this.environment.acceptsProfiles(profiles);
//    }
//
//    public boolean containsProperty(String key) {
//        return this.environment.containsProperty(key);
//    }

    @Nullable
    public String getProperty(String key) {
        return this.properties.getProperty(key);
    }

    public String getProperty(String key, String defaultValue) {
        return this.properties.getProperty(key, defaultValue);
    }
//
//    @Nullable
//    public <T> T getProperty(String key, Class<T> targetType) {
//        return this.environment.getProperty(key, targetType);
//    }
//
//    public <T> T getProperty(String key, Class<T> targetType, T defaultValue) {
//        return this.environment.getProperty(key, targetType, defaultValue);
//    }
//
//    public String getRequiredProperty(String key) throws IllegalStateException {
//        return this.environment.getRequiredProperty(key);
//    }
//
//    public <T> T getRequiredProperty(String key, Class<T> targetType) throws IllegalStateException {
//        return this.environment.getRequiredProperty(key, targetType);
//    }
//
//    public String resolvePlaceholders(String text) {
//        return this.environment.resolvePlaceholders(text);
//    }
//
//    public String resolveRequiredPlaceholders(String text) throws IllegalArgumentException {
//        return this.environment.resolveRequiredPlaceholders(text);
//    }
}
