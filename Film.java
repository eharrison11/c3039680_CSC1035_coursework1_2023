
import java.util.ArrayList;
import java.util.List;

public class Film {
    private String title;
    private int yearOfRelease;
    private int length;
    private double boxOfficeEarnings;
    private String genre;

    /**
     * Constructs a new Film object with the given attributes.
     *
     * @param title            The title of the film.
     * @param yearOfRelease    The year of release of the film.
     * @param length           The length of the film in minutes.
     * @param boxOfficeEarnings The box office earnings of the film in pounds.
     * @param genre            The genre of the film.
     */
    public Film(String title, int yearOfRelease, int length, double boxOfficeEarnings, String genre) {
        this.title = title;
        this.yearOfRelease = yearOfRelease;
        this.length = length;
        this.boxOfficeEarnings = boxOfficeEarnings;
        this.genre = genre;
    }

    // Getters and setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public double getBoxOfficeEarnings() {
        return boxOfficeEarnings;
    }

    public void setBoxOfficeEarnings(double boxOfficeEarnings) {
        this.boxOfficeEarnings = boxOfficeEarnings;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
