package com.example.lesson5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ViewPager pager;
    ViewPaperAdapter adapter;
    TextView txtSkip, txtNext;
    ImageView txtB1,txtB2,txtB3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pager = findViewById(R.id.view_paper);
        txtNext = findViewById(R.id.txt_next);
        txtSkip = findViewById(R.id.txt_skip);
        txtB1= findViewById(R.id.b_1);
        txtB2= findViewById(R.id.b_2);
        txtB3= findViewById(R.id.b_3);

        List<OnBoardingModel> list = new ArrayList<>();
        list.add(new OnBoardingModel("Welcome to Surf.", "", R.drawable.ic_baseline_account_circle));
        list.add(new OnBoardingModel("Design Template uploads Every Tuesday!", "", R.drawable.ic_baseline_account_circle));
        list.add(new OnBoardingModel("Download now!", "", R.drawable.ic_baseline_account_circle));
        adapter = new ViewPaperAdapter(list, getSupportFragmentManager());
        pager.setAdapter(adapter);

        txtSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);

            }
        });
        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        txtB1.setImageResource(R.drawable.tab_selector);
                        txtB2.setImageResource(R.drawable.unselected);
                        txtB3.setImageResource(R.drawable.unselected);
                        break;
                    case 1:
                        txtB1.setImageResource(R.drawable.unselected);
                        txtB2.setImageResource(R.drawable.tab_selector);
                        txtB3.setImageResource(R.drawable.unselected);

                    break;
                    case 2:
                    txtB1.setImageResource(R.drawable.unselected);
                    txtB2.setImageResource(R.drawable.unselected);
                    txtB3.setImageResource(R.drawable.tab_selector);
break;
                }
                if (position == 2 ) {


                    txtNext.setText("Finish");

                } else txtNext.setText("Next");

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        txtNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pager.getCurrentItem() == 2) {
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    startActivity(intent);
                } else {
                    pager.setCurrentItem(pager.getCurrentItem() + 1);
                }

            }
        });
    }
}