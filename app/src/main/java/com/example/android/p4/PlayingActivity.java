package com.example.android.p4;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class PlayingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playing);

        TextView songName = (TextView) this.findViewById(R.id.playing_song_name);
        TextView singer = (TextView) this.findViewById(R.id.playing_singer);
        TextView album = (TextView) this.findViewById(R.id.playing_album);
        ImageView songImage = (ImageView) this.findViewById(R.id.playing_song_image);
        Intent intent = getIntent();
        String songNameString = intent.getStringExtra("songName");
        String singerString = intent.getStringExtra("singer");
        String albumString = intent.getStringExtra("album");
        int image = intent.getIntExtra("image", 0);
        songName.setText(songNameString);
        singer.setText(singerString);
        album.setText(albumString);

        if (image == 1) songImage.setImageResource(R.drawable.goodbye_christmas);
        if (image == 2) songImage.setImageResource(R.drawable.sheep);
        if (image == 3) songImage.setImageResource(R.drawable.this_is_love);
    }
}
