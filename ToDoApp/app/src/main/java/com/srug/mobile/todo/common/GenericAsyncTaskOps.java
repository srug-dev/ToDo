package com.srug.mobile.todo.common;

public interface GenericAsyncTaskOps<P, G, R> {

    void onPreExecute();

    @SuppressWarnings("unchecked")
    R doInBackground(P... params);

    void onPostExecute(R result);
}

