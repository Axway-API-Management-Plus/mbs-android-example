/**
 * Axway Platform SDK
 * Copyright (c) 2017 by Axway, Inc. All Rights Reserved.
 * Proprietary and Confidential - This source code is not for redistribution
 */
package com.example.axway.mbaas.users;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

import com.axway.arrowmbs.SdkClient;
import com.axway.arrowmbs.apis.DefaultAPI;
import com.axway.arrowmbs.auth.SdkCookiesHelper;
import com.axway.arrowmbs.auth.SdkException;
import com.example.axway.mbaas.ExceptionHandler;
import com.example.axway.mbaas.R;
import com.example.axway.mbaas.Utils;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.concurrent.CountDownLatch;

import static com.example.axway.mbaas.Utils.handleErrorInResponse;
import static com.example.axway.mbaas.Utils.handleException;
import static com.example.axway.mbaas.Utils.handleSDKExcpetion;


public class UsersLogout extends Activity {
	private static UsersLogout currentActivity;
	JSONObject response;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.users_logout);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		currentActivity = this;

		new apiTask().execute();

	}
	
	@Override
	protected void onDestroy() {
		currentActivity = null;
		super.onDestroy();
	}

	private class apiTask extends AsyncTask<Void, Void, JSONObject> {
		private SdkException exceptionThrown =null;

		JSONObject successResponse;

		@Override
		protected void onPreExecute() {
			try {
				if(SdkCookiesHelper.getInstance().isAvailable())
                    SdkCookiesHelper.getInstance().logoutUser();
			} catch (SdkException e) {
				e.printStackTrace();
			}
		}
		@Override
		protected JSONObject doInBackground(Void... voids) {
			try {
				successResponse = new DefaultAPI(SdkClient.getInstance()).usersLogoutUser();
			} catch (SdkException e) {
				exceptionThrown = e;
			}
			return successResponse;
		}

		@Override
		protected void onPostExecute(JSONObject xml) {
			try {
				if(exceptionThrown == null && xml.getJSONObject("meta").get("status").toString().equalsIgnoreCase("ok"))
                {
                    ((TextView) findViewById(R.id.users_logout_text_view1)).setText("Logged out!");
                }
                else
                    handleSDKExcpetion(exceptionThrown,currentActivity);
			} catch (JSONException e) {
				handleException(e,currentActivity);
			}

		}
	}
}
