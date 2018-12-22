package com.android.cgi.my_android_mvp_cgi.receipe_list;

import java.util.ArrayList;
import java.util.List;

class ReceipePresenter {

    private ReceipeView receipeView;
    private List<Receipe> receipes;
    ReceipePresenter(ReceipeView receipeView, List<Receipe> receipes) {
        this.receipeView = receipeView;
        this.receipes = receipes;
    }

    void onResume() {
        if (receipeView != null){
            receipeView.showProgress();
            receipeView.loadReceipe(receipes);
            //receipeView.lo
        }
    }

    void onDestroy(){

    }

    void onFinished(){

    }
    ReceipeView getMainView(){
        return receipeView;
    }

    public void updateReceipe(String ingredient1, String ingredient2) {
        List<Receipe> receipeList = new ArrayList<>();
        for (Receipe receipe : receipes){
            if(receipe.getIngredients().toString().contains(ingredient1)&receipe.getIngredients().toString().contains(ingredient2)){
                receipeList.add(receipe);
            }
        }
        receipeView.loadReceipe(receipeList);
    }
}
