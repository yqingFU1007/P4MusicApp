package com.example.android.p4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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

        TextView singerName = this.findViewById(R.id.singer_single_name);
        TextView singerSongs =  this.findViewById(R.id.singer_single_songs);
        TextView singerAlbums =  this.findViewById(R.id.singer_single_album);

        Intent intent = getIntent();
        String singerNameString = intent.getStringExtra("singerName");
        String singerSongsString = intent.getIntExtra("songNumber", 0) + "首歌曲";
        String singerAlbumsString = "" + intent.getIntExtra("albumNumber", 0) + "张专辑";

        singerName.setText(singerNameString);
        singerSongs.setText(singerSongsString);
        singerAlbums.setText(singerAlbumsString);

        final ArrayList<SongsImformation> songsSinger = new ArrayList<>();
        for (int i = 0; i < songs.size(); i++) {
            if (songs.get(i).getSinger().equals(singerNameString)) {
                songsSinger.add(songs.get(i));
            }
        }
        ListAdapter adapter = new ListAdapter(this, songsSinger);
        ListView listView =  findViewById(R.id.singer_songs_list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView adapterView, View view, int position, long id) {

                String songNameString = songsSinger.get(position).getNameSong();
                String singerString = songsSinger.get(position).getSinger();
                String albumString = songsSinger.get(position).getAlbumName();

                int albumImage = songsSinger.get(position).getmAlbumImage();


                Intent intent = new Intent(SingerSongsActivity.this, PlayingActivity.class);

                Bundle bundle = new Bundle();
                bundle.putString("songName", songNameString);
                bundle.putString("singer", singerString);
                bundle.putString("album", albumString);
                bundle.putInt("image", albumImage);
                intent.putExtras(bundle);

                startActivity(intent);
            }
        });
    }
}
