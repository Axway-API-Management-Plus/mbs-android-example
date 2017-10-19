/**
 * Axway Platform SDK
 * Copyright (c) 2017 by Axway, Inc. All Rights Reserved.
 * Proprietary and Confidential - This source code is not for redistribution
 */

package com.example.axway.mbaas.users;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.axway.arrowmbs.SdkClient;
import com.axway.arrowmbs.apis.DefaultAPI;
import com.axway.arrowmbs.auth.SdkCookiesHelper;
import com.axway.arrowmbs.SdkException;
import com.example.axway.mbaas.R;
import com.example.axway.mbaas.StableArrayAdapter;
import com.example.axway.mbaas.Utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

import static com.example.axway.mbaas.Utils.handleErrorInResponse;
import static com.example.axway.mbaas.Utils.handleException;
import static com.example.axway.mbaas.Utils.handleSDKExcpetion;


public class UsersRemove extends Activity {
    private static UsersRemove currentActivity;
    private EditText usernameField;
    JSONObject postbody = new JSONObject();
    String userid = new String();
    private JSONArray users;
    private Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.users_remove);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        currentActivity = this;
        usernameField = (EditText) findViewById(R.id.users_delete_username_field);
        new AlertDialog.Builder(currentActivity)
                .setTitle("Are you Admin User?").setMessage("Please Login as a Admin User before Delete Operation is performed.")
                .setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        Intent k = new Intent(getApplicationContext(), UsersLogin.class);
                        startActivity(k);
                    }
                }).setPositiveButton(R.string.yes, null)
                .setIcon(android.R.drawable.ic_dialog_info)
                .show();
        button1 = (Button) findViewById(R.id.users_remove_button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (usernameField.getText().toString().isEmpty()) {
                    usernameField.requestFocus();

                } else {
                    try {
                        postbody.put("username", usernameField.getText().toString());
                        new userQuery().execute();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    submitForm();
                }
            }
        });

    }

    @Override
    protected void onDestroy() {
        currentActivity = null;
        super.onDestroy();
    }

    private void submitForm() {
        button1.setVisibility(View.GONE);
            new deleteUser().execute();
    }


    private class userQuery extends AsyncTask<Void, Void, JSONObject> {
        private ProgressDialog dialog = new ProgressDialog(currentActivity);

        JSONObject successResponse;

        @Override
        protected void onPreExecute() {
            {
                try {
                    postbody.put("username", usernameField.getText().toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

        }

        @Override
        protected JSONObject doInBackground(Void... voids) {
            try {
                successResponse = new DefaultAPI(SdkClient.getInstance()).usersQuery(null, null, null, null, postbody.toString(), null, null, null, null, null, null);
            } catch (SdkException e) {
                Utils.handleSDKExcpetion(e, currentActivity);
            }
            return successResponse;
        }

        @Override
        protected void onPostExecute(JSONObject xml) {
            if (dialog.isShowing()) {
                dialog.dismiss();
            }

            try {
                users = successResponse.getJSONObject("response").getJSONArray("users");

                final ArrayList<String> objectsList = new ArrayList<String>();
                for (int i = 0; i < users.length(); i++) {
                    JSONObject user = users.getJSONObject(i);
                    if (!user.get("id").toString().isEmpty())
                        userid= user.get("id").toString();
                }
                if (objectsList.size() <= 0) {
                    objectsList.add("No Results!");
                }
                // Load listView rows
            } catch (JSONException e) {
                Utils.handleException(e, currentActivity);
            }
        }
    }
    private class deleteUser extends AsyncTask<Void, Void, JSONObject> {
        private ProgressDialog dialog = new ProgressDialog(currentActivity);

        JSONObject successResponse;
        private SdkException exceptionThrown = null;

        @Override
        protected void onPreExecute() {

        }

        @Override
        protected JSONObject doInBackground(Void... voids) {
            try {
                successResponse = new DefaultAPI(SdkClient.getInstance()).usersDelete(userid,null,null);
            } catch (SdkException e) {
                exceptionThrown = e;
            }
            return successResponse;
        }

        @Override
        protected void onPostExecute(JSONObject xml) {
            if (dialog.isShowing()) {
                dialog.dismiss();
            }
            try {
                if (exceptionThrown == null && successResponse.getJSONObject("meta").get("status").toString().equalsIgnoreCase("ok")) {
                    new AlertDialog.Builder(currentActivity)
                            .setTitle("Success!").setMessage("Removed!")
                            .setPositiveButton(android.R.string.ok, null)
                            .setIcon(android.R.drawable.ic_dialog_info)
                            .show();
                } else
                    handleSDKExcpetion(exceptionThrown, currentActivity);
            } catch (JSONException e) {
                handleException(e, currentActivity);
            }
        }
    }
}