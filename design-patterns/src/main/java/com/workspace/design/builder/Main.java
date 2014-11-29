package com.workspace.design.builder;

/**
 * Created by deepak on 11/21/14.
 */
public class Main {

    public static void main(String[] args) {
        SongBuilder songBuilder = new SongBuilder();
        Song song = songBuilder.addDrums("D").addGuitar("G").addPiano("P").addVocal("V").build();
        System.out.println("song = " + song);
    }
}
