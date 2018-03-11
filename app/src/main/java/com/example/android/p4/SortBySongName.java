package com.example.android.p4;

import java.util.Comparator;

/**
 * Created by apple on 2018/3/10.
 */

public class SortBySongName implements Comparator<SongsImformation> {
    public int compare(SongsImformation song1, SongsImformation song2) {
        SongsImformation s1 = (SongsImformation) song1;
        SongsImformation s2 = (SongsImformation) song2;
        return s1.getmNameSongPinIn().compareToIgnoreCase(s2.getmNameSongPinIn());
    }

}
