package com.example.soubhagya.bloodapp.firstTimeDetails;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.soubhagya.bloodapp.MainActivity;
import com.example.soubhagya.bloodapp.R;
import com.example.soubhagya.bloodapp.utils.SharedPrefManager;

public class DetailsSliderActivity extends AppCompatActivity {

    private static final int TOTAL_ITEMS = 3;

    private ViewPager mViewPager;
    private LinearLayout mDotsLayout;
    private TextView[] mDots;
    private Button mButtonNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Making notification bar transparent
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow()
                    .getDecorView()
                    .setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }

        setContentView(R.layout.activity_details_slider);

        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        mDotsLayout = (LinearLayout) findViewById(R.id.layoutDots);
        mButtonNext = (Button) findViewById(R.id.button_next);

        // adding bottom dots
        addBottomDots(0);

        // making notification bar transparent
        changeStatusBarColor();

        FragmentManager fragmentManager = getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentStatePagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int position) {
                switch (position) {
                    case 0:
                        return new WelcomeFragment();
                    case 1:
                        return new PersonalDetailFragment();
                    case 2:
                        return new ContactsDetailFragment();
                    default:
                        return null;
                }
            }

            @Override
            public int getCount() {
                return TOTAL_ITEMS;
            }
        });

        mButtonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int current = mViewPager.getCurrentItem();
                switch (current) {
                    case 0: {
                        WelcomeFragment.addUserIdToDatabase();
                        mViewPager.setCurrentItem(current + 1);
                        break;
                    }
                    case 1: {
                        PersonalDetailFragment.addPersonalToDatabase();
                        mViewPager.setCurrentItem(current + 1);
                        break;
                    }
                    case 2: {
                        ContactsDetailFragment.addContactsToDatabase();
                        startActivity(new Intent(DetailsSliderActivity.this, MainActivity.class));
                        finish();
                    }
                }
            }
        });

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                addBottomDots(position);

                if (position == (TOTAL_ITEMS - 1)) {
                    mButtonNext.setText(R.string.end);
                }
                else {
                    mButtonNext.setText(R.string.next);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void addBottomDots(int currentPage) {
        mDots = new TextView[TOTAL_ITEMS];

        int[] colorsActive = getResources().getIntArray(R.array.array_dot_active);
        int[] colorsInactive = getResources().getIntArray(R.array.array_dot_inactive);

        mDotsLayout.removeAllViews();
        for (int i = 0; i < mDots.length; i++) {
            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226;"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(colorsInactive[currentPage]);
            mDotsLayout.addView(mDots[i]);
        }

        if (mDots.length > 0)
            mDots[currentPage].setTextColor(colorsActive[currentPage]);
    }

    private void changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
    }

}
