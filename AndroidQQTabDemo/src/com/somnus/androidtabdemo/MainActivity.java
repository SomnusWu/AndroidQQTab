package com.somnus.androidtabdemo;

import com.somnus.androidtabdemo.fragment.OneFragment;
import com.somnus.androidtabdemo.fragment.ThreeFragment;
import com.somnus.androidtabdemo.fragment.TwoFragment;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class MainActivity extends FragmentActivity implements OnClickListener {

	OneFragment mOneFragment;
	TwoFragment mTwoFragment;
	ThreeFragment mThreeFragment;

	private LinearLayout buttomBarGroup;
	private ImageButton mNews, mConstact, mSetting;
	private View currentButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initView();

	}

	private void initView() {

		mOneFragment = (OneFragment) getSupportFragmentManager()
				.findFragmentById(R.id.fragment_one);// 第一页
		mTwoFragment = (TwoFragment) getSupportFragmentManager()
				.findFragmentById(R.id.fragment_two);// 第二页
		mThreeFragment = (ThreeFragment) getSupportFragmentManager()
				.findFragmentById(R.id.fragment_three);// 第三页
		findView();

	}

	private void findView() {
		buttomBarGroup = (LinearLayout) findViewById(R.id.buttom_bar_group);// 底部导航栏
		mNews = (ImageButton) findViewById(R.id.buttom_news);// 消息
		mConstact = (ImageButton) findViewById(R.id.buttom_constact);// 联系人
		mSetting = (ImageButton) findViewById(R.id.buttom_setting);// 我

		mNews.setOnClickListener(this);
		mConstact.setOnClickListener(this);
		mSetting.setOnClickListener(this);
		mNews.performClick();
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.buttom_news:// 消息
			getSupportFragmentManager().beginTransaction().hide(mTwoFragment)
					.hide(mThreeFragment).show(mOneFragment).commit();
			setButton(v);
			break;
		case R.id.buttom_constact:// 联系人
			getSupportFragmentManager().beginTransaction().hide(mOneFragment)
					.hide(mThreeFragment).show(mTwoFragment).commit();
			setButton(v);
			break;
		case R.id.buttom_setting:// 设置
			getSupportFragmentManager().beginTransaction().hide(mOneFragment)
					.hide(mTwoFragment).show(mThreeFragment).commit();
			setButton(v);
			break;
		default:
			break;
		}
	}

	private void setButton(View v) {
		if (currentButton != null && currentButton.getId() != v.getId()) {
			currentButton.setEnabled(true);
		}
		v.setEnabled(false);
		currentButton = v;
	}

}
