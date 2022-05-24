package com.ocem.Saloontion.model;

public class Specialmodel {

    private int mImage;
    private String mName;
    private String mDescript;



    public Specialmodel(int mImage, String mName, String mDescript) {
        this.mImage = mImage;
        this.mName = mName;
        this.mDescript = mDescript;
    }

    public int getmImage() {
        return mImage;
    }

    public void setmImage(int mImage) {
        this.mImage = mImage;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmDescript() { return mDescript; }

    public void setmDescript(String mDescript) { this.mDescript = mDescript; }

}

