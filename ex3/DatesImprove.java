package ex3;

public class DatesImprove {

    /* Precondition: month is between 1 and 12, inclusive */
    /* Postcondition: returns the number of days in the given month */


    //bug fixed correct months to return the days expected
    public static int daysInMonth (int month) {
        if ((month == 4) ||(month == 9) ||  (month == 6) || (month == 11)) {
            return 30;
        }
        else return 31;
    }
    public static void main (String[] args) {
        int someMonth, someDay;
        int laterMonth, laterDay;

        //int aMonth; Why declare it here? Useless and bad code
        someMonth = Integer.parseInt(args[0]);
        someDay = Integer.parseInt(args[1]);

        laterMonth = Integer.parseInt(args[2]);
        laterDay = Integer.parseInt(args[3]);

        if(someMonth < 1 || someMonth > 12 || laterMonth < 1 || laterMonth > 12){
            throw new IllegalArgumentException("Month must be between 1 and 12");
        }
        /* Used to record what day in the year the first day  */
        /* of someMonth and laterMonth are. */
        int someDayInYear = 0;
        int laterDayInYear = 0;

        //start from 1 and not 0
        for (int aMonth = 1; aMonth < someMonth; aMonth = aMonth + 1) {
            someDayInYear += daysInMonth(aMonth);
        }
        someDayInYear += someDay;

        for (int aMonth = 1; aMonth < laterMonth; aMonth = aMonth + 1) {
            laterDayInYear += daysInMonth(aMonth);
        }
        laterDayInYear += laterDay;

        /* The answer */
        int daysBetween = 0;
        System.out.println("The difference in days between " +
                someMonth + "/" + someDay + " and " +
                laterMonth + "/" + laterDay + " is: ");
        daysBetween = laterDayInYear - someDayInYear;

        System.out.println(daysBetween);
    }
}
