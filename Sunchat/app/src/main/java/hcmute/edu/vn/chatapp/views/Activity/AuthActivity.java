package hcmute.edu.vn.chatapp.views.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.viewpager.widget.ViewPager;

import hcmute.edu.vn.chatapp.R;
import hcmute.edu.vn.chatapp.adapter.SliderAdapter;
import hcmute.edu.vn.chatapp.databinding.ActivityAuthBinding;
import hcmute.edu.vn.chatapp.viewmodels.AuthViewModel;

public class AuthActivity extends AppCompatActivity {
    private ViewPager mSlideViewPager;
    private LinearLayout mDotLayout;
    private TextView[] mDots;
    private SliderAdapter sliderAdapter;
    private int numDots = 4;


    private boolean isSwipingToEnd = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityAuthBinding activityAuthBinding = DataBindingUtil.setContentView(this, R.layout.activity_auth);
        AuthViewModel authViewModel = AuthViewModel.getInstance();
        activityAuthBinding.setLifecycleOwner(this);
        activityAuthBinding.setAuthViewModel(authViewModel);

        initView();

        authViewModel.getGotoLoginScreen().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean gotoLoginScreen) {
                Log.e("gotoLoginScreen", gotoLoginScreen.toString());
                if (gotoLoginScreen) {
                    startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                } else {
                    startActivity(new Intent(getApplicationContext(), RegisterActivity.class));
                }
            }
        });
    }

    private void initView() {
        mSlideViewPager = findViewById(R.id.activity_auth_slide_view_pager);
        mDotLayout = findViewById(R.id.activity_auth_slide_dots);
        sliderAdapter = new SliderAdapter(this);
        mSlideViewPager.setAdapter(sliderAdapter);
        setUpDotsIndicator(0);
        mSlideViewPager.setOnPageChangeListener(viewListener);
    }

    private void setUpDotsIndicator(int position) {
        mDots = new TextView[numDots];
        mDotLayout.removeAllViews();

        for(int i = 0; i < mDots.length; i++) {
            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226;"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.transparent_white));
            mDotLayout.addView(mDots[i]);
        }

        if(mDots.length > 0) {
            mDots[position].setTextColor(getResources().getColor(R.color.dots_color));
        }
    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            setUpDotsIndicator(position);
        }

        @Override
        public void onPageScrollStateChanged(int state) {
        }
    };

}
