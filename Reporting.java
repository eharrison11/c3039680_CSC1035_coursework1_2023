import java.util.ArrayList;
import java.util.List;

public class Reporting {

    private List<FilmStudio> filmStudios;

    public Reporting(List<FilmStudio> filmStudios) {
        this.filmStudios = filmStudios;
    }

    public void addFilmStudio(FilmStudio filmStudio) {
        filmStudios.add(filmStudio);
    }

    public FilmStudio getFilmStudio(String name) {
        for (FilmStudio studio : filmStudios) {
            if (studio.getName().equals(name)) {
                return studio;
            }
        }
        return null;
    }

    public List<FilmStudio> getFilmStudios() {
        return filmStudios;
    }

    public Film getLongestFilmEver() {
        Film longestFilm = null;
        int maxLength = Integer.MIN_VALUE;
        for (FilmStudio studio : filmStudios) {
            for (Film film : studio.getFilms()) {
                if (film.getLength() > maxLength) {
                    maxLength = film.getLength();
                    longestFilm = film;
                }
            }
        }
        return longestFilm;
    }

    public FilmStudio getFilmStudioWithLargestAverageEarnings(int year) {
        FilmStudio studioWithLargestAvgEarnings = null;
        double maxAverageEarnings = Double.MIN_VALUE;
        for (FilmStudio studio : filmStudios) {
            double totalEarnings = 0;
            int filmCount = 0;
            for (Film film : studio.getFilms()) {
                if (film.getYearOfRelease() == year) {
                    totalEarnings += film.getBoxOfficeEarnings();
                    filmCount++;
                }
            }
            if (filmCount > 0) {
                double averageEarnings = totalEarnings / filmCount;
                if (averageEarnings > maxAverageEarnings) {
                    maxAverageEarnings = averageEarnings;
                    studioWithLargestAvgEarnings = studio;
                }
            }
        }
        return studioWithLargestAvgEarnings;
    }

    public List<Film> getFilmsWithEarningsLessThan(double amount) {
        List<Film> filmsWithEarningsLessThanAmount = new ArrayList<>();
        for (FilmStudio studio : filmStudios) {
            for (Film film : studio.getFilms()) {
                if (film.getBoxOfficeEarnings() < amount) {
                    filmsWithEarningsLessThanAmount.add(film);
                }
            }
        }
        return filmsWithEarningsLessThanAmount;
    }
}