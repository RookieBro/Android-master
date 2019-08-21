package recorded.dxyt.com.replugindemo.utils;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class ViewPagerFragmentAdapter extends FragmentPagerAdapter {
    private List<Fragment> listData;

    private List<CharSequence> listTitle;

    public ViewPagerFragmentAdapter(FragmentManager fm, List<Fragment> listData){
        this(fm,listData,null);
    }

    public abstract class ViewPagerAdapter<T> extends PagerAdapter {

        protected Context context;
        private List<T> listData = null;
        private List<CharSequence> listTitle = null;

        public ViewPagerAdapter(Context context, List<T> listData) {
            this.context = context;
            this.listData = listData;
        }
        public ViewPagerAdapter(Context context,List<T> listData,List<CharSequence> listTitle) {
            this.context = context;
            this.listData = listData;
            this.listTitle = listTitle;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View)object);
        }

        @Override
        public int getCount() {
            return listData==null ? 0:listData.size();
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view = getView(container,listData.get(position),position);
            container.addView(view);
            return view;
        }

        public abstract View getView(ViewGroup container,T t,int position);

        @Override
        public boolean isViewFromObject(View paramView, Object paramObject) {
            return paramView == paramObject;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            if(listTitle!=null && listTitle.size()!=0){
                return listTitle.get(position);
            }
            return super.getPageTitle(position);
        }


    }
    public ViewPagerFragmentAdapter(FragmentManager fm, List<Fragment> listData, List<CharSequence> listTitle) {
        super(fm);
        this.listData = listData;
        this.listTitle = listTitle;
    }


    public List<Fragment> getListData() {
        return listData;
    }

    public void setListData(List<Fragment> listData) {
        this.listData = listData;
    }

    public List<CharSequence> getListTitle() {
        return listTitle;
    }

    public void setListTitle(List<CharSequence> listTitle) {
        this.listTitle = listTitle;
    }

    @Override
    public Fragment getItem(int position) {
        return listData==null ? null : listData.get(position) ;
    }

    @Override
    public int getCount() {
        return listData == null ? 0 : listData.size();
    }


    @Override
    public CharSequence getPageTitle(int position) {
        if(listTitle!=null && listTitle.size()!=0){
            return listTitle.get(position);
        }
        return super.getPageTitle(position);
    }
}
