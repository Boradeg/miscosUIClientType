package com.example.miscosuiclienttype;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private AttributeFragment listFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        replaceFragment(new AttributeFragment());
        // listFragment = (ListFragment) getSupportFragmentManager().findFragmentByTag("");

    }
    public void replaceFragment(AttributeFragment fragment) {
       // listFragment.test();
        // Begin the transaction
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        // Replace the contents of the container with the new fragment
        transaction.replace(R.id.fragment_container, fragment);
        // Complete the changes added above
        transaction.addToBackStack(null);
        // Commit the transaction
        transaction.commit();
    }
}