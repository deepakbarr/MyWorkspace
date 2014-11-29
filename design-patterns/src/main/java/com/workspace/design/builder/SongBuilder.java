package com.workspace.design.builder;

/**
 * Created by deepak on 11/21/14.
 */
public class SongBuilder {

    private Song song;

    public SongBuilder() {
        this.song = new Song();
    }

    public SongBuilder addGuitar(String s) {
        this.song.setGuitar(s);
        return this;
    }

    public SongBuilder addPiano(String s) {
        this.song.setPiano(s);
        return this;
    }

    public SongBuilder addVocal(String s) {
        this.song.setVocal(s);
        return this;
    }

    public SongBuilder addDrums(String s) {
        this.song.setDrums(s);
        return this;
    }

    public Song build() {
        return song;
    }
}
