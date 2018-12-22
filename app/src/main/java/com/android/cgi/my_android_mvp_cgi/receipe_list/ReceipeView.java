package com.android.cgi.my_android_mvp_cgi.receipe_list;

import java.util.List;

public interface ReceipeView {
    void showProgress();
    void hideProgress();
    void loadReceipe(List<Receipe> receipes);
    void loadFilertedReceipe(String ingre1, String ingre2);
}
