package com.marioapps.prestigefashionitems;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.marioapps.prestigefashionitems.Fragments.HomeFragment;
import com.marioapps.prestigefashionitems.Fragments.ProfileFragment;
import com.marioapps.prestigefashionitems.Fragments.WebsiteFragment;

public class MainActivity extends AppCompatActivity {

    private Fragment homeFragment = new HomeFragment();
    private Fragment profileFragment= new ProfileFragment();
    private Fragment websiteFragment= new WebsiteFragment();

    private FrameLayout frameLayout;

    FragmentManager fm = getSupportFragmentManager();
    private Fragment activeFragment = homeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frameLayout = findViewById(R.id.fragmentFrameLayout);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);
        bottomNavigationView.setSelectedItemId(R.id.nav_home);
        fm.beginTransaction().replace(R.id.fragmentFrameLayout, new HomeFragment()).commit();

//        fm.beginTransaction().add(R.id.fragmentFrameLayout, profileFragment, "1").hide(profileFragment).commit();
//        fm.beginTransaction().add(R.id.fragmentFrameLayout, homeFragment, "2").commit();
//        fm.beginTransaction().add(R.id.fragmentFrameLayout, websiteFragment, "3").hide(websiteFragment).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                    Fragment selectedFragment = null;

                    switch (item.getItemId()){
                        case R.id.nav_profile:
                            frameLayout.removeView(activeFragment.getView());
                            fm.beginTransaction().remove(activeFragment).add(R.id.fragmentFrameLayout, profileFragment,"1").commit();
                            activeFragment = profileFragment;
                            return true;
                        case R.id.nav_home:
                            fm.beginTransaction().remove(activeFragment).add(R.id.fragmentFrameLayout, homeFragment,"2").commit();
                            activeFragment = homeFragment;
                            return true;
                        case R.id.nav_website:
                            fm.beginTransaction().remove(activeFragment).add(R.id.fragmentFrameLayout, websiteFragment,"3").commit();
                            activeFragment = websiteFragment;
                            return true;
                    }

//                    FragmentManager fragmentManager = getSupportFragmentManager();
//                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                    fragmentTransaction.replace(R.id.fragmentFrameLayout, selectedFragment).commit();

                    return false;
                }
            };


}
