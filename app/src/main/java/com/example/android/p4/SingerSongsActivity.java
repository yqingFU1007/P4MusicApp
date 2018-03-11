package com.example.android.p4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

public class SingerSongsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singer_songs);

        final ArrayList<SongsImformation> songs = AllSongsImformation.onCreate();
        Collections.sort(songs, new SortBySongName());

        TextView singerName = (TextView) this.findViewById(R.id.singer_single_name);
        TextView singerSongs = (TextView) this.findViewById(R.id.singer_single_songs);
        TextView singerAlbums = (TextView) this.findViewById(R.id.singer_single_album);

        Intent intent = getIntent();
        String singerNameString = intent.getStringExtra("singerName");
        String singerSongsString = intent.getIntExtra("songNumber", 0) + "首歌曲";
        String singerAlbumsString = "" + intent.getIntExtra("albumNumber", 0) + "张专辑";

        singerName.setText(singerNameString);
        singerSongs.setText(singerSongsString);
        singerAlbums.setText(singerAlbumsString);

        for (int i = 0; i < songs.size(); i++) {
            if (!songs.get(i).getSinger().equals(singerNameString)) {
                songs.remove(i);
            }
        }
        ListAdapter adapter = new ListAdapter(this, songs);
        ListView listView = (ListView) findViewById(R.id.singer_songs_list);
        listView.setAdapter(adapter);

    }
}
