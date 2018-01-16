package com.globallogic.POJO;

public class Track {

    private String nameOfSong;
    private int lenghtOfSong;

    public Track(String nameOfSong, int lenghtOfSong) {
        super();
        this.nameOfSong = nameOfSong;
        this.lenghtOfSong = lenghtOfSong;
    }

    public String getNameOfSong() {
        return nameOfSong;
    }

    public void setNameOfSong(String nameOfSong) {
        this.nameOfSong = nameOfSong;
    }

    public int getLenghtOfSong() {
        return lenghtOfSong;
    }

    public void setLenghtOfSong(int lenghtOfSong) {
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
