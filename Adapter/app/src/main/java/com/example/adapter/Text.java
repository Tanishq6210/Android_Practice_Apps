package com.example.adapter;

import android.media.Image;
import android.widget.ImageView;

public class Text {
    private String text1;
    private String text2;
    private int imageId;
    private int musicId = TO_CHECK;
    private final static int TO_CHECK = -1;

    public Text(String text1, String text2, int image) {
        this.text1 = text1;
        this.text2 = text2;
        this.imageId = image;
    }

    public Text(String text1, String text2, int image, int music) {
        this.text1 = text1;
        this.text2 = text2;
        this.imageId = image;
        this.musicId = music;
    }

    public int getMusicId() {
        return musicId;
    }

    public String getText1() {
        return text1;
    }

    public String getText2() {
        return text2;
    }

    public int getImageId() {
        return imageId;
    }

    boolean hasMusic(){
        return musicId != TO_CHECK;
    }
}
