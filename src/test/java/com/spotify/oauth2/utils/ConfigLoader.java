package com.spotify.oauth2.utils;

import java.util.Properties;

public class ConfigLoader {

    private  final Properties properties;
    private static ConfigLoader configLoader;

    private ConfigLoader() {
        properties = PropertyUtils.propertyLoader("src/test/resources/config.properties");
    }
    public static ConfigLoader getInstance() {
        if (configLoader == null) {
            configLoader = new ConfigLoader();
        }
        return configLoader;
    }
    public String getClientId() {
        String clientId = properties.getProperty("client_id");
        if (clientId != null) return clientId;
        else throw new RuntimeException("Client Id is not specified in the config.properties file");
    }
    public String getClientSecret() {
        String clientSecret = properties.getProperty("client_secret");
        if (clientSecret != null) return clientSecret;
        else throw new RuntimeException("Client Secret is not specified in the config.properties file");
    }
    public String getRefreshToken() {
        String refreshToken = properties.getProperty("refresh_token");
        if (refreshToken != null) return refreshToken;
        else throw new RuntimeException("Refresh Token is not specified in the config.properties file");
    }
    public String grantType() {
        String baseUri = properties.getProperty("grant_type");
        if (baseUri != null) return baseUri;
        else throw new RuntimeException("Grant Type is not specified in the config.properties file");
    }
}
