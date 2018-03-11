package com.example.android.p4;

import java.util.Comparator;

/**
 * Created by apple on 2018/3/11.
 */

public class SortBySingerPinIn implements Comparator<Singer> {
    public int compare(Singer singer1, Singer singer2) {
        String s1 = singer1.getmSingerNamePinIn();
        String s2 = singer2.getmSingerNamePinIn();
        return s1.compareToIgnoreCase(s2);
    }
}
