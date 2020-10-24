package com.smarttoolfactory.toolbarsamples.fragment;

import com.smarttoolfactory.toolbarsamples.R;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FiveFragment extends Fragment {

	public FiveFragment() {
		// Required empty public constructor
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		System.out.println("FiveFragment onCrate()");
	}

	@Override
	public void onResume() {
		super.onResume();
		System.out.println("FiveFragment onResume()");
	}

	@Override
	public void onPause() {
		super.onPause();
		System.out.println("FiveFragment onPause()");
	}

	@Override
	public void onStop() {
		super.onStop();
		System.out.println("FiveFragment onStop()");

	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		System.out.println("FiveFragment onDestroy()");
	}

	@Override
	public void onDetach() {
		super.onDetach();
		System.out.println("FiveFragment onDetach()");
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		return inflater.inflate(R.layout.fragment_five, container, false);
	}

}
