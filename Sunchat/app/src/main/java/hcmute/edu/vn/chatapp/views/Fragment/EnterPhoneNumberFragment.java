package hcmute.edu.vn.chatapp.views.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import hcmute.edu.vn.chatapp.R;
import hcmute.edu.vn.chatapp.base.BaseFragment;

public class EnterPhoneNumberFragment extends BaseFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.fragment_layout_enter_number_phone, container, false);
        return super.onCreateView(inflater, view, savedInstanceState);
    }
}
