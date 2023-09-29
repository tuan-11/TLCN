package hcmute.edu.vn.chatapp.views.Fragment;

import android.database.Observable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputLayout;

import hcmute.edu.vn.chatapp.R;
import hcmute.edu.vn.chatapp.base.BaseFragment;
import hcmute.edu.vn.chatapp.viewmodels.RegisterViewModel;
import hcmute.edu.vn.chatapp.views.Activity.RegisterActivity;

public class EnterNameFragment extends BaseFragment {
    private TextInputLayout nameInputLayout;
    private EditText nameInputEditText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.fragment_layout_enter_name, container, false);
        View v = super.onCreateView(inflater, view, savedInstanceState);
        nameInputLayout = v.findViewById(R.id.text_input_name);
        nameInputEditText = nameInputLayout.getEditText();

//        if(nameInputEditText != null) {
//            ((RegisterViewModel)baseActivity.getViewModel()).getRegisterInfo()
//                    .observe(getViewLifecycleOwner(), user -> nameInputEditText.setText(user.getFullName()));
//
//            Observable<Boolean> nameInputObservable = RxTextView.textChanges(nameInputEditText)
//                    .map(inputText -> validateName(inputText.toString().trim()))
//                    .distinctUntilChanged();
//
//            nameInputObservable.subscribe(isValid -> {
//                ((RegisterActivity) baseActivity).getNextActionBtn().setEnabled(isValid);
//            });
//        }

        ((RegisterActivity) baseActivity).getNextActionBtn().setOnClickListener(v1 -> {
            ((RegisterActivity) baseActivity).replaceFragment(new EnterPhoneNumberFragment());
        });

        return v;
    }

    private boolean validateName(String nameInput) {
        if(nameInput.matches(".*[0-9].*")) {
            nameInputLayout.setError("Tên không được chứa chữ số");
            nameInputLayout.setErrorIconDrawable(null);
            return false;
        }
        else if(nameInput.trim().length() == 0) {
            nameInputEditText.getText().clear();
            nameInputEditText.setSelection(0);
            return false;
        }
        else if(nameInput.length() > 40) {
            nameInputLayout.setError("Tên quá dài. Tên hợp lệ phải gồm 2-40 ký tự.");
            nameInputLayout.setErrorIconDrawable(null);

            return false;
        }
        else {
            nameInputLayout.setError(null);
            return true;
        }
    }

//    @Override
//    public void onPause() {
//        ((RegisterViewModel)baseActivity.getViewModel()).saveNameInput(nameInputEditText.getText().toString());
//        super.onPause();
//    }
}
