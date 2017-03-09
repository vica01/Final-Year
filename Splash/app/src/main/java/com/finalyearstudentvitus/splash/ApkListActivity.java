package com.finalyearstudentvitus.splash;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ToggleButton;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Emmanuel on 2/24/2017.
 */

public class ApkListActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    PackageManager packageManager;
    ListView apkList;
    private static final String TAG = "SplashMessage";
    ToggleButton sysapp;
    TextView edit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "Now creating appops2 view");
        setContentView(R.layout.appops2);

        edit = (TextView) findViewById(R.id.installedapps);
        Log.i(TAG, "now running default first(); ");
        first();
        Log.i(TAG, "finished default first(); run");

        sysapp = (ToggleButton) findViewById(R.id.toggleButton);

        sysapp.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Log.i(TAG, "filter btn checked:now running second(); ");
                    second();
                    edit.setText("Installed Apps + System Apps");
                }
                else
                {
                    first();
                    edit.setText("Installed Apps (Third Party Apps)");
                }
            }
        });



    }

    public void first ()
    {
        packageManager = getPackageManager();
        List<PackageInfo> packageList = packageManager.getInstalledPackages(PackageManager.GET_PERMISSIONS);

        List<PackageInfo> packageList1 = new ArrayList<PackageInfo>();

        /*To filter out System apps*/
        for(PackageInfo pi : packageList) {
            boolean b = isSystemPackage(pi);
            if(!b) {
                packageList1.add(pi);
            }
        }

        Log.i(TAG, "Now Entering Try in first()");
        try {
            apkList = (ListView) findViewById(R.id.applist);
            apkList.setAdapter(new ApkAdapter(this, packageList1, packageManager));
            apkList.setOnItemClickListener(this);
        }
        catch (Exception e)
        {
            Log.e(TAG, "error in catch method in first()");
        }
        Log.i(TAG, "done with try and catch in first(); ");
    }

    public void second ()
    {
        packageManager = getPackageManager();
        List<PackageInfo> packageList = packageManager.getInstalledPackages(PackageManager.GET_PERMISSIONS);

        List<PackageInfo> packageList1 = new ArrayList<PackageInfo>();

        /*To filter in System apps*/
        for(PackageInfo pi : packageList) {
            boolean b = isSystemPackage(pi);
            if(b) {
                packageList1.add(pi);
            }
        }

        Log.i(TAG, "Now Entering Try in second()");
        try {
            apkList = (ListView) findViewById(R.id.applist);
            apkList.setAdapter(new ApkAdapter(this, packageList1, packageManager));
            apkList.setOnItemClickListener(this);
        }
        catch (Exception e)
        {
            Log.e(TAG, "error in catch method in second()");
        }
        Log.i(TAG, "done with try and catch in second(); ");

    }





    /**
     * Return whether the given PackgeInfo represents a system package or not.
     * User-installed packages (Market or otherwise) should not be denoted as
     * system packages.
     *
     * @param pkgInfo
     * @return boolean
     */


    private boolean isSystemPackage(PackageInfo pkgInfo) {
        return ((pkgInfo.applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) != 0) ? true
                : false;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
                            long row)
    {
        try
        {
            PackageInfo packageInfo = (PackageInfo) parent.getItemAtPosition(position);
            AppData appData = (AppData) getApplicationContext();
            appData.setPackageInfo(packageInfo);
        }
        catch (Exception e)
        {
            Log.e(TAG, "Error error in initialization");
        }

        try {
            Intent appInfo = new Intent(getApplicationContext(), ApkInfo.class);
            startActivity(appInfo);
        }

        catch (Exception e)
        {
            Log.e(TAG, "error in intent");
        }

    }
}
