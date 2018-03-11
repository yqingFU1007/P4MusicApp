package com.example.android.p4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the View that shows all the songs
        TextView allSongs = (TextView) findViewById(R.id.all_songs);

        // Set a click listener on that View
        allSongs.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the all songs View is clicked on.
            @Override
            public void onClick(View view) {
                Intent allSongsIntent = new Intent(MainActivity.this, AllSongsActivity.class);
                startActivity(allSongsIntent);
            }
        });

        // Find the View that shows all the singers
        TextView singers = (TextView) findViewById(R.id.singers);

        // Set a click listener on that View
        singers.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the singers View is clicked on.
            @Override
            public void onClick(View view) {
                Intent singersIntent = new Intent(MainActivity.this, SingersActivity.class);
                startActivity(singersIntent);
            }
        });

    }
}
