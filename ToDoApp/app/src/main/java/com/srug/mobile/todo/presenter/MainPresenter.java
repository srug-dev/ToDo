package com.srug.mobile.todo.presenter;

import android.os.Bundle;

import com.srug.mobile.todo.MVP;
import com.srug.mobile.todo.common.GenericAsyncTaskOps;

public class MainPresenter implements
        GenericAsyncTaskOps<Void, Void, Void>,
        MVP.MainProvidedPresenterOps {

    @Override
    public void onPreExecute() {

    }

    @Override
    public Void doInBackground(Void... params) {
        return null;
    }

    @Override
    public void onPostExecute(Void result) {

    }

    @Override
    public void onCreate(MVP.MainRequiredViewOps view) {

    }

    @Override
    public void onConfiguration(MVP.MainRequiredViewOps view, Bundle extras, boolean firstTimeIn) {

    }

    @Override
    public void onDestroy(boolean isChangingConfiguration) {

    }
}
