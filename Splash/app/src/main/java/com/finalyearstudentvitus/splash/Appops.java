package com.finalyearstudentvitus.splash;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;


/**
 * Created by Emmanuel on 2/14/2017.
 */

public class Appops extends Fragment  {

    Button continuebtn;

    PackageManager packageManager;
    ListView apkList;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.appops, container, false);


        continuebtn = (Button) rootView.findViewById(R.id.continuebtn);

        continuebtn.setOnClickListener(contbtn);

        return rootView;
    }


        private View.OnClickListener contbtn = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Appops.this.getActivity(), ApkListActivity.class);
                Appops.this.startActivity(i);
            }
        };




}
