 

package com.axway.arrowmbs.auth;

/**
 * Contains all the required Constants for the SdkOAuthHelper This file is
 */
public interface SdkConstants {

    // Auto generated DO NOT CHANGE THE BELOW VALUES ------------------------------
    String BASE_PATH_URL = "https://lphxam004.lab.phx.axway.int:8065/v1";
    //String BASE_PATH_URL = "https://champs-api.cloudapp-1.appctest.com/v1";

    //String BASE_PATH_URL =  "https://52.161.100.151:8065/v1";

    String NAME_API_AUTH = "API Key";

  String NAME_NO_AUTH = "";


  // Auto generated END ------------------------------

  // Auto generated but can be changed by user
  String REDIRECT_SCHEME = "https";
  String REDIRECT_HOST = "www.axwayapp.com";
  String REDIRECT_PATH = "/auth/callback";

  // Required by the application DO NOT CHANGE ------------------
  /**
   * Shared Prefs store name
   */
  String SHARED_PREFS_STORE_NAME = "axway_auth_store";

  /**
   * Shared Prefs Key Name
   */
  String SHARED_PREFS_KEY_NAME = "state_json";

}