package com.example.kh.myapplication.VIew.View_Fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kh.myapplication.Module.Comunicater;
import com.example.kh.myapplication.Module.MyRecycle;
import com.example.kh.myapplication.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Navigation extends Fragment  {
    RecyclerView recyclerView;
    List<Comunicater> list;
    String[] stringTitle = new String[]{"mot","hai","ba","bon","nam"};
    int[] intIm = new int[]{R.mipmap.ic_launcher_round,R.mipmap.ic_launcher_round,R.mipmap.ic_launcher_round,R.mipmap.ic_launcher_round,R.mipmap.ic_launcher_round};
    public Fragment_Navigation() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment__navigation, container, false);
        recyclerView  = (RecyclerView) view.findViewById(R.id.recycle);
        return view;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        final MyRecycle adapter = new MyRecycle(getActivity(), R.layout.menu_navigation, getList());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);


        }



    public List<Comunicater> getList(){
        list = new ArrayList<>();
        for(int i  = 0 ; i<stringTitle.length && i<intIm.length; i++){
            Comunicater comunicater = new Comunicater();
            comunicater.icon = intIm[i];
            comunicater.title = stringTitle[i];
            list.add(comunicater);
        }
        return list;


    }






}
