package com.example.android.miwok;

public class Word {
    
    private final String mdefaultTranslation;
    private final String mmiwokTranslation;
    private int mimageResourseId = NO_IMAGE;
    private int mmusicResourceId = NO_MUSIC;
    private static final int NO_IMAGE = -1;
    private static final int NO_MUSIC = -1;

    /**
     *
     * @param defaultTranslation
     * @param miwokTranslation
     */
    public Word(String defaultTranslation, String miwokTranslation){
        this.mdefaultTranslation = defaultTranslation;
        this.mmiwokTranslation = miwokTranslation;

    }

    /**
     *
     * @param defaultTranslation
     * @param miwokTranslation
     * @param musicResourceId
     */
    public Word(String defaultTranslation, String miwokTranslation, int musicResourceId){
        this.mdefaultTranslation = defaultTranslation;
        this.mmiwokTranslation = miwokTranslation;
        this.mmusicResourceId = musicResourceId;
    }

    /**
     *
     * @param defaultTranslation
     * @param miwokTranslation
     * @param imageResourseId
     * @param musicResourseId
     */
    public Word(String defaultTranslation, String miwokTranslation, int imageResourseId, int musicResourseId){
        this.mdefaultTranslation = defaultTranslation;
        this.mmiwokTranslation = miwokTranslation;
        this.mimageResourseId = imageResourseId;
        this.mmusicResourceId = musicResourseId;
    }

    /**
     * return music resource id
     * @return
     */
    public int getMmusicResourceId() {
        return mmusicResourceId;
    }

    /**
     * return getDefaultTranslation
     * @return
     */
    public String getDefaultTranslation() {
        return mdefaultTranslation;
    }

    /**
     * return miwok translation
     * @return
     */
    public String getMiwokTranslation() {
        return mmiwokTranslation;
    }

    public int getImageResourseId() {
        return mimageResourseId;
    }

    public boolean hasImage(){
        return mimageResourseId != NO_IMAGE;
    }

    @Override
    public String toString() {
        return "Word{" +
                "mdefaultTranslation='" + mdefaultTranslation + '\'' +
                ", mmiwokTranslation='" + mmiwokTranslation + '\'' +
                ", mimageResourseId=" + mimageResourseId +
                ", mmusicResourceId=" + mmusicResourceId +
                '}';
    }
}