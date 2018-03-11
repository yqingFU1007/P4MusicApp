package com.example.android.p4;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by apple on 2018/3/11.
 */

public class SingersAdapter extends ArrayAdapter<Singer> {

    final ArrayList<SongsImformation> songs = AllSongsImformation.onCreate();

    public SingersAdapter(Activity context, ArrayList<Singer> singer) {
        super(context, 0, singer);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        // Get the {@link SongsImformation} object located at this position in the list
        Singer singerCurrent = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID songName
        TextView singerName = (TextView) listItemView.findViewById(R.id.songName);
        // Get the songName text view from the current SongsImformation object and
        // set this text on the name TextView
        singerName.setText(singerCurrent.getmSingerName());

        //Find the TextView in the list_item.xml layout with the ID singerName
        //Use this text view to show numbers of songs of one singer
        TextView songNumber = (TextView) listItemView.findViewById(R.id.singerName);
        songNumber.setText(singerCurrent.getSongNumber(songs) + "首歌曲");

        TextView albumNumber = (TextView) listItemView.findViewById(R.id.albumName);
        albumNumber.setText(singerCurrent.getAlbumNumber(songs) + "张专辑");


        // Return the whole list item layout (containing 2 TextViews)
        // so that it can be shown in the ListView
        return listItemView;
    }

}
