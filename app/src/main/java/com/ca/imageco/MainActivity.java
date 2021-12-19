package com.ca.imageco;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletionStage;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.ca.imageco";
    public static final String TAG = "";

    LinearLayout buttons_container;
    List<View> allButtons = new ArrayList<View>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        buttons_container = findViewById(R.id.buttons_container);

        // Get all touchable views
        allButtons = buttons_container.getTouchables();

        for (int i = 0; i < allButtons.size(); i++) {
            allButtons.get(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    createIntent(view, allButtons.indexOf(view));
                }
            });
        }


    }

    public void createIntent(View view, int tag) {
        Intent intent = new Intent(this, ImageProcessing.class);
        intent.putExtra(EXTRA_MESSAGE, ((Button) view).getText().toString());
        intent.putExtra(TAG, String.valueOf(tag));
        startActivity(intent);
    }
}