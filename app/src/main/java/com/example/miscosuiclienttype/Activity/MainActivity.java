package com.example.miscosuiclienttype.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.miscosuiclienttype.Fragment.AttributeFragment;
import com.example.miscosuiclienttype.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        replaceFragment(new AttributeFragment());
    }
    public void replaceFragment(AttributeFragment fragment) {
        // Begin the transaction
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        // Replace the contents of the container with the new fragment
        transaction.replace(R.id.fragment_container, fragment);
        // Complete the changes added above
       // transaction.addToBackStack(null);
        // Commit the transaction
        transaction.commit();
    }
}