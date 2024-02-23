import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReportingIO {

    private Reporting reporting;

    public ReportingIO() {
        this.reporting = new Reporting(new ArrayList<>());
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Enter film studio data");
            System.out.println("2. Enter film data");
            System.out.println("3. List all film studios");
            System.out.println("4. List all films made by a given film studio");
            System.out.println("5. Provide reporting statistics");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    enterFilmStudioData(scanner);
                    break;
                case 2:
                    enterFilmData(scanner);
                    break;
                case 3:
                    listAllFilmStudios();
                    break;
                case 4:
                    listAllFilmsByFilmStudio(scanner);
                    break;
                case 5:
                    provideReportingStatistics(scanner);
                    break;
                case 6:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void enterFilmStudioData(Scanner scanner) {
        System.out.print("Enter film studio name: ");
        String name = scanner.nextLine();
        FilmStudio filmStudio = new FilmStudio(name);
        reporting.addFilmStudio(filmStudio);
        System.out.println("Film studio added successfully.");
    }

    private void enterFilmData(Scanner scanner) {
        System.out.print("Enter film studio name: ");
        String studioName = scanner.nextLine();
        FilmStudio filmStudio = reporting.getFilmStudio(studioName);
        if (filmStudio == null) {
            System.out.println("Film studio not found.");
            return;
        }
        System.out.print("Enter film title: ");
        String title = scanner.nextLine();
        System.out.print("Enter year of release: ");
        int yearOfRelease = scanner.nextInt();
        System.out.print("Enter length (in minutes): ");
        int length = scanner.nextInt();
        System.out.print("Enter box office earnings: ");
        double boxOfficeEarnings = scanner.nextDouble();
        System.out.print("Enter genre: ");
        scanner.nextLine(); // Consume newline
        String genre = scanner.nextLine();

        Film film = new Film(title, yearOfRelease, length, boxOfficeEarnings, genre);
        filmStudio.addFilm(film);
        System.out.println("Film added successfully.");
    }

    private void listAllFilmStudios() {
        List<FilmStudio> filmStudios = reporting.getFilmStudios();
        System.out.println("All Film Studios:");
        for (FilmStudio studio : filmStudios) {
            System.out.println(studio.getName());
        }
    }

    private void listAllFilmsByFilmStudio(Scanner scanner) {
        System.out.print("Enter film studio name: ");
        String studioName = scanner.nextLine();
        FilmStudio filmStudio = reporting.getFilmStudio(studioName);
        if (filmStudio == null) {
            System.out.println("Film studio not found.");
            return;
        }
        List<Film> films = filmStudio.getFilms();
        System.out.println("Films by " + studioName + ":");
        for (Film film : films) {
            System.out.println(film.getTitle());
        }
    }

    private void provideReportingStatistics(Scanner scanner) {
        System.out.println("Reporting Statistics:");
        // Implement reporting statistics logic
    }

    public static void main(String[] args) {
        ReportingIO reportingIO = new ReportingIO();
        reportingIO.start();
    }
}
