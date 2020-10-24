package com.smarttoolfactory.toolbarsamples.activity4;

import java.util.List;

import com.smarttoolfactory.toolbarsamples.R;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

	List<String> mFruiteList;

	public static class ViewHolder extends RecyclerView.ViewHolder {

		public final View mView;

		public final TextView mTextView;

		public ViewHolder(View view) {
			super(view);
			mView = view;
			// mImageView = (ImageView) view.findViewById(R.id.avatar);
			mTextView = (TextView) view.findViewById(R.id.id_text_view);
		}
	}

	public RecyclerViewAdapter(List<String> items) {

		mFruiteList = items;
	}

	@Override
	public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

		View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_row_act4, parent, false);

		return new ViewHolder(view);
	}

	@Override
	public void onBindViewHolder(final ViewHolder holder, int position) {

		holder.mTextView.setText(mFruiteList.get(position));
	}

	@Override
	public int getItemCount() {
		return mFruiteList.size();
	}
}