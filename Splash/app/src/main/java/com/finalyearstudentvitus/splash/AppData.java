package com.finalyearstudentvitus.splash;

import android.app.Application;
import android.content.pm.PackageInfo;

/**
 * Created by Emmanuel on 2/24/2017.
 */

public class AppData extends Application {
    PackageInfo packageInfo;

    public PackageInfo getPackageInfo() {
        return packageInfo;
    }

    public void setPackageInfo(PackageInfo packageInfo) {
        this.packageInfo = packageInfo;
    }
}
