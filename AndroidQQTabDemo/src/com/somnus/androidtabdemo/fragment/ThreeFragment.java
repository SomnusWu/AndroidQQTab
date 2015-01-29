package com.somnus.androidtabdemo.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.somnus.androidtabdemo.R;

@SuppressLint("NewApi")
public class ThreeFragment extends Fragment {
	private Context mContext;
	private View mBaseView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		mBaseView = inflater.inflate(R.layout.fragment_three, null);
		return mBaseView;
	}
}
