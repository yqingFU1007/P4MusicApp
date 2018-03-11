package com.example.android.p4;

import java.util.ArrayList;

/**
 * Created by apple on 2018/3/11.
 */

public class Singer {

    private String mSingerName;
    private String mSingerNamePinIn;
    private int mSongNumber = 0;
    private int mAlbumNumber = 0;
    private ArrayList<String> mAlbums = new ArrayList<>();
    private ArrayList<String> mSongs = new ArrayList<>();

    public Singer(String singerName, String singerNamePinIn) {
        mSingerName = singerName;
        mSingerNamePinIn = singerNamePinIn;

    }

    public int getSongNumber(ArrayList<SongsImformation> songs) {
        for (int i = 0; i < songs.size(); i++) {
            if (mSingerName.equals(songs.get(i).getSinger())) {
                if (!mSongs.contains(songs.get(i).getNameSong())) {
                    mSongs.add(songs.get(i).getNameSong());
                    mSongNumber++;
                }

            }
        }
        return mSongNumber;
    }

    public int getAlbumNumber(ArrayList<SongsImformation> songs) {
        for (int i = 0; i < songs.size(); i++) {
            if (mSingerName.equals(songs.get(i).getSinger())) {
                if (!mAlbums.contains(songs.get(i).getAlbumName())) {
                    mAlbums.add(songs.get(i).getAlbumName());
                    mAlbumNumber++;
                }
            }
        }
        return mAlbumNumber;
    }

    public String getmSingerName() {
        return mSingerName;
    }

    public String getmSingerNamePinIn() {
        return mSingerNamePinIn;
    }
}
