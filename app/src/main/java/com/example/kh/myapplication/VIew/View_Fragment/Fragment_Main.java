package com.example.kh.myapplication.VIew.View_Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kh.myapplication.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Main extends Fragment {


    public Fragment_Main() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment__main, container, false);
    }

}
