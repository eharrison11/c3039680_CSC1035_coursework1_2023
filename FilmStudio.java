import java.util.ArrayList;
import java.util.List;

/**
 * Represents a film studio.
 */
public class FilmStudio {
    private String name;
    private List<Film> films;

    /**
     * Constructs a new FilmStudio object with the given name.
     *
     * @param name The name of the film studio.
     */
    public FilmStudio(String name) {
        this.name = name;
        this.films = new ArrayList<>();
    }

    /**
     * Adds a film to the studio.
     *
     * @param film The film to add.
     */
    public void addFilm(Film film) {
        films.add(film);
    }

    /**
     * Returns the longest film produced by the studio.
     *
     * @return The longest film produced by the studio.
     */
    public Film getLongestFilm() {
        Film longestFilm = null;
        int maxLength = Integer.MIN_VALUE;
        for (Film film : films) {
            if (film.getLength() > maxLength) {
                maxLength = film.getLength();
                longestFilm = film;
            }
        }
        return longestFilm;
    }

    /**
     * Calculates the average box office earnings for the films produced by the studio in a given year.
     *
     * @param year The year for which to calculate the average earnings.
     * @return The average box office earnings for the films produced by the studio in the given year.
     */
    public double getAverageBoxOfficeEarnings(int year) {
        int count = 0;
        double totalEarnings = 0;
        for (Film film : films) {
            if (film.getYearOfRelease() == year) {
                count++;
                totalEarnings += film.getBoxOfficeEarnings();
            }
        }
        return count == 0 ? 0 : totalEarnings / count;
    }

    /**
     * Returns a list of all films produced by the studio with box office earnings less than a given amount.
     *
     * @param amount The maximum box office earnings allowed.
     * @return A list of films produced by the studio with earnings less than the given amount.
     */
    public List<Film> getFilmsWithEarningsLessThan(double amount) {
        List<Film> filteredFilms = new ArrayList<>();
        for (Film film : films) {
            if (film.getBoxOfficeEarnings() < amount) {
                filteredFilms.add(film);
            }
        }
        return filteredFilms;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Film> getFilms() {
        return films;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }
}
