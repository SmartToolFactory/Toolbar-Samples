package com.smarttoolfactory.toolbarsamples.activity4;

import java.util.Arrays;
import java.util.List;

import com.smarttoolfactory.toolbarsamples.R;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FruitListFragment extends Fragment {

    public static final String[] FruiteList = {"Apple", "Orange", "Mango", "Grapes", "Jackfruit","pomegranate","Apple", "Orange", "Mango", "Grapes", "Jackfruit","pomegranate",
            "Apple", "Orange", "Mango", "Grapes", "Jackfruit","pomegranate","Apple", "Orange", "Mango", "Grapes", "Jackfruit","pomegranate",
            "Apple", "Orange", "Mango", "Grapes", "Jackfruit","pomegranate",
            "Apple", "Orange", "Mango", "Grapes", "Jackfruit","pomegranate",
            "Apple", "Orange", "Mango", "Grapes", "Jackfruit","pomegranate","Apple", "Orange", "Mango", "Grapes", "Jackfruit","pomegranate","Apple", "Orange", "Mango", "Grapes", "Jackfruit","pomegranate",
            "Apple", "Orange", "Mango", "Grapes", "Jackfruit","pomegranate","Apple", "Orange", "Mango", "Grapes", "Jackfruit","pomegranate",
            "Apple", "Orange", "Mango", "Grapes", "Jackfruit","pomegranate",
            "Apple", "Orange", "Mango", "Grapes", "Jackfruit","pomegranate",
            "Apple", "Orange", "Mango", "Grapes", "Jackfruit","pomegranate" };

    //convert array to list
    List<String> fruiteslist = Arrays.asList(FruiteList);

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        RecyclerView rv = (RecyclerView) inflater.inflate(
                R.layout.fruitlist_layout_act4, container, false);

        rv.setLayoutManager(new LinearLayoutManager(rv.getContext()));

        rv.setAdapter(new RecyclerViewAdapter(fruiteslist));

        return rv;
    }
}