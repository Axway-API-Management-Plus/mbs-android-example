/**
 * Axway Platform SDK
 * Copyright (c) 2017 by Axway, Inc. All Rights Reserved.
 * Proprietary and Confidential - This source code is not for redistribution
 */

package com.example.axway.mbaas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;



import net.openid.appauth.browser.BrowserWhitelist;
import net.openid.appauth.browser.VersionedBrowserMatcher;

import java.security.GeneralSecurityException;


import com.axway.arrowmbs.SdkClient;
import com.axway.arrowmbs.SdkUtils;
import com.axway.arrowmbs.auth.SdkConstants;
import com.axway.arrowmbs.auth.SdkException;
import com.axway.arrowmbs.auth.SdkIdentityProvider;
import com.axway.arrowmbs.auth.SdkOAuthHelper;
import com.example.axway.mbaas.users.UsersLogin;

public class LoginActivity extends Activity   {

    private Button btnlogin;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        SdkUtils.doNotValidateCertificates(this, true);


        try {
            BrowserWhitelist browsers = new BrowserWhitelist(VersionedBrowserMatcher.CHROME_BROWSER);
            SdkOAuthHelper.initializeOAuth(this, browsers);
        } catch (SdkException e) {
            e.printStackTrace();
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }

        btnlogin = (Button) findViewById(R.id.btn_login);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        // Get the Identity Provider Object
                     /*   final SdkIdentityProvider idp = SdkIdentityProvider.getAllIdentityProviders().get(SdkConstants.NAME_OAUTH_IMPLICIT);
                        // Set the Client ID and Client Secret
                        idp.setClientId("8554f2b6-bfad-4674-9277-6bc29e3e013d");
                        idp.setClientSecret("d6807c34-ea35-4046-9047-fb9e436a834e");*/

                        // Start the actual Login process
                     /*   try {
                            SdkOAuthHelper.getInstance().doOAuth3Legged(idp,LoginActivity.this, MainActivity.class);
                        } catch (SdkException e) {
                            e.printStackTrace();
                        }*/
                        try {
                            SdkClient.getInstance().setAuthenticationType(SdkConstants.NAME_API_AUTH);
                            SdkClient.getInstance().setApiKey("51145b21-7d4d-4d55-9796-4ea9f9fc36d5");
                           // SdkClient.getInstance().setApiKey("d8da6ac0-bdd3-462d-89f9-1e9dde8b96ab");

                            //SdkClient.getInstance().setApiKey("576LLsCHaWAR2gQv9VqB91BLgDfBzMKX");
                            /*SdkClient.getInstance().addDefaultHeader("KeyId","51145b21-7d4d-4d55-9796-4ea9f9fc36d5");*/
                            Intent i = new Intent(getApplicationContext(), MainActivity.class);
                            //startActivityForResult(i,200);
                            startActivity(i);
                        } catch (SdkException e) {
                            e.printStackTrace();
                        }
                        //
                        //SdkOAuthHelper.getInstance().doOAuth3Legged(idp, context, TestNewActivity.class); // If call back has to processed in another class

                    }
                }).start();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==resultCode)
        {
            Intent i = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(i);
        }
        else {
            Intent i = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(i);
        }
    }
}



