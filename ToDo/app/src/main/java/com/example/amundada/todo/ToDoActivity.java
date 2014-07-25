package com.example.amundada.todo;

import android.support.v4.app.Fragment;


// Every Fragment will extend Fragment Activity
public class ToDoActivity extends SingleFragmentActivity {


    @Override
    protected Fragment getFragment() {
        return new ToDoFragment();
    }

}
