package entity;

public class Song {
    private static long counter = 0;
    private long id;
    private String title;
    private String genre;
    private int releaseYear;
    private String language;
    private long totalListens;

    public Song(String title, String genre, int releaseYear, String language) {
        counter++;
        this.id = counter;
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.language = language;
        this.totalListens = 0; //initial listen count will be 0
    }

    public void listen(){
        this.totalListens++;
    }

    public long getId() {
        return this.id;
    }

    public String getTitle() {
        return title;
    }
}
