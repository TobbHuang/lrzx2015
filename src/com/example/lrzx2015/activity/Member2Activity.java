package com.example.lrzx2015.activity;

import java.util.ArrayList;
import java.util.List;

import com.example.lrzx2015.R;
import com.example.lrzx2015.R.layout;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Member2Activity extends Activity {

	TextView tv_title, tv_content;
	ImageView iv_pic;
	LinearLayout pagerLayout;
	ViewPager viewPager;
	ArrayList<View> pageViews;
	PageAdapter adapter;

	int index;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_member2);

		initView();

	}

	private void initView() {
		// TODO Auto-generated method stub

		RelativeLayout rl_back = (RelativeLayout) findViewById(R.id.rl_member2_back);
		rl_back.setOnClickListener(onClickListener);

		pagerLayout = (LinearLayout) findViewById(R.id.ll_member2_container);
		viewPager = new ViewPager(this);
		viewPager.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.MATCH_PARENT));
		pagerLayout.addView(viewPager);

		pageViews = new ArrayList<View>();

		int[] pic = { R.drawable.yangwenyuan, R.drawable.baopengfei,
				R.drawable.hukeqi, R.drawable.zhangming,
				R.drawable.wangpengfei, R.drawable.denghaoliang,
				R.drawable.zhangxin, R.drawable.zhanghao, R.drawable.xuhua,
				R.drawable.wangbintao, R.drawable.zhanglu,
				R.drawable.lihaoxing, R.drawable.pengyicheng,
				R.drawable.heyuwei, R.drawable.lianghaipeng,
				R.drawable.lizhaoning, R.drawable.liuzhaoyi, R.drawable.humiao,
				R.drawable.wangyu, R.drawable.caochan, R.drawable.huangyafei,
				R.drawable.taowenyuan, R.drawable.qiancan,
				R.drawable.renyuanhang, R.drawable.huangtao, R.drawable.suheng,
				R.drawable.jiazihui, R.drawable.xiaozhangjin,
				R.drawable.yangyang, R.drawable.qiutong, R.drawable.zhaojing,
				R.drawable.weilai, R.drawable.qiushilin, R.drawable.wangpin,
				R.drawable.zhuqinqin };
		String[] title = { "杨文元", "暴鹏飞", "胡可奇", "张明", "王鹏飞", "邓浩梁", "张鑫", "张浩",
				"徐华", "王彬陶", "张路", "李昊星", "彭一城", "何雨薇", "梁海鹏", "李赵宁", "刘钊祎",
				"胡淼", "王宇", "曹灿", "黄亚菲", "陶文元", "钱璨", "任远航", "黄涛", "苏恒", "贾子辉",
				"肖彰瑾", "杨洋", "邱童", "赵菁", "魏来", "邱士林", "汪聘", "朱晴晴" };
		String[] content = { getResources().getString(R.string.yangwenyuan),
				getResources().getString(R.string.baopengfei),
				getResources().getString(R.string.hukeqi),
				getResources().getString(R.string.zhangming),
				getResources().getString(R.string.wangpengfei),
				getResources().getString(R.string.denghaoliang),
				getResources().getString(R.string.zhangxin),
				getResources().getString(R.string.zhanghao),
				getResources().getString(R.string.xuhua),
				getResources().getString(R.string.wangbintao),
				getResources().getString(R.string.zhanglu),
				getResources().getString(R.string.lihaoxing),
				getResources().getString(R.string.pengyicheng),
				getResources().getString(R.string.heyuwei),
				getResources().getString(R.string.lianghaipeng),
				getResources().getString(R.string.lizhaoning),
				getResources().getString(R.string.liuzhaoyi),
				getResources().getString(R.string.humiao),
				getResources().getString(R.string.wangyu),
				getResources().getString(R.string.caochan),
				getResources().getString(R.string.huangyafei),
				getResources().getString(R.string.taowenyuan),
				getResources().getString(R.string.qiancan),
				getResources().getString(R.string.renyuanhang),
				getResources().getString(R.string.huangtao),
				getResources().getString(R.string.suheng),
				getResources().getString(R.string.jiazihui),
				getResources().getString(R.string.xiaozhangjin),
				getResources().getString(R.string.yangyang),
				getResources().getString(R.string.qiutong),
				getResources().getString(R.string.zhaojin),
				getResources().getString(R.string.weilai),
				getResources().getString(R.string.qiushilin),
				getResources().getString(R.string.wangpin),
				getResources().getString(R.string.zhuqinqin) };

		LayoutInflater mLi = LayoutInflater.from(this);
		for (int i = 0; i < 35; i++) {
			View view = mLi.inflate(R.layout.layout_member2item, null);

			final RelativeLayout rl_intro = (RelativeLayout) view
					.findViewById(R.id.rl_member2item_intro);

			iv_pic = (ImageView) view.findViewById(R.id.iv_member2item_pic);
			iv_pic.setImageResource(pic[i]);

			tv_content = (TextView) view
					.findViewById(R.id.tv_member2item_content);
			tv_content.setText(content[i]);

			tv_title = (TextView) view.findViewById(R.id.tv_member2item_title);
			tv_title.setText(title[i]);

			TextView tv_switch = (TextView) view
					.findViewById(R.id.tv_member2item_switch);
			tv_switch.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					if (rl_intro.getVisibility() == View.GONE) {
						rl_intro.setVisibility(View.VISIBLE);
						((TextView) v).setText("隐藏描述");
					} else {
						rl_intro.setVisibility(View.GONE);
						((TextView) v).setText("显示描述");
					}
				}
			});

			pageViews.add(view);
		}

		adapter = new PageAdapter(pageViews);
		viewPager.setAdapter(adapter);

		index = getIntent().getIntExtra("index", 0);
		viewPager.setCurrentItem(index);
		viewPager.setOnPageChangeListener(new OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int position) {
				// TODO Auto-generated method stub
				TextView tv_title=(TextView)findViewById(R.id.tv_member2_index);
				tv_title.setText((position)+1+"/35");
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		TextView tv_title=(TextView)findViewById(R.id.tv_member2_index);
		tv_title.setText((index)+1+"/35");

	}

	private final class PageAdapter extends PagerAdapter {
		private List<View> views = null;

		public PageAdapter(List<View> views) {
			this.views = views;
		}

		@Override
		public void destroyItem(View container, int position, Object object) {
			((ViewPager) container).removeView(views.get(position));
		}

		@Override
		public int getCount() {
			return views.size();
		}

		@Override
		public Object instantiateItem(View container, int position) {
			((ViewPager) container).addView(views.get(position), 0);
			return views.get(position);
		}

		@Override
		public boolean isViewFromObject(View view, Object object) {
			return view == object;
		}
	}

	OnClickListener onClickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.rl_member2_back:
				finish();
				break;
			}
		}
	};

}
