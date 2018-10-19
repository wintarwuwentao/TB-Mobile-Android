package com.device.limaiyun.thingsboard.ui.activity.childactivity.equipment.view;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.text.TextPaint;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.device.limaiyun.thingsboard.R;
import com.device.limaiyun.thingsboard.base.BaseActivity;
import com.device.limaiyun.thingsboard.bean.DeviceTypesBean;
import com.device.limaiyun.thingsboard.ui.activity.childactivity.equipment.presenter.EquipmentPresenter;
import com.device.limaiyun.thingsboard.ui.fragment.child.all.view.AllFragment;
import com.device.limaiyun.thingsboard.utils.ScaleTransitionPagerTitleView;
import com.device.limaiyun.thingsboard.utils.ToastUtils;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.UIUtil;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/5/10 0010.
 */

public class EquipmentActivity extends BaseActivity implements EquipmentView {
    @BindView(R.id.magic_indicator)
    MagicIndicator magicIndicator;
    @BindView(R.id.viewpager)
    ViewPager viewPager;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.ll_back)
    LinearLayout back;
    @BindView(R.id.iv_search)
    ImageView iv_search;

    private CommonNavigator mCommonNavigator;
    private List<String> mTitleLists;
    private EquipmentPresenter presenter;


    @Override
    protected int getLayout() {
        return R.layout.activity_equipment;
    }

    @Override
    public void initView() {
        mCommonNavigator = new CommonNavigator(this);
        presenter = new EquipmentPresenter(this);
    }

    @Override
    public void initImmersionBar() {
        super.initImmersionBar();
        mImmersionBar.titleBar(R.id.toolbar).init();
    }

    @Override
    public void initData() {
        presenter.getDeviceTypes();
    }

    @Override
    public void initEvent() {

    }

    @Override
    public void showToast(String msg) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hinddenLoading() {

    }

    @Override
    public void showDeviceTypesTitle(List<DeviceTypesBean> deviceTypesBean) {
        mTitleLists = new ArrayList<>();
        mTitleLists.add("全部");
        for (int i = 0; i < deviceTypesBean.size(); i++) {
            mTitleLists.add(deviceTypesBean.get(i).getType());
        }
        MyViewPagerAdapter adapter = new MyViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        mCommonNavigator.setAdapter(new CommonNavigatorAdapter() {
            @Override
            public int getCount() {
                return mTitleLists == null ? 0 : mTitleLists.size();
            }

            @Override
            public IPagerTitleView getTitleView(Context context, final int index) {
                ScaleTransitionPagerTitleView titleView = new ScaleTransitionPagerTitleView(context);
                titleView.setText(mTitleLists.get(index));
                TextPaint paint = titleView.getPaint();
                paint.setFakeBoldText(true);
                titleView.setNormalColor(Color.parseColor("#88888888"));
                titleView.setSelectedColor(Color.parseColor("#3783D2"));
                titleView.setSelected(true);
                titleView.setTextSize(18.0f);
                titleView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        viewPager.setCurrentItem(index);
                    }
                });
                return titleView;
            }

            @Override
            public IPagerIndicator getIndicator(Context context) {
                LinePagerIndicator indicator = new LinePagerIndicator(context);
                indicator.setMode(LinePagerIndicator.MODE_WRAP_CONTENT);
                indicator.setLineHeight(UIUtil.dip2px(context, 2));
                indicator.setColors(Color.parseColor("#3783D2"));
                return indicator;
            }
        });
        magicIndicator.setNavigator(mCommonNavigator);
        //设置viewpage页面发生改变,指示器发生改变
        ViewPagerHelper.bind(magicIndicator, viewPager);
    }

    private class MyViewPagerAdapter extends FragmentPagerAdapter {

        public MyViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return new AllFragment();
        }

        @Override
        public int getCount() {
            return mTitleLists.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitleLists.get(position);
        }
    }

    @OnClick(R.id.ll_back)
    public void backHome(){
        finish();
    }

    @OnClick(R.id.iv_search)
    public void searchEquipment(){
        ToastUtils.showShortToast("搜索");
    }
}
