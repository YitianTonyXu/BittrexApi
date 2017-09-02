package com.corycharlton.bittrexapi.internal.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;

import com.corycharlton.bittrexapi.BittrexApiLibraryInfo;


public final class Utils {
    public static String getUserAgent(@NonNull Context context, @NonNull String applicationName) {
        // TODO: Load the application name from package?
        String versionName;
        try {
            String packageName = context.getPackageName();
            PackageInfo info = context.getPackageManager().getPackageInfo(packageName, 0);
            versionName = info.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            versionName = "?";
        }
        return applicationName + "/" + versionName + " (Linux;Android " + Build.VERSION.RELEASE
                + ") " + BittrexApiLibraryInfo.USERAGENT_VERSION;
    }

    private Utils() {} // Cannot instantiate
}
