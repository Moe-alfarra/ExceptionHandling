import java.util.Scanner; // Command used to import Scanner
import java.util.StringTokenizer; // Command used to import StringTokenizer

/**
 * This is the main program that is used to run the program
 */

public class Test {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in); // Scanner object

        // Defining Variables
        String date;
        boolean done;
        int i = 0;
        int month = 0, year = 0, day = 0;
        StringTokenizer st;

        // While loop that runs 4 times to ask the user to enter a date to parse
        while(i < 4) {

            // Try-Catch that checks if the date is invalid
            try {
                System.out.println("Enter date to parse (MM/DD/YYYY format): ");
                date = keyboard.next();
                st = new StringTokenizer(date, "/"); // StringTokenizer object
                month = Integer.parseInt(st.nextToken()); // Converts the string of the month in the StringTokenizer object to int
                day = Integer.parseInt(st.nextToken()); // Converts the string of the day in the StringTokenizer object to int
                year = Integer.parseInt(st.nextToken()); // Converts the string of the year in the StringTokenizer object to int
            } catch (Exception e) {
                System.out.println("Invalid Date.");
                System.out.println("Reenter a valid date to parse (MM/DD/YYYY format): ");
                date = keyboard.next();
            }
            done = false;

            // While loop that keeps on running as long as there is an error like invalid month, day or year
            while (!done) {
                // Try-catch that checks if the user enters an invalid month, day or year
                try {
                    // If user enters invalid year the program throws a YearException
                    if (year < 1000 || year > 3000) {
                        throw new YearException("Invalid year. Reenter a valid year: ");
                    }
                    // If user enters invalid month the program throws a MonthException
                    if (month <= 0 || month > 12) {
                        throw new MonthException("Invalid month. Reenter a valid month: ");
                    }
                    // If user enters invalid day for any month the program throws a DayException
                    if (day < 1 || day > endingDay(month, year)) {
                        throw new DayException("Invalid day. Reenter a valid day: ");
                    }

                    // Else if the user enters a correct date then done is true and the while loop terminates
                    else {
                        done = true;
                    }
                    System.out.println("Parsed date: " + convertMonth(month) + " " + day + ", " + year);
                    System.out.println();


                } catch (YearException e) {
                    System.out.println(e.getMessage());
                    year = keyboard.nextInt(); // Catch statement to handle the YearException and asks the user to reenter a new year
                } catch (MonthException e) {
                    System.out.println(e.getMessage());
                    month = keyboard.nextInt(); // Catch statement to handle the MonthException and asks the user to reenter a new month
                } catch (DayException e) {
                    System.out.println(e.getMessage());
                    day = keyboard.nextInt(); // Catch statement to handle the DayException and asks the user to reenter a new day
                } catch(Exception e) {
                    System.out.println("Invalid Date");
                }
            }
            i++; // Increment i by 1 after the loop runs
        }
    }

    /**
     * This is the convertMonth method that is used to convert a numerical number of the month into its corresponding name
     * @param month int
     * @return String
     */
    public static String convertMonth(int month) {
        // If month is 1 returns January
        if (month == 1) {
            return "January";
        }
        // If month is 2 returns February
        if (month == 2) {
            return "February";
        }
        // If month is 3 returns March
        if (month == 3) {
            return "March";
        }
        // If month is 4 returns April
        if (month == 4) {
            return "April";
        }
        // If month is 5 returns May
        if (month == 5) {
            return "May";
        }
        // If month is 6 returns June
        if (month == 6) {
            return "June";
        }
        // If month is 7 returns July
        if (month == 7) {
            return "July";
        }
        // If month is 8 returns August
        if (month == 8) {
            return "August";
        }
        // If month is 9 returns September
        if (month == 9) {
            return "September";
        }
        // If month is 10 returns October
        if (month == 10) {
            return "October";
        }
        // If month is 11 returns November
        if (month == 11) {
            return "November";
        }
        // If month is 12 returns December
        if (month == 12) {
            return "December";
        }
        // Else if user inputs invalid month returns empty
        else {
            return "";
        }
    }

    /**
     * This is the endingDay method that is used to determine the ending day of a month based on the year
     * @param month int
     * @param year int
     * @return int
     */
    public static int endingDay(int month, int year) {
        // If month is 1 or Jan returns 31 as the ending day
        if (month == 1)
        {
            return 31;
        }
        // Else if month is 2 or Feb returns 29 if it's a leap year or 28 if it's not a leap year
        else if (month == 2)
        {
            if (year % 400 == 0)
            {
                return 29;
            }
            else if (year % 100 == 0)
            {
                return 28;
            }
            else if (year % 4 == 0)
            {
                return 29;
            }
            else
            {
                return 28;
            }
        }
        // Else if month is 3 or Mar returns 31 as the ending day
        else if (month == 3)
        {
            return 31;
        }
        // Else if month is 4 or Apr returns 30 as the ending day
        else if (month == 4)
        {
            return 30;
        }
        // Else if month is 5 or May returns 31 as the ending day
        else if (month == 5)
        {
            return 31;
        }
        // Else if month is 6 or Jun returns 30 as the ending day
        else if (month == 6)
        {
            return 30;
        }
        // Else if month is 7 or Jul returns 31 as the ending day
        else if (month == 7)
        {
            return 31;
        }
        // Else if month is 8 or Aug returns 31 as the ending day
        else if (month == 8)
        {
            return 31;
        }
        // Else if month is 9 or Sep returns 30 as the ending day
        else if (month == 9)
        {
            return 30;
        }
        // Else if month is 10 or Oct returns 31 as the ending day
        else if (month == 10)
        {
            return 31;
        }
        // Else if month is 11 or Nov returns 30 as the ending day
        else if (month == 11)
        {
            return 30;
        }
        // Else if month is 12 or Dec returns 31 as the ending day
        else if (month == 12)
        {
           return 31;
        }
        // Else if the user inputs invalid month it returns 0
        else {
            return 0;
        }
    }

}
