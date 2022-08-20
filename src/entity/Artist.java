package entity;

import java.util.ArrayList;
import java.util.List;

public class Artist {
    private static long counter = 0;
    private long id;
    private String firstName;
    private String lastName;
    private List<Song> releasedSongs;

    public Artist(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        counter++;
        this.id = counter;
        releasedSongs = new ArrayList<>(); //List is an interface, cannot create its object. ArrayList is its implementation
        //go for ArrayList when you need random access to objets. Use linkedList when random access is not required.
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return firstName + " " + lastName;
    }

    public void releaseSong(Song song){
        this.releasedSongs.add(song);
    }
}
