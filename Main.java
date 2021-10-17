package com.JHTuhin;

import java.util.*;

public class Main {

    private static ArrayList<Album> albums = new ArrayList<Album>();

    public static void main(String[] args) {
	Album album = new Album("America","Imagine dragons");
	    album.addSong("America",04.41);
        album.addSong("Amsterdam",04.05);
        album.addSong("Bad Liar",04.44);
        album.addSong("Believer",03.37);
        albums.add(album);

        album =new Album("For those about to rock","AC/DC");
        album.addSong("For those about to rock",05.44);
        album.addSong("Let's go",03.44);
        album.addSong("C.O.D.",05.25);
        album.addSong("Breaking the rules",05.32);
        albums.add(album);

        LinkedList<Song> playList= new LinkedList<Song>();
        albums.get(0).addToPlaylist("Believer",playList);
        albums.get(0).addToPlaylist("Bad Liar",playList);
        albums.get(0).addToPlaylist("America",playList);
        albums.get(0).addToPlaylist("Demons",playList);
        albums.get(1).addToPlaylist(2,playList);
        albums.get(1).addToPlaylist(4,playList);
        albums.get(1).addToPlaylist(13,playList);

        play(playList);
    }
    public static void play(LinkedList<Song> playlist){
        Scanner scanner=new Scanner(System.in);
        boolean quit=false;
        boolean forward=true;
        ListIterator<Song> listIterator=playlist.listIterator();
        if(playlist.size()==0){
            System.out.println("No songs to play");
        }
        else{
            System.out.println("Now playing "+listIterator.next().toString());
        }
            while (!quit){
               int action=scanner.nextInt();
               scanner.nextLine();

               switch (action){
                   case 0:
                       System.out.println("Playlist complete");
                       quit=true;
                       break;
                   case 1:
                       if(!forward){
                           if(listIterator.hasNext()){
                               listIterator.next();
                           }
                           forward=true;
                       }
                       if(listIterator.hasNext()){
                           System.out.println("Now playing "+listIterator.next().toString());
                       }
                       else{
                           System.out.println("We have reached the end of the playlist");
                           forward=false;
                       }
                       break;
                   case 2:
                       if(forward){
                           if(listIterator.hasPrevious()){
                               listIterator.previous();
                           }
                           forward=false;
                       }
                       if(listIterator.hasPrevious()){
                           System.out.println("Now playing "+listIterator.previous().toString());
                       }
                       else{
                           System.out.println("We are at the start of the playlist");
                           forward=true;
                       }
                       break;
                   case 3:
                       if(forward){
                           if(listIterator.hasPrevious()){
                               System.out.println("Now replaying "+listIterator.previous().toString());
                               forward=false;
                           }
                           else {
                               System.out.println("We are at the start of the playlist");
                           }
                       }
                       else{
                           if(listIterator.hasNext()) {
                               System.out.println("Now replaying " + listIterator.next().toString());
                               forward=true;
                           }
                           else{
                               System.out.println("We have reached the end of the playlist");
                           }
                       }
                       break;
                   case 4:
                       printMenu();
                       break;
                   case 5:
                       playList(playlist);
                       break;
                   case 6:
                       if(playlist.size()>0){
                           listIterator.remove();
                           if(listIterator.hasNext()){
                               System.out.println("Now playing "+listIterator.next().toString());
                           }
                           else if(listIterator.hasPrevious()){
                               System.out.println("Now playing "+listIterator.previous().toString());
                           }
                       }
               }
            }
    }

    public static void printMenu(){
        System.out.println("Available actions:\npress");
        System.out.println("0 - to quit\n"+
                "1 - to play the next song\n"+
                "2 - to play the previous song\n"+
                "3 - to replay the song\n"+
                "4 - to print the action menu\n"+
                "5 - to see the playlist\n"+
                "6 - to remove the current song\n"
                );
    }

    public static void playList(LinkedList<Song> playlist){
        System.out.println("==========================");
       Iterator<Song> iterator=playlist.listIterator();
       while(iterator.hasNext()){
           System.out.println(iterator.next().toString());
       }
        System.out.println("==========================");
    }
}
