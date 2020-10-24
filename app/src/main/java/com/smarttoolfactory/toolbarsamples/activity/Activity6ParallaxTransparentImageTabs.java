package com.smarttoolfactory.toolbarsamples.activity;

import com.google.android.material.tabs.TabLayout;
import com.smarttoolfactory.toolbarsamples.R;

import android.os.Bundle;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.smarttoolfactory.toolbarsamples.fragment.OneFragment;
import com.smarttoolfactory.toolbarsamples.fragment.ThreeFragment;
import com.smarttoolfactory.toolbarsamples.fragment.TwoFragment;
import com.smarttoolfactory.toolbarsamples.fragment.ViewPagerAdapter;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.view.MenuItem;

public class Activity6ParallaxTransparentImageTabs extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.appbar6_parallax_image_tabs);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        setupViewPager(viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(viewPager);

        final CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(
                R.id.collapsingToolbarLayout);
        collapsingToolbarLayout.setTitleEnabled(false);


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
