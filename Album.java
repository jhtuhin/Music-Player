package com.JHTuhin;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album {
    private String name;
    private String artist;
    private List<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs=new ArrayList<Song>();
    }

    public boolean addSong(String title, double duration){
        if(findSong(title)==null){
            this.songs.add(new Song(title,duration));
            return true;
        }
        return false;
    }

    private Song findSong(String title){
        for(Song checkedSong: this.songs){
            if(checkedSong.getTitle().equals(title)){
                return checkedSong;
            }
        }
        return null;
    }

    public boolean addToPlaylist(int trackNumber, LinkedList<Song> playList){
        int index=trackNumber-1;
        if((index>=0) && (index<this.songs.size())){
            playList.add(this.songs.get(index));
            System.out.println("Track number "+trackNumber+" added to the play list");
            return true;
        }
        System.out.println("This album does not have a track "+trackNumber);
        return false;
    }

    public boolean addToPlaylist(String title, LinkedList<Song> playList){
        Song checkedSong=findSong(title);
        if(checkedSong!=null){
            playList.add(checkedSong);
            System.out.println("Song: "+title+" is added to the play list");
            return true;
        }
        System.out.println("Song: "+title+" Does not exist");
        return false;
    }
}
