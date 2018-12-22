package com.android.cgi.my_android_mvp_cgi.receipe_list;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Spinner;

import com.android.cgi.my_android_mvp_cgi.R;
import com.android.cgi.my_android_mvp_cgi.utils.FileReaderUtil;

import java.io.IOException;
import java.util.List;

public class ReceipeListActivity extends AppCompatActivity implements ReceipeView{

    private List<Receipe> receipes;
    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private ReceipePresenter presenter;
    private Spinner ingredients1;
    private Spinner ingredients2;
    private String ingredient1 = "";
    private String ingredient2 = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        progressBar = findViewById(R.id.progress);

        //read file
        receipes = ReadFileFromResource();

        recyclerView = (RecyclerView) findViewById(R.id.receipe_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        presenter = new ReceipePresenter(this,receipes);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.onResume();
    }

    private List<Receipe> ReadFileFromResource() {
        List<Receipe> receipe = null;
        try {
            receipe = FileReaderUtil.readFilefromResource(this, R.raw.receipe);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return receipe;
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void loadReceipe(List<Receipe> receipes) {
        recyclerView.setAdapter(new ReceipeAdaptor(this,receipes));
        hideProgress();
    }

    @Override
    public void loadFilertedReceipe(String ingre1, String ingre2) {

    }
}
