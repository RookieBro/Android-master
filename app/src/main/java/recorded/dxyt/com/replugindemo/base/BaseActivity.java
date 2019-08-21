package recorded.dxyt.com.replugindemo.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public abstract class BaseActivity extends FragmentActivity implements View.OnClickListener {
    public static final String TAG="DEMOTEST";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        initView();
        initData();
    }

    protected abstract void initData();

    protected abstract void initView();


    protected abstract void onClickListener(View v);

    protected abstract int getLayoutId();

    @Override
    public void onClick(View v) {
        onClickListener(v);
    }
    public void showToast(String content){
        Toast.makeText(this,content,Toast.LENGTH_SHORT).show();
    }
    
    public void LogUtils(String log){
        Log.e(TAG,log);
    }
    
    

}
