import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

class BookYourShow {
    public Show[] allShows;
    public int allShowsCount;
    public Patron[] allPatron;
    public int allPatronsCount;

    BookYourShow() {
        allShows = new Show[10];
        allShowsCount = 0;
        allPatron = new Patron[10];
        allPatronsCount = 0;
    }

    public void printTicket(String movieName, String date, String phno) {
        Show checkShow = getAShow(movieName, date);
        if (checkShow != null) {
            int flag = 0;
            for (int i =0; i < allPatronsCount; i++) {
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
    public void addAShow(Show show) {
        allShows[allShowsCount++] = show;

    }
    public void bookAShow(String movieName, String date, Patron patron, String[] seats) {
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
            } else {
                System.out.println("No show");
            }
        }
    }
    public Show getAShow(String movieName, String date) {
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

class Show {
    public String movieName;
    public String date;
    public String[] seats;
    Show(String movieName, String date, String[] seats) {
        this.movieName = movieName;
        this.date = date;
        this.seats = seats;

    }
}

class Patron {
    public String personName;
    public String phno;
    Patron(String personName, String phno) {
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