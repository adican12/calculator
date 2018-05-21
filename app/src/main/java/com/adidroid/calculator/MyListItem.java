package com.adidroid.calculator;


import android.support.annotation.Nullable;

public class MyListItem{
    private Class activity;
    private String label;
    private String packageName;

    public MyListItem(String label, Class activity) {
        this.label = label;
        this.activity = activity;
    }


    @Override
    public String toString() {
        if (activity != null) {
            return "Open " + label;
        }
        return label;
    }

    public String getLabel() {
        return label;
    }

    public String getPackageName() {
        return packageName;
    }

    public Class getActivity() {
        return activity;
    }
}
