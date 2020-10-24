package com.smarttoolfactory.toolbarsamples.fragment;

import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import android.view.ViewGroup;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
	private final List<Fragment> mFragmentList = new ArrayList<>();
	private final List<String> mFragmentTitleList = new ArrayList<>();

	public ViewPagerAdapter(FragmentManager manager) {
		super(manager);
	}

	@Override
	public Fragment getItem(int position) {
		return mFragmentList.get(position);
	}

	@Override
	public int getCount() {
		return mFragmentList.size();
	}

	@Override
	public CharSequence getPageTitle(int position) {
		return mFragmentTitleList.get(position);
	}

	public void addFragment(Fragment fragment, String title) {
		mFragmentList.add(fragment);
		mFragmentTitleList.add(title);
	}

	// TODO Uncomment to recreate fragments with notifyDataSetChanged()
	@Override
	public int getItemPosition(Object object) {
		return POSITION_NONE;
	}

	@Override
	public Object instantiateItem(ViewGroup arg0, int arg1) {

		return super.instantiateItem(arg0, arg1);
	}

}