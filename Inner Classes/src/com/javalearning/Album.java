package com.javalearning;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {

    private String name;
    private String artist;
    private SongList songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new SongList();
    }

    public boolean addSong(String songTitle, double songDuration) {
        return this.songs.add(new Song(songTitle,songDuration));
    }

    public boolean addToPlayList(int trackNumber , LinkedList<Song> playList) {
        Song checkedSong = this.songs.findSong(trackNumber);
        if(checkedSong != null) {
            playList.add(checkedSong);
            return true;
        }
        System.out.println("This album does not have a track " + trackNumber);
        return false;
    }

    public boolean addToPlayList(String songTitle , LinkedList<Song> playList) {
        Song checkedSong = this.songs.findSong(songTitle);
        if(checkedSong != null) {
            playList.add(checkedSong);
            return true;
        }
        else {
            System.out.println("This song " + songTitle + " is not in the album");
            return false;
        }
    }

    //Inner class

    private class SongList {
        private ArrayList<Song> songs;

        private SongList() {
            this.songs = new ArrayList<Song>();
        }

        private boolean add(Song song) {
            if(songs.contains(song)) {
                return false;
            }
            else {
                this.songs.add(song);
                return true;
            }
        }

        private Song findSong(String songTitle) {
            Song song = null;
            for(int i = 0; i < songs.size() ; i++) {
                Song checkedSong = songs.get(i);
                if(checkedSong.getTitle().equals(songTitle)) {
                    return checkedSong;
                }
            }
            return null;
        }

        private Song findSong(int trackNumber) {
            int index = trackNumber - 1;
            if((index >= 0 ) && (index < songs.size())) {
                return songs.get(index);
            }
            return null;
        }
    }
}