package com.srug.mobile.todo.common;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.util.Log;

import java.lang.ref.WeakReference;
import java.util.HashMap;

public class RetainedFragmentManager {

    protected final String mTag = getClass().getSimpleName();

    private final String mRetainedFragmentTag;

    private final WeakReference<FragmentManager> mFragmentManager;

    private RetainedFragment mRetainedFragment;

    public RetainedFragmentManager(FragmentManager fragmentManager, String retainedFragmentTag) {
        mFragmentManager = new WeakReference<>(fragmentManager);
        mRetainedFragmentTag = retainedFragmentTag;
    }

    public boolean firstTimeIn() {
        try {
            mRetainedFragment = (RetainedFragment)
                    mFragmentManager.get().findFragmentByTag(mRetainedFragmentTag);

            if (mRetainedFragment == null) {
                Log.d(mTag, "Creating new RetainedFragment " + mRetainedFragmentTag);
                mRetainedFragment = new RetainedFragment();
                mFragmentManager.get().beginTransaction().
                        add(mRetainedFragment,
                                mRetainedFragmentTag).commit();
                return true;
            }
            else {
                Log.d(mTag, "Returning existing RetainedFragment " + mRetainedFragmentTag);
                return false;
            }
        } catch (NullPointerException e) {
            Log.d(mTag, "NPE in firstTimeIn()");
            return false;
        }
    }

    public void put(String key, Object object) {
        mRetainedFragment.put(key, object);
    }

    public void put(Object object) {
        put(object.getClass().getName(), object);
    }

    @SuppressWarnings("unchecked")
    public <T> T get(String key) {
        return (T) mRetainedFragment.get(key);
    }

    public Activity getActivity() {
        return mRetainedFragment.getActivity();
    }

    public static class RetainedFragment extends Fragment {

        private HashMap<String, Object> mData = new HashMap<>();

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setRetainInstance(true);
        }

        public void put(String key, Object object) {
            mData.put(key, object);
        }

        public void put(Object object) {
            put(object.getClass().getName(), object);
        }

        @SuppressWarnings("unchecked")
        public <T> T get(String key) {
            return (T) mData.get(key);
        }
    }
}


