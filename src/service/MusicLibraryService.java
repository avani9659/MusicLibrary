package service;

import dao.MusicInventory;
import entity.*;

public class MusicLibraryService {
    private MusicInventory inventory;

    public MusicLibraryService() {
        this.inventory = new MusicInventory();
    }

    public void registerUser(String firstName, String lastName, String emailId, long phoneNumber, String city, String locality, String state, int pinCode){
        Contact contact = new Contact(emailId, phoneNumber);
        Address address = new Address(city, locality, state, pinCode);
        User user = new User(firstName, lastName, contact, address);
        inventory.addUser(user);
        System.out.println("Registered User with id : " + user.getId() + ", name : " + user.getName());
    }

    public void registerArtist(String firstName, String lastName){
        Artist artist = new Artist(firstName, lastName);
        inventory.addArtists(artist);
        System.out.println("Registered Artist with id : " + artist.getId() + ", name : " + artist.getName());
    }

    public void releaseSong(String title, String genre, int releaseYear, String language, long artistId){
        Song song = new Song(title, genre, releaseYear, language);

        Artist artist = inventory.getArtistById(artistId);
        if (artist == null) {
            System.out.println("The artist with id: " + artistId + " is not registered to the Application");
        }
        else {
            artist.releaseSong(song);

            inventory.addSong(song);

            System.out.println("Release Song with id : " + song.getId() + ", title : " + song.getTitle());
        }
    }

    public void listenToSong(long userId, long songId){
        User user = inventory.getUserById(userId);
        Song song = inventory.getSongById(songId);

        if(user == null){
            System.out.println("The User id: " + userId + " is not registered");
        }
        else if(song == null){
            System.out.println("The Song id: " + songId + " is not released");
        }
        else {
            song.listen();
            user.listenToSong(song);

            System.out.println("User: " + user.getName() + " listening to Song: " + song.getTitle());
        }
    }
}
