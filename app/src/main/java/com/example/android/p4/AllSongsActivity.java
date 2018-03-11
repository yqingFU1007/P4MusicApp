package com.example.android.p4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;

public class AllSongsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_songs);

        final ArrayList<SongsImformation> songs = AllSongsImformation.onCreate();
        Collections.sort(songs, new SortBySongName());
        ListAdapter adapter = new ListAdapter(this, songs);
        ListView listView = (ListView) findViewById(R.id.all_songs_list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView adapterView, View view, int position, long id) {

                String songNameString = songs.get(position).getNameSong();
                String singerString = songs.get(position).getSinger();
                String albumString = songs.get(position).getAlbumName();

                int albumImage = songs.get(position).getmAlbumImage();


                Intent intent = new Intent(AllSongsActivity.this, PlayingActivity.class);

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
