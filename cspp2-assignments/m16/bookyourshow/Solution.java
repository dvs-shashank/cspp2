import java.util.Scanner;
/**
 * Class for book your show.
 */
class BookYourShow {
    /**
     * { allShows }
     */
    public Show[] allShows;
    /**
     * { allShowsCount }
     */
    public int allShowsCount;
    /**
     * { allPatron }
     */
    public Patron[] allPatron;
    /**
     * { allPatronsCount }
     */
    public int allPatronsCount;
    /**
     * Constructs the object.
     */
    BookYourShow() {
        allShows = new Show[10];
        allShowsCount = 0;
        allPatron = new Patron[10];
        allPatronsCount = 0;
    }
    /**
     * prints ticket.
     *
     * @param      movieName  The movie name
     * @param      date       The date
     * @param      phno       The phno
     */
    public void printTicket(final String movieName, final String date, final String phno) {
        Show checkShow = getAShow(movieName, date);
        if (checkShow != null) {
            int flag = 0;
            for (int i = 0; i < allPatronsCount; i++) {
                if (allPatron[i].phno.equals(phno)) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 1) {
                System.out.println(phno + " " + movieName + " " + date);
            }
            else {
                System.out.println("Invalid");
            }
        } else {
            System.out.println("Invalid");
        }
    }
    /**
     * Adds a show.
     *
     * @param      show  The show
     */
    public void addAShow(final Show show) {
        allShows[allShowsCount++] = show;

    }
    /**
     * books shows.
     *
     * @param      movieName  The movie name
     * @param      date       The date
     * @param      patron     The patron
     * @param      seats      The seats
     */
    public void bookAShow(final String movieName, final String date, final Patron patron, final String[] seats) {
        Show checkShow = getAShow(movieName, date);
        int flag = 0;
        if (checkShow != null) {
            for (int i = 0; i < seats.length; i++) {
                //seats[i]
                for (int j = 0; j < checkShow.seats.length; j++) {
                    if (seats[i].equals(checkShow.seats[j])) {
                        checkShow.seats[j] = "N/A";
                        flag = 1;
                        //allPatron[allPatronsCount++] = patron;
                    }
                }
            }

        }
        for (int i = 0; i < allShowsCount; i++) {
            if (allShows[i].movieName.equals(checkShow.movieName) && allShows[i].date.equals(checkShow.date)) {
                allShows[i] = checkShow;
            }
            if (flag == 1) {
                allPatron[allPatronsCount++] = patron;
            }
        }
    }
    /**
     * Gets a show.
     *
     * @param      movieName  The movie name
     * @param      date       The date
     *
     * @return     A show.
     */
    public Show getAShow(final String movieName, final String date) {
        if (allShowsCount == 0) {
            System.out.println("No show");
        }
        for (int i = 0; i < allShowsCount; i++) {
            if (allShows[i].movieName.equals(movieName) && allShows[i].date.equals(date)) {
                return allShows[i];
            }
        }
        return null;
    }
    /**
     * Shows all Shows.
     */
    public void showAll() {
        for (int i = 0; i < allShowsCount; i++) {
            String st = allShows[i].movieName + "," + allShows[i].date + ",";
            String onlySeats = "[";
            for (int j = 0; j < allShows[i].seats.length; j++) {
                onlySeats += allShows[i].seats[j];
                if (i < allShows[i].seats.length - 1) {
                    onlySeats += ",";
                }
            }
            onlySeats += "]";
            st += onlySeats;
        }
    }
}
/**
 * Class for show.
 */
class Show {
    /**
     * movie name.
     */
    public String movieName;
    /**
     * date.
     */
    public String date;
    /**
     * seats array.
     */
    public String[] seats;
    /**
     * Constructs the object.
     *
     * @param      movieName  The movie name
     * @param      date       The date
     * @param      seats      The seats
     */
    Show(final String movieName, final String date, final String[] seats) {
        this.movieName = movieName;
        this.date = date;
        this.seats = seats;

    }
}
/**
 * Class for patron.
 */
class Patron {
    public String personName;
    public String phno;
    /**
     * Constructs the object.
     *
     * @param      personName  The person name
     * @param      phno        The phno
     */
    Patron(final String personName, final String phno) {
        this.personName = personName;
        this.phno = phno;
    }
}

/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
    }
    /**
     * main method to drive program.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        BookYourShow bys = new BookYourShow();
        Scanner scan = new Scanner(System.in);
        int testCases = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < testCases; i++) {
            String[] tokens = scan.nextLine().
                              replace("[", "").replace("]", "").split(",");
            String[] check = tokens[0].split(" ");
            switch (check[0]) {
            case "add":
                int k = 2;
                String[] seats = new String[tokens.length - 2];
                for (int j = 0; j < seats.length; j++) {
                    seats[j] = tokens[k++];
                }
                bys.addAShow(new Show(check[1], tokens[1], seats));
                break;

            case "book":
                k = 2 + 2;
                seats = new String[tokens.length - 2 - 2];
                for (int j = 0; j < seats.length; j++) {
                    seats[j] = tokens[k++];
                }
                bys.bookAShow(check[1], tokens[1],
                              new Patron(tokens[2], tokens[2 + 1]), seats);
                break;

            case "get":
                Show show = bys.getAShow(check[1], tokens[1]);
                if (show != null) {
                    System.out.println(show.movieName + "," + show.date);
                } else {
                    System.out.println("No show");
                }
                break;

            case "print":
                bys.printTicket(check[1], tokens[1], tokens[2]);
                break;

            case "showAll":
                bys.showAll();
                break;

            default:
                break;
            }
        }
    }
}