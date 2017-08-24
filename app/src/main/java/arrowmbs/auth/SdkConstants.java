 

package arrowmbs.auth;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Contains all the required Constants for the SdkOAuthHelper This file is
 */
public interface SdkConstants {

    // Auto generated DO NOT CHANGE THE BELOW VALUES ------------------------------
    String BASE_PATH_URL = "https://10.129.59.159:8065/v1";
    String NAME_API_AUTH = "API Key";

    String NAME_OAUTH_IMPLICIT = "OAuthImplicit";
    String OAUTH_IMPLICIT_ENDPOINT = "https://lphxam004.lab.phx.axway.int:8089/api/oauth/authorize";
    String OAUTH_IMPLICIT_TOKEN_ENDPOINT = "";
    String OAUTH_IMPLICIT_SCOPES = "resource.WRITE,resource.READ"; 

    String NAME_OAUTH_EXPLICIT = "OAuthAccessCode";
    String OAUTH_EXPLICIT_ENDPOINT = "https://lphxam004.lab.phx.axway.int:8089/api/oauth/authorize";
    String OAUTH_EXPLICIT_TOKEN_ENDPOINT = "https://lphxam004.lab.phx.axway.int:8089/api/oauth/token";
    String OAUTH_EXPLICIT_SCOPES = "resource.WRITE,resource.READ";

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