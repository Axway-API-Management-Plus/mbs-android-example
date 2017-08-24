 

package arrowmbs;

import java.text.DateFormat;
import java.util.Date;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.security.ProviderInstaller;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.content.Intent;

import net.openid.appauth.AuthorizationRequest;

/**
 * Contains mostly static methods that are useful across the Generated code
 */

public class SdkUtils {

 /**
   * In cases where the device API Level is below 5.0. (API Level - 21) - TLSv1.1 and TLSv1.2 protocols are not enabled by default. - SSLv3 protocol is not disabled by default. - SSLv3 is not a secure protocol and it is therefore desirable to remove it from our client's list of supported protocols.
   * Android's security `Provider` is needs to be updated before a connection is made so that we disable SSLv3. This is done by using Google Play services Auth package.
   *
   * @param callingActivity Current {@link Activity}
   */
  private static void updateAndroidSecurityProvider(Activity callingActivity) {

    if (checkPlayServices(callingActivity)) {
      ProviderInstaller.installIfNeededAsync(callingActivity, new ProviderInstaller.ProviderInstallListener() {
        @Override
        public void onProviderInstalled() {
          Log.d("SdkUtils", "New security provider installed.");
        }

        @Override
        public void onProviderInstallFailed(int errorCode, Intent intent) {
          Log.e("SdkUtils", "New security provider install failed.");
          // No notification shown there is no user intervention needed.
        }
      });
    }

  }

  /**
   * Checks if the PlayServices is available and if not prompts user to install/update
   *
   * @param activity Current {@link Activity}
   * @return boolean.
   */
  private static boolean checkPlayServices(Activity activity) {
    GoogleApiAvailability googleAPI = GoogleApiAvailability.getInstance();
    int result = googleAPI.isGooglePlayServicesAvailable(activity);
    if (result != ConnectionResult.SUCCESS) {
      if (googleAPI.isUserResolvableError(result)) {
        googleAPI.getErrorDialog(activity, result, 9000).show();
      }

      return false;
    }

    return true;
  }

  /**
   * This is the only method in the class that requires Activity Object
   *
   * @param activity {@link Activity} Is null if SDK level > 21
   * @param doNotValidate true when certificates are bypassed
   */
  public static void doNotValidateCertificates(@Nullable Activity activity, boolean doNotValidate) {
    if (doNotValidate) {
      if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.LOLLIPOP && activity != null) {

        SdkUtils.updateAndroidSecurityProvider(activity);
      }
      AuthorizationRequest.doNotValidateCertificate(true); // certificate bypass ON

    }
  }

  /**
   * Format the given Date object into string.
   */
  public static String formatDate(@NonNull DateFormat dateFormat, @NonNull Date date) {
    return dateFormat.format(date);
  }

  /**
   * Checks if a particular Package is available in the device
   *
   * @param packagename {@link String} Package name
   * @param packageManager {@link PackageManager} object from the context
   * @return boolean true if present, false otherwise
   */
  public static boolean isPackageInstalled(String packagename, PackageManager packageManager) {
    try {
      packageManager.getPackageInfo(packagename, 0);
      return true;
    } catch (PackageManager.NameNotFoundException e) {
      return false;
    }
  }


  public static boolean isCurrentlyOnMainUIThread() {
    if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
      // On UI thread.
      return true;
    } else {
      return false;
    }
  }

}
