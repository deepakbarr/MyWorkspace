package com.workspace.design.builder;

/**
 * Created by deepak on 11/21/14.
 */
public class Song {

    String guitar;
    String piano;
    String vocal;
    String drums;

    public void setGuitar(String guitar) {
        this.guitar = guitar;
    }

    public void setPiano(String piano) {
        this.piano = piano;
    }

    public void setVocal(String vocal) {
        this.vocal = vocal;
    }

    public void setDrums(String drums) {
        this.drums = drums;
    }

    @Override
    public String toString() {
        return "Song{" +
                "guitar='" + guitar + '\'' +
                ", piano='" + piano + '\'' +
                ", vocal='" + vocal + '\'' +
                ", drums='" + drums + '\'' +
                '}';
    }
}
