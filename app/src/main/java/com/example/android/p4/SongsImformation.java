package com.example.android.p4;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import java.io.InputStream;

/**
 * Created by apple on 2018/3/9.
 */

public class SongsImformation {
    private String mNameSong;
    private String mNameSongPinIn;
    private String mSinger;
    private String mSingerPinIn;
    private int mAlbumPicture;
    private String mAlbumName;
    private boolean ifIsMyFavorite = false;
    private boolean ifIsBought = false;

    public SongsImformation(String nameSong, String singer, int albumPicture, String albumName, String nameSongPinIn, String singerPinIn) {
        mNameSong = nameSong;
        mSinger = singer;
        mAlbumPicture = albumPicture;
        mAlbumName = albumName;
        mNameSongPinIn = nameSongPinIn;
        mSingerPinIn = singerPinIn;
    }

    ;

    public String getNameSong() {
        return mNameSong;
    }

    public String getSinger() {
        return mSinger;
    }

    public String getAlbumName() {
        return mAlbumName;
    }

    public String getmNameSongPinIn() {
        return mNameSongPinIn;
    }

    public int getmAlbumImage() {
        return mAlbumPicture;
    }

    public String getmSingerPinIn() {
        return mSingerPinIn;
    }
}
