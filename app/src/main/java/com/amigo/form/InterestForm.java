package com.amigo.form;

/**
 * Data object that corresponds to the interest form.
 */
public class InterestForm {
    private String music;
    private String sports;
    private String recreational;
    private String hobbies;
    /**
     * Returns the music interest
     */
    public String getMusic() {
        return music;
    }
    /**
     * Creates a music interest
     */
    public void setMusic(String music) {
        this.music = music;
    }
    /**
     * Returns the sport interest
     */
    public String getSports() {
        return sports;
    }
    /**
     * Creates a sport interest
     */
    public void setSports(String sports) {
        this.sports = sports;
    }
    /**
     * Returns the recreational interest
     */
    public String getRecreational() {
        return recreational;
    }
    /**
     * Creates a recreational interest
     */
    public void setRecreational(String recreational) {
        this.recreational = recreational;
    }
    /**
     * Returns the hobby interest
     */
    public String getHobbies() {
        return hobbies;
    }
    /**
     * Creates a hobby interest
     */
    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }
}
