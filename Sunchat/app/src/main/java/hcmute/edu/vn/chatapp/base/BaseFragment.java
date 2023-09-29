package hcmute.edu.vn.chatapp.base;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModel;
import androidx.fragment.app.Fragment;

import com.google.android.material.snackbar.Snackbar;
import hcmute.edu.vn.chatapp.R;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;

public abstract class BaseFragment<V extends ViewModel> extends Fragment implements View.OnClickListener {
    protected final String TAG = this.getTag();

    protected V viewModel;
//

    protected BaseActivity baseActivity;

    protected FrameLayout viewRoot;

//    @Inject
//    protected ViewModelProviderFactory providerFactory;

    @SuppressLint("ClickableViewAccessibility")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_base_layout, null, false);
        viewRoot = view.findViewById(R.id.baseFragmentLayout);
        viewRoot.addView(container);
        if(container != null) {
            container.setOnTouchListener((v, event) -> {
                baseActivity.hideKeyboard();
                return false;
            });
        }
        return view;
    }

    @Override
    public void onAttach(Context context) {
        this.baseActivity = (BaseActivity) context;
        super.onAttach(context);
    }

    @Override
    public void onClick(View v) {

    }

    protected void showSnackBar(String msg, int duration) {
        Snackbar.make(viewRoot, msg, duration).show();
    }
}
