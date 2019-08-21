package recorded.dxyt.com.replugindemo.ui.activity;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.FrameLayout;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import java.util.ArrayList;
import java.util.List;

import recorded.dxyt.com.replugindemo.R;
import recorded.dxyt.com.replugindemo.base.BaseActivity;
import recorded.dxyt.com.replugindemo.ui.fragment.AddressBookFragment;
import recorded.dxyt.com.replugindemo.ui.fragment.ApplicationMarketFragment;
import recorded.dxyt.com.replugindemo.ui.fragment.HomeFragment;
import recorded.dxyt.com.replugindemo.ui.fragment.PersonalCenterFragment;
import recorded.dxyt.com.replugindemo.utils.ViewPagerFragmentAdapter;

public class MainActivity extends BaseActivity {

    BottomBar bottomBar;
    ViewPager vp;
    FrameLayout frameLayout;


    ViewPagerFragmentAdapter adapter;

    //这里是MainActivity所需要的Fragment
    //首页Fragment
    HomeFragment homeFragment;
    //通讯录Fragment
    AddressBookFragment addressBookFragment;
    //应用市场Fragment
    ApplicationMarketFragment applicationMarketFragment;
    //个人中心Fragment
    PersonalCenterFragment personalCenterFragment;


    //Fragment的集合
    List<Fragment> list = new ArrayList<>();
    //底部标题的集合


    @Override
    protected void initData() {
        homeFragment=new HomeFragment();
        addressBookFragment=new AddressBookFragment();
        applicationMarketFragment=new ApplicationMarketFragment();
        personalCenterFragment=new PersonalCenterFragment();
        list.add(homeFragment);
        list.add(addressBookFragment);
        list.add(applicationMarketFragment);
        list.add(personalCenterFragment);

        vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {

                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            //滑动时
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int i) {
                switch (i) {
                    case 0:
                        bottomBar.selectTabWithId(R.id.tab_home);
                        break;
                    case 1:
                        bottomBar.selectTabWithId(R.id.tab_address_book);
                        break;
                    case 2:
                        bottomBar.selectTabWithId(R.id.tab_application_market);
                        break;
                    case 3:
                        bottomBar.selectTabWithId(R.id.tab_personal_center);
                        break;
                }

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(int tabId) {
                switch (tabId) {
                    case R.id.tab_home:
                        vp.setCurrentItem(0, false);
                        break;
                    case R.id.tab_address_book:
                        vp.setCurrentItem(1, false);
                        break;

                    case R.id.tab_application_market:
                        vp.setCurrentItem(2, false);
                        break;

                    case R.id.tab_personal_center:
                        vp.setCurrentItem(3, false);
                        break;


                }
            }
        });

    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void initView() {
        bottomBar = findViewById(R.id.bottom_bar);
        vp = findViewById(R.id.bottom_view_pager);
        frameLayout = findViewById(R.id.frame_layout);
    }

    @Override
    protected void onClickListener(View v) {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }
}
