package com.smarttoolfactory.toolbarsamples.activity;

import com.google.android.material.tabs.TabLayout;
import com.smarttoolfactory.toolbarsamples.R;
import com.smarttoolfactory.toolbarsamples.fragment.FourFragment;
import com.smarttoolfactory.toolbarsamples.fragment.OneFragment;
import com.smarttoolfactory.toolbarsamples.fragment.ThreeFragment;
import com.smarttoolfactory.toolbarsamples.fragment.TwoFragment;
import com.smarttoolfactory.toolbarsamples.fragment.ViewPagerAdapter;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.view.MenuItem;

public class Activity5CollapseTabsToolbar extends AppCompatActivity {

	private Toolbar toolbar;
	private TabLayout tabLayout;
	private ViewPager viewPager;
	ViewPagerAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.appbar5_collapse_tabs_toolbar);

		toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);

		getSupportActionBar().setDisplayHomeAsUpEnabled(true);

		viewPager = (ViewPager) findViewById(R.id.viewpager);
		setupViewPager(viewPager);
		tabLayout = (TabLayout) findViewById(R.id.tabs);
		tabLayout.setupWithViewPager(viewPager);

		viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

			@Override
			public void onPageSelected(int arg0) {
				adapter.notifyDataSetChanged();
				// System.out.println("Viewpager onPageSelected: " + arg0);
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
			}

			@Override
			public void onPageScrollStateChanged(int arg0) {

			}
		});
	}

	private void setupViewPager(ViewPager viewPager) {
		adapter = new ViewPagerAdapter(getSupportFragmentManager());
		adapter.addFragment(new OneFragment(), "FIRST");
		adapter.addFragment(new TwoFragment(), "SECOND");
		adapter.addFragment(new ThreeFragment(), "THIRD");
		adapter.addFragment(new FourFragment(), "FOURTH");
		adapter.addFragment(new OneFragment(), "FIRST");
		adapter.addFragment(new TwoFragment(), "SECOND");
		adapter.addFragment(new ThreeFragment(), "THIRD");
		adapter.addFragment(new FourFragment(), "FOURTH");
		viewPager.setAdapter(adapter);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			finish();
			return true;
		case R.id.action_settings:
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
