package com.example.axway.mbsandroid;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import arrowmbs.SdkUtils;
import arrowmbs.auth.SdkConstants;
import arrowmbs.auth.SdkException;
import arrowmbs.auth.SdkIdentityProvider;
import arrowmbs.auth.SdkOAuthHelper;

import net.openid.appauth.browser.BrowserWhitelist;
import net.openid.appauth.browser.VersionedBrowserMatcher;

import java.security.GeneralSecurityException;



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
                        try {
                            // Get the Identity Provider Object
                            final SdkIdentityProvider idp = SdkIdentityProvider.getAllIdentityProviders().get(SdkConstants.NAME_OAUTH_IMPLICIT);
                            // Set the Client ID and Client Secret
                            idp.setClientId("8554f2b6-bfad-4674-9277-6bc29e3e013d");
                            idp.setClientSecret("d6807c34-ea35-4046-9047-fb9e436a834e");

                            // Start the actual Login process
                            SdkOAuthHelper.getInstance().doOAuth3Legged(idp,LoginActivity.this, MainActivity.class);
                            //SdkOAuthHelper.getInstance().doOAuth3Legged(idp, context, TestNewActivity.class); // If call back has to processed in another class

                        } catch (SdkException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
        });
    }
    }



