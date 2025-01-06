package gr.aueb.cf.projects.project5;

public class Project5 {

    static boolean[][] array = new boolean[30][12];

    public static void main(String[] args) {
        char column = 'B';
        int row = 2;
        try {
            book(column, row);
            cancel(column, row);
            cancel(column, row);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void book(char column, int row) {
        updateBooking(column, row, true);
    }

    public static void cancel(char column, int row) {
        updateBooking(column, row, false);
    }

    public static void updateBooking(char column, int row, boolean booked) {
        int asciiColumn = (int) column - (int) 'A';
        if (row > 30 || row < 0 || column > 'L') {
            throw new IllegalArgumentException("Invalid input in row or column");
        }
        if ((booked && array[row - 1][asciiColumn]) || (!booked && !array[row - 1][asciiColumn])) {
            throw new IllegalArgumentException("The seat " + column + row + " is already " + (booked ? "booked" : "canceled"));
        }
        array[row - 1][asciiColumn] = booked;
        System.out.printf("\nYou have %s the seat %c%d\n", booked ? "booked" : "canceled", column, row);
    }

}
