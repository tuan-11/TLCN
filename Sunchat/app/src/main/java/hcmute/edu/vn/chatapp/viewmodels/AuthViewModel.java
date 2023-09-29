package hcmute.edu.vn.chatapp.viewmodels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AuthViewModel extends ViewModel {
    private MutableLiveData<Boolean> gotoLoginScreen;

    private static AuthViewModel instance;
    private AuthViewModel() {
        gotoLoginScreen = new MutableLiveData<>();
    }

    public static AuthViewModel getInstance() {
        if (instance == null) {
            instance = new AuthViewModel();
        }
        return instance;
    }
    public MutableLiveData<Boolean> getGotoLoginScreen() {
        return gotoLoginScreen;
    }
    public void login() {
        gotoLoginScreen.setValue(true);
    }

    public void register() {
        gotoLoginScreen.setValue(false);
    }
}
