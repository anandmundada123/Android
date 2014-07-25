package com.example.amundada.todo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;


// Every Fragment will extend Fragment Activity
// This is abstract class for singleFragmentActivity
public abstract class SingleFragmentActivity extends FragmentActivity {

    abstract protected Fragment getFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // In Activity onCreate always contain following two lines of code
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do);

        // Get Fragment Manager (Always use support fragment manager)
        FragmentManager fm = getSupportFragmentManager();
        // Fragment is stored in fragment manger by ID
        Fragment fragment = fm.findFragmentById(R.id.fragmentContainer);

        if(fragment == null) {
            // fragment is null means this is first time we are creating fragment
            // fragment can be non null, when it is recreated on cross rotation.
            fragment = getFragment();

            // Add this fragment to fragment manager
            // Now fragment manager will inflate given fragment.
            fm.beginTransaction()
                    .add(R.id.fragmentContainer, fragment)
                    .commit();
        }
    }
}
