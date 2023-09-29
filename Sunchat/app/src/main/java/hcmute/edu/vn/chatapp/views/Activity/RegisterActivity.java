package hcmute.edu.vn.chatapp.views.Activity;

import android.os.Bundle;
import android.view.View;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import hcmute.edu.vn.chatapp.R;
import hcmute.edu.vn.chatapp.base.BaseActivity;
import hcmute.edu.vn.chatapp.base.BaseFragment;
import hcmute.edu.vn.chatapp.databinding.ActivityRegisterBinding;
import hcmute.edu.vn.chatapp.viewmodels.RegisterViewModel;
import hcmute.edu.vn.chatapp.views.Fragment.EnterNameFragment;
import hcmute.edu.vn.chatapp.views.Fragment.EnterPhoneNumberFragment;
import hcmute.edu.vn.chatapp.views.Fragment.SelectGenderAndBirthDateFragment;
import hcmute.edu.vn.chatapp.views.Fragment.VerifyOTPFragment;

public class RegisterActivity extends BaseActivity{
    private FloatingActionButton nextActionBtn;
    private FragmentTransaction fragmentTransaction;

    public FloatingActionButton getNextActionBtn() {
        return nextActionBtn;
    }

    @Override
    public Integer getViewRootId() {
        return R.id.clRegisterActivity;
    }

    @Override
    public void replaceFragment(BaseFragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.activity_register_content_frame, fragment);
        fragmentTransaction.addToBackStack(fragment.getTag());
        fragmentTransaction.commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityRegisterBinding activityRegisterBinding = DataBindingUtil.setContentView(this, R.layout.activity_register);
        RegisterViewModel registerViewModel = RegisterViewModel.getInstance();
        activityRegisterBinding.setLifecycleOwner(this);
        activityRegisterBinding.setRegisterViewModel(registerViewModel);

        initAppBar();
        nextActionBtn = findViewById(R.id.activity_register_next_btn);
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.activity_register_content_frame, new VerifyOTPFragment());
        fragmentTransaction.commit();
    }

    @Override
    public void initAppBar() {
        super.initAppBar();
        setTitleToolbar("Tạo tài khoản");
        setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onClick(View v) {

    }
}