package com.ca.imageco;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ImageProcessing extends AppCompatActivity {

    FragmentManager fm;
    FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.processing_image);
        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String title = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        String tag = intent.getStringExtra(MainActivity.TAG);

        // Capture the layout's TextView and set the string as its text
        TextView image_processing_title = findViewById(R.id.image_processing_title);
        image_processing_title.setText(title);

        switch(tag) {
            case "0": createFragment(new ImageToText()); break;
            case "1": createFragment(new ImageToSpeech()); break;
            case "2": createFragment(new ImageCompressor());break;
            case "3": createFragment(new ImageResize());break;
        }
    }

    private void createFragment(Fragment fragment) {
        fm = getSupportFragmentManager();
        transaction = fm.beginTransaction();
        transaction.replace(R.id.contentFragment, fragment);
        transaction.commit();
    }
}