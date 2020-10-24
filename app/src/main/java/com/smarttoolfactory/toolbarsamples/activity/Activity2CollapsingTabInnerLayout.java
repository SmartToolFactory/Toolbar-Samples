package com.smarttoolfactory.toolbarsamples.activity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.smarttoolfactory.toolbarsamples.R;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;

public class Activity2CollapsingTabInnerLayout extends AppCompatActivity {

	FloatingActionButton fab;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.appbar2_collapsingtab_innerlayout);

		fab = (FloatingActionButton) findViewById(R.id.fab);
		fab.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Snackbar.make(v, "Calibration", Snackbar.LENGTH_SHORT).show();
			}
		});
	}

}
