package hcmute.edu.vn.chatapp.base;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;

import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;

import com.google.android.material.appbar.MaterialToolbar;

import dagger.android.support.DaggerAppCompatActivity;
import hcmute.edu.vn.chatapp.R;

public abstract class BaseActivity<V extends ViewModel> extends AppCompatActivity implements View.OnClickListener{
    public abstract @IdRes Integer getViewRootId();
    public MaterialToolbar toolbar = null;
    private Dialog loadingDialog;

    public abstract void replaceFragment(BaseFragment fragment);

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(getLayoutId());
//        if(getViewRootId() != null) {
//            ViewGroup viewGroup = findViewById(getViewRootId());
//            viewGroup.setOnTouchListener((v, event) -> {
//                hideKeyboard();
//                return false;
//            });
//        }
//        createLoadingDialog();
//        getViewModel();
    }

    public void initAppBar() {
        if(getViewRootId() != null) {
            ViewGroup viewGroup = findViewById(getViewRootId());
            LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            @SuppressLint("InflateParams") View appBar = inflater.inflate(R.layout.layout_appbar, null);
            appBar.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            toolbar = appBar.findViewById(R.id.toolbar);
            setSupportActionBar(this.toolbar);
            toolbar.setNavigationOnClickListener(v -> onBackPressed());
            viewGroup.addView(appBar, 0);
        }
    }

    public void setTitleToolbar(String title) {
        if(getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }

    public void setDisplayHomeAsUpEnabled(boolean homeAsUpEnabled) {
        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(homeAsUpEnabled);
        }
    }

    private void createLoadingDialog() {
        loadingDialog = new Dialog(this);
        loadingDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        loadingDialog.setContentView(R.layout.layout_dialog_loading);
        loadingDialog.setCanceledOnTouchOutside(false);
        Window window = loadingDialog.getWindow();
        if(window == null) {
            return;
        }
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        WindowManager.LayoutParams windowAttributes = window.getAttributes();
        windowAttributes.gravity = Gravity.CENTER;
        window.setAttributes(windowAttributes);
    }

    public void hideKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            if (imm != null) {
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        }
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }
}
