package com.srug.mobile.todo.view;

import android.os.Bundle;

import com.srug.mobile.todo.MVP;
import com.srug.mobile.todo.R;
import com.srug.mobile.todo.common.GenericActivity;
import com.srug.mobile.todo.presenter.MainPresenter;

public class MainActivity extends GenericActivity<MVP.MainRequiredViewOps,
        MVP.MainProvidedPresenterOps,
        MainPresenter>
        implements MVP.MainRequiredViewOps {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        super.onCreate(MainPresenter.class, this, getIntent().getExtras());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
