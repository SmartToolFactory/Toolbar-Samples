package com.smarttoolfactory.toolbarsamples.fragment;

import com.smarttoolfactory.toolbarsamples.R;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class OneFragment extends Fragment {
	int counter;
	Button button;
	TextView tv;

	public OneFragment() {
		// Required empty public constructor
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		System.out.println("OneFragment onCrate()");
	}

	@Override
	public void onResume() {
		super.onResume();
		System.out.println("OneFragment onResume()");
		counter = 0;
	}

	@Override
	public void onPause() {
		super.onPause();
		System.out.println("OneFragment onPause()");
	}

	@Override
	public void onStop() {
		super.onStop();
		System.out.println("OneFragment onStop()");

	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		System.out.println("OneFragment onDestroy()");
	}

	@Override
	public void onDetach() {
		super.onDetach();
		System.out.println("OneFragment onDetach()");
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		System.out.println("OneFragment onCreateView()");
		// Inflate the layout for this fragment
		View rootView = inflater.inflate(R.layout.fragment_one, container, false);
		button = (Button) rootView.findViewById(R.id.btnInc);
		tv = (TextView) rootView.findViewById(R.id.textView1);
		return rootView;
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		System.out.println("OneFragment onViewCreated()");
		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				counter++;
				tv.setText("" + counter);

			}
		});
	}

}
