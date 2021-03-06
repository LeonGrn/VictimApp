package com.example.victimapp;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;

import java.util.List;

public class InstalledApplictions {

    public static List<PackageInfo> getAllInstalledAppsName(Context context){
        return context.getPackageManager().getInstalledPackages(0);

    }


    public static List<ApplicationInfo> getAllInstalledApps(Context context)
    {
        return context.getPackageManager().getInstalledApplications(0);
    }

    public static void startDesiredApplication(String packageName, Context context)
    {
        context.startActivity(context.getPackageManager().getLaunchIntentForPackage(packageName));
    }
}
