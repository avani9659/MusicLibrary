import entity.User;
import service.MusicLibraryService;

import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.util.Scanner;

public class MusicLibraryApplication {

    public static void main(String[] args) {
        MusicLibraryService service = new MusicLibraryService();

        Scanner sc = new Scanner(System.in);
        int choice = 0;
        while (choice != -1){
            printTemplate();
            choice = sc.nextInt();

            switch (choice){
                case 1:
                    registerUser(sc, service);
                    break;
                case 2:
                    registerArtist(sc, service);
                    break;
                case 3:
                    releaseSong(sc, service);
                    break;
                case 4:
                    listenToSong(sc, service);
                    break;
                case -1:
                    System.out.println("Quitting the Application");
                    break;
                default:
                    System.out.println("Please enter a valid choice.");
                    break;
            }
        }
    }

    public static void printTemplate(){
        System.out.println("-----------------------------------------------");
        System.out.println("Enter a choice from the following: ");
        System.out.println("1. Register a User.");
        System.out.println("2. Register an Artist.");
        System.out.println("3. Release a Song");
        System.out.println("4. Listen to a Song");
        System.out.println("-1. Quit the Application");
    }

    public static void registerUser(Scanner sc, MusicLibraryService service){
        System.out.println("Enter the First Name");
        String firstName = sc.next();

        System.out.println("Enter the Last Name");
        String lastName = sc.next();

        System.out.println("Enter the email id");
        String emailId = sc.next();

        System.out.println("Enter the Phone Number");
        long phoneNumber = sc.nextLong();

        System.out.println("Enter the City");
        String city = sc.next();

        System.out.println("Enter the Locality");
        String locality = sc.next();

        System.out.println("Enter the State");
        String state = sc.next();

        System.out.println("Enter the Pin Code");
        int pinCode = sc.nextInt();

        service.registerUser(firstName, lastName, emailId, phoneNumber, city, locality, state, pinCode);
    }

    public static void  registerArtist(Scanner sc, MusicLibraryService service){
        System.out.println("Enter the First Name");
        String firstName = sc.next();

        System.out.println("Enter the Last Name");
        String lastName = sc.next();

        service.registerArtist(firstName, lastName);
    }

    public static void releaseSong(Scanner sc, MusicLibraryService service){
        System.out.println("Enter the Title");
        String title = sc.next();

        System.out.println("Enter the Genre");
        String genre = sc.next();

        System.out.println("Enter the Release Year");
        int releaseYear = sc.nextInt();

        System.out.println("Enter the Language");
        String language = sc.next();

        System.out.println("Enter the Artist Id");
        long artistId = sc.nextLong();

        service.releaseSong(title, genre, releaseYear, language, artistId);
    }

    public static void listenToSong(Scanner sc, MusicLibraryService service){
        System.out.println("Enter the User Id");
        long userId = sc.nextLong();

        System.out.println("Enter the Song Id");
        long songId = sc.nextLong();

        service.listenToSong(userId, songId);
    }
}
