package com.smarttoolfactory.toolbarsamples.fragment;

import com.smarttoolfactory.toolbarsamples.R;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ThreeFragment extends Fragment {

	public ThreeFragment() {
		// Required empty public constructor
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		System.out.println("ThreeFragment onCrate()");
	}

	@Override
	public void onResume() {
		super.onResume();
		System.out.println("ThreeFragment onResume()");
	}

	@Override
	public void onPause() {
		super.onPause();
		System.out.println("ThreeFragment onPause()");
	}

	@Override
	public void onStop() {
		super.onStop();
		System.out.println("ThreeFragment onStop()");

	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		System.out.println("ThreeFragment onDestroy()");
	}

	@Override
	public void onDetach() {
		super.onDetach();
		System.out.println("ThreeFragment onDetach()");
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		return inflater.inflate(R.layout.fragment_three, container, false);
	}

}
