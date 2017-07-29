package test.bwie.jiyun.com.ins7566.ipandatv.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import test.bwie.jiyun.com.ins7566.ipandatv.R;
import test.bwie.jiyun.com.ins7566.ipandatv.base.BaseActivity;
import test.bwie.jiyun.com.ins7566.ipandatv.module.home.fragment.HomeFragment;
import test.bwie.jiyun.com.ins7566.ipandatv.module.home.hudong.HudongActivity;
import test.bwie.jiyun.com.ins7566.ipandatv.module.pandabroadcast.fragment.PandaBroadcastFragment;
import test.bwie.jiyun.com.ins7566.ipandatv.widget.manger.ConfigFragment;

public class MainActivity extends BaseActivity {

    @BindView(R.id.FrameLayout)
    android.widget.FrameLayout FrameLayout;
    @BindView(R.id.main_home_btn)
    RadioButton mainHomeBtn;
    @BindView(R.id.main_live_btn)
    RadioButton mainLiveBtn;
    @BindView(R.id.main_culture_btn)
    RadioButton mainCultureBtn;
    @BindView(R.id.main_broadcast_btn)
    RadioButton mainBroadcastBtn;
    @BindView(R.id.main_china_btn)
    RadioButton mainChinaBtn;
    @BindView(R.id.FrameLayout_contentGroup)
    RadioGroup FrameLayoutContentGroup;
    @BindView(R.id.activity_main)
    LinearLayout activityMain;
    @BindView(R.id.iconImg)
    ImageView iconImg;
    @BindView(R.id.personImg)
    ImageView personImg;
    @BindView(R.id.titleTv)
    TextView titleTv;
    @BindView(R.id.hudongImg)
    ImageView hudongImg;
    private long lastTime;//上一次点击back键的时间毫秒数
    public static final int HOMETYPE = 1;
private  FragmentManager fragmentManager;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {

    }

    @Override
    public void initData() {
        ConfigFragment.getInstance().init().start(HomeFragment.class).build();
    }

    @Override
    public void loadData() {

    }

    @OnClick({R.id.main_home_btn, R.id.main_live_btn, R.id.main_culture_btn, R.id.main_broadcast_btn, R.id.main_china_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.main_home_btn:
                showTitle(null,HOMETYPE);
                ConfigFragment.getInstance().init().start(HomeFragment.class).build();
                break;
            case R.id.main_live_btn:
                showTitle("熊猫直播",0);
                break;
            case R.id.main_culture_btn:
                showTitle("熊猫文化",0);
                break;
            case R.id.main_broadcast_btn:
                showTitle("熊猫观察",0);
                ConfigFragment.getInstance().init().start(PandaBroadcastFragment.class).build();
                break;
            case R.id.main_china_btn:
                showTitle("直播中国",0);
                break;
        }
    }

    private void showTitle(String title, int type) {
        if (type == HOMETYPE) {
            iconImg.setVisibility(View.VISIBLE);
            titleTv.setVisibility(View.GONE);
            hudongImg.setVisibility(View.VISIBLE);
        } else {
            titleTv.setText(title);
            iconImg.setVisibility(View.GONE);
            titleTv.setVisibility(View.VISIBLE);
            hudongImg.setVisibility(View.GONE);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

//    @Override
//    public void onBackPressed() {
//        //获取栈顶的
//////        getSupportFragmentManager().getBackStackEntryCount(getSupportFragmentManager().getBackStackEntryCount()-1);
////        if (System.currentTimeMillis() - lastTime < 2000) {
////            finish();
////        } else {
//////            ToastManger.show("再按一次退出应用");
////            Toast.makeText(MainActivity.this, "再按一次退出应用", Toast.LENGTH_SHORT).show();
////            lastTime = System.currentTimeMillis();
////        }
//        FragmentManager.BackStackEntry entryAt = fragmentManager.getBackStackEntryAt(fragmentManager.getBackStackEntryCount() -1);
//        //得到每一个位于栈顶的类的名字，然后执行Finish方法进行弹栈
//        String name = entryAt.getName();
//        if ("HomeFragment".equals(name) ||
//                "LiveChinaFragment".equals(name) ||
//                "PandaCultureFragment".equals(name) ||
//                "PandaBroadcastFragment".equals(name) ||
//                "PandaLiveFragment".equals(name)
//                ) {
////           finish();
//            Process.killProcess(Process.myPid());
//            System.exit(0);
//
//
//        }else{
//            if (fragmentManager.getBackStackEntryCount() > 1) {
//                fragmentManager.popBackStackImmediate();//执行弹栈，立马执行
//                //否则记录得到位于栈顶的类名字
//                String simpleName = fragmentManager.getBackStackEntryAt(fragmentManager.getBackStackEntryCount()-1 ).getName();
//                //记录做标记，标记为上一个Fragment,点击back键刷新lastFragment
//                App.lastFragment = (BaseFragment) fragmentManager.findFragmentByTag(simpleName);
//            }
//        }
//    }

    @OnClick({R.id.personImg, R.id.hudongImg})
    public void onClicked(View view) {
        switch (view.getId()) {
            case R.id.personImg:

                break;
            case R.id.hudongImg:
                Intent intent = new Intent(MainActivity.this,HudongActivity.class);
                startActivity(intent);

                break;
        }
    }

    //执行完全退出
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Process.killProcess(Process.myPid());//获取pid
        System.exit(0);
//        LocalBroadcastManager.getInstance(this).unregisterReceiver(mMessageReceiver);
        super.onDestroy();
    }

    //隐藏下面的RadioGroup
    public RadioGroup getMainRadioGroup() {
        return FrameLayoutContentGroup;
    }

    public void setMainRadioGroup(RadioGroup mainRadioGroup) {
        FrameLayoutContentGroup = mainRadioGroup;
    }
}
