package hcmute.edu.vn.chatapp.viewmodels;

import androidx.lifecycle.ViewModel;

public class RegisterViewModel extends ViewModel {

    private static RegisterViewModel instance;
    public static RegisterViewModel getInstance() {
        if (instance == null) {
            instance = new RegisterViewModel();
        }
        return instance;
    }
}
