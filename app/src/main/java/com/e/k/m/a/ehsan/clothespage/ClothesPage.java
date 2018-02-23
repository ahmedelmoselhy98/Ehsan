package com.e.k.m.a.ehsan.clothespage;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import com.e.k.m.a.ehsan.R;

import java.util.ArrayList;
import java.util.List;

public class ClothesPage extends AppCompatActivity {
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private String clothesManText;
    private String clothesKidText;
    private String clothesWomanText;
    private CheckBox womanCheckBox6;
    private EditText womanEditText6Description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clothes_page);

        womanCheckBox6 = findViewById(R.id.fragment_clothes_woman_checkbox6);
        womanEditText6Description = findViewById(R.id.fragment_clothes_woman_edittext6_description);


        clothesManText = getResources().getString(R.string.clothes_man);
        clothesWomanText = getResources().getString(R.string.clothes_woman);
        clothesKidText = getResources().getString(R.string.clothes_kid);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new ClothesWomanFragment(), clothesWomanText);
        adapter.addFragment(new ClostherManFragment(), clothesManText);
        adapter.addFragment(new ClothesKidsFragment(), clothesKidText);
        viewPager.setAdapter(adapter);
    }


    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }


    public void o5ra(View view){
        womanCheckBox6 = findViewById(R.id.fragment_clothes_woman_checkbox6);
        womanEditText6Description = findViewById(R.id.fragment_clothes_woman_edittext6_description);

        if (womanCheckBox6.isChecked()){
        womanEditText6Description.setVisibility(View.VISIBLE);
    }else
            womanEditText6Description.setVisibility(View.GONE);
    }

}
