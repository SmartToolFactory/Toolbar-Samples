package com.smarttoolfactory.toolbarsamples.fragment;

import com.smarttoolfactory.toolbarsamples.R;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class TwoFragment extends Fragment {

	public TwoFragment() {
		// Required empty public constructor
	}

	@Override
	public void onResume() {
		super.onResume();
		System.out.println("TwoFragment onResume()");
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		System.out.println("TwoFragment onCrate()");
	}

	@Override
	public void onPause() {
		super.onPause();
		System.out.println("TwoFragment onPause()");
	}

	@Override
	public void onStop() {
		super.onStop();
		System.out.println("TwoFragment onStop()");

	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		System.out.println("TwoFragment onDestroy()");
	}

	@Override
	public void onDetach() {
		super.onDetach();
		System.out.println("TwoFragment onDetach()");
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		return inflater.inflate(R.layout.fragment_two, container, false);
	}

}
