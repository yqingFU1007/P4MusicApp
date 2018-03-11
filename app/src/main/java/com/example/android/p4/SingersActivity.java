package com.example.android.p4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;

public class SingersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singers);

        final ArrayList<SongsImformation> songs = AllSongsImformation.onCreate();
        Singer temp = new Singer("", "");

        final ArrayList<Singer> singerName = new ArrayList<Singer>();
        for (int i = 0; i < songs.size(); i++) {
            boolean flag = true;
            for (int j = 0; j < singerName.size(); j++) {
                if (singerName.get(j).getmSingerName().equals(songs.get(i).getSinger()))
                    flag = false;
                temp = new Singer(songs.get(i).getSinger(), songs.get(i).getmSingerPinIn());
            }
            if (flag) singerName.add(temp);
        }
        singerName.remove(0);
        Collections.sort(singerName, new SortBySingerPinIn());
        SingersAdapter adapter = new SingersAdapter(this, singerName);
        ListView listView = (ListView) findViewById(R.id.all_singers);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView adapterView, View view, int position, long id) {
                String singerNameString = singerName.get(position).getmSingerName();
                int albumNumber = singerName.get(position).getAlbumNumber(songs);
                int songNumber = singerName.get(position).getSongNumber(songs);
                Intent intent = new Intent(SingersActivity.this, SingerSongsActivity.class);

                Bundle bundle = new Bundle();
                bundle.putString("singerName", singerNameString);
                bundle.putInt("albumNumber", albumNumber);
                bundle.putInt("songNumber", songNumber);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });


    }
}
