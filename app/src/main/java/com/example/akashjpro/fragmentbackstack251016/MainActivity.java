package com.example.akashjpro.fragmentbackstack251016;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    android.app.FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getFragmentManager();

    }

    public void addA(View view){
        android.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.frameContent, new FragmentA(), "fragA");
        fragmentTransaction.addToBackStack("fragment_a");// them fragment a vao Stack
        fragmentTransaction.commit();
    }


    public void addB(View view){
        Toast.makeText(this, "add b", Toast.LENGTH_SHORT).show();
        android.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.frameContent, new FragmentB(), "fragB");
        fragmentTransaction.addToBackStack("fragment_b");// them fragment b vao Strack
        fragmentTransaction.commit();
    }


    public void replaceA(View view){
        Toast.makeText(this, "Thay the A", Toast.LENGTH_SHORT).show();
        android.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameContent, new FragmentA(), "fragA");
        fragmentTransaction.addToBackStack("fragment_a");
        fragmentTransaction.commit();
    }


    public void replaceB(View view){
        android.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameContent, new FragmentB(), "fragB");
        fragmentTransaction.addToBackStack("fragment_b");
        fragmentTransaction.commit();
    }

    public void RemoveA(View view){
        android.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentA fragmentA = (FragmentA) getFragmentManager().findFragmentByTag("fragA");
        if (fragmentA != null){
            fragmentTransaction.remove( fragmentA);
            fragmentTransaction.commit();
        }else {
            Toast.makeText(this, "Fragment A nonavaible ", Toast.LENGTH_SHORT).show();
        }

    }

    public void RemoveB(View view){
        android.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentA fragmentB = (FragmentA) getFragmentManager().findFragmentByTag("fragB");
        if (fragmentB != null){
            fragmentTransaction.remove( fragmentB);
            fragmentTransaction.commit();
        }else {
            Toast.makeText(this, "Fragment B nonavaible ", Toast.LENGTH_SHORT).show();
        }

    }

    // lay fragment A bo vao lai
    public  void  AttachA(View view){
        android.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentA fragmentA = (FragmentA) getFragmentManager().findFragmentByTag("fragA");
        if (fragmentA != null){
            fragmentTransaction.attach(fragmentA);
            fragmentTransaction.commit();
        }else {
            Toast.makeText(this, "Fragment A nonavaible ", Toast.LENGTH_SHORT).show();
        }

    }
    // cat fragment B vao chut lay ra
    public  void  DetachA(View view){
        android.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentA fragmentA = (FragmentA) getFragmentManager().findFragmentByTag("fragA");
        if (fragmentA != null){
            fragmentTransaction.detach(fragmentA);
            fragmentTransaction.commit();
        }else {
            Toast.makeText(this, "Fragment A nonavaible ", Toast.LENGTH_SHORT).show();
        }
    }

    public void  Back(View view){
        if (fragmentManager.getBackStackEntryCount()>0){
            fragmentManager.popBackStack();
        }else {
            Toast.makeText(this, "Fragment da het!!! ", Toast.LENGTH_SHORT).show();
        }

    }

    public void popA(View view){
        fragmentManager.popBackStack("fragment_a", 0);
    }

    @Override
    public void onBackPressed() {
        if (fragmentManager.getBackStackEntryCount()>0){
            fragmentManager.popBackStack();
        }else {
            super.onBackPressed();
        }

    }
}
