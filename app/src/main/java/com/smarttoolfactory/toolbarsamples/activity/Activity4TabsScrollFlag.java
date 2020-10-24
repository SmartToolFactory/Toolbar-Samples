package com.smarttoolfactory.toolbarsamples.activity;


import com.google.android.material.tabs.TabLayout;
import com.smarttoolfactory.toolbarsamples.R;
import com.smarttoolfactory.toolbarsamples.activity4.FruitListFragment;
import com.smarttoolfactory.toolbarsamples.activity4.PagerAdapter;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

public class Activity4TabsScrollFlag extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.appbar4_tabs_scrollflag);

		Toolbar toolbar = (Toolbar) findViewById(R.id.id_toolbar);
		setSupportActionBar(toolbar);

		ViewPager viewPager = (ViewPager) findViewById(R.id.id_viewpager);

		PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager());
		adapter.addFragment(new FruitListFragment(), "Fruit Tab1");
		adapter.addFragment(new FruitListFragment(), "Fruit Tab2");
		adapter.addFragment(new FruitListFragment(), "Fruit Tab3");
		viewPager.setAdapter(adapter);

		TabLayout tabLayout = (TabLayout) findViewById(R.id.id_tabs);
		tabLayout.setupWithViewPager(viewPager);
	}

}
