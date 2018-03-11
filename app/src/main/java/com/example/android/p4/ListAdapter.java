package com.example.android.p4;

import android.app.Activity;
import android.app.ListActivity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by apple on 2018/3/10.
 */

public class ListAdapter extends ArrayAdapter<SongsImformation> {

    public ListAdapter(Activity context, ArrayList<SongsImformation> songs) {
        super(context, 0, songs);
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
        SongsImformation songCurrent = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID songName
        TextView song = (TextView) listItemView.findViewById(R.id.songName);
        // Get the songName text view from the current SongsImformation object and
        // set this text on the name TextView
        song.setText(songCurrent.getNameSong());

        // Find the TextView in the list_item.xml layout with the ID singerName
        TextView singer = (TextView) listItemView.findViewById(R.id.singerName);
        // Get the singer text view from the current SongsImformation object and
        // set this text on the singer TextView
        singer.setText(songCurrent.getSinger());

        // Find the TextView in the list_item.xml layout with the ID albumName
        TextView album = (TextView) listItemView.findViewById(R.id.albumName);
        // Get the album text view from the current SongsImformation object and
        // set this text on the album TextView
        album.setText(songCurrent.getAlbumName());


        // Return the whole list item layout (containing 2 TextViews)
        // so that it can be shown in the ListView
        return listItemView;
    }

}
