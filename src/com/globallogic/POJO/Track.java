package com.globallogic.POJO;

public class Track {

    private String nameOfSong;
    private int lenghtOfSong;

    public Track(String nameOfSong, int lenghtOfSong) {
        super();
        this.nameOfSong = nameOfSong;
        this.lenghtOfSong = lenghtOfSong;
    }

    public String getName() {
        return nameOfSong;
    }

    public void setName(String nameOfSong) {
        this.nameOfSong = nameOfSong;
    }

    public int getLenght() {
        return lenghtOfSong;
    }

    public void setLenght(int lenghtOfSong) {
        this.lenghtOfSong = lenghtOfSong;
    }

    @Override
    public String toString() {
        return "Track{" +
                "nameOfSong='" + nameOfSong + '\'' +
                ", lenghtOfSong=" + lenghtOfSong +
                '}';
    }
}
