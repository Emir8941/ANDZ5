package com.example.lesson5;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;


public class OnBoardingItemFragment extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String ARG_PARAM3 = "param3";

    private TextView txtTitle, txtDescription;
    private ImageView itemImage;

    private String mTitle;
    private String mDescription;
    private int mImage;

    public OnBoardingItemFragment() {


    }


    public static OnBoardingItemFragment newInstance(String title, String description, int image) {
        OnBoardingItemFragment fragment = new OnBoardingItemFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, title);
        args.putString(ARG_PARAM2, description);
        args.putInt(ARG_PARAM3, image);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mTitle = getArguments().getString(ARG_PARAM1);
            mDescription = getArguments().getString(ARG_PARAM2);
            mImage = getArguments().getInt(ARG_PARAM3);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_on_boardingitem, container, false);
        txtTitle = view.findViewById(R.id.item_title);
        txtDescription = view.findViewById(R.id.item_description);
        itemImage = view.findViewById(R.id.item_img);
        txtTitle.setText(mTitle);
        txtDescription.setText(mDescription);
        itemImage.setImageResource(mImage);
        return view;

    }
}