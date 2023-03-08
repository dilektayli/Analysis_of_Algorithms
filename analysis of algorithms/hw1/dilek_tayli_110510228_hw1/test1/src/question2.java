import static java.lang.Math.pow;

public class question2 {
    /** IF YOU WANT TO RUN THIS CODE, YOU NEED TO UNCOMMENT THE WANTED PARTS...!!!!!!!!!! */

    public static void compare(long start,String function,double time) {
        /**  These are only 2 of the running time functions as it was wanted in the second question. If you want to check all function go to question2_all.java class!..*/

        if (function== "nlogn") {
            int increment = 1;
            while (start<= time){
                increment++;
                start = (long) (increment * (Math.log(increment) / Math.log(2)));
            }
            System.out.println("The closest one for " + function + " in interval of  " +time + ": "  +(increment-1));
       }

        if (function== "n!") {
            int increment = 1;
            while (start<= time){
                int fact = 1;
                increment++;
                for(int i=1;i<=increment;i++){
                    fact=fact*i;
                }
                start = fact ;
            }
            System.out.println("The closest one for " + function + " in interval of  " +time + ": "  +(increment-1));
        }

    }

    public static void main(String[] args){
        /** to reach the times easily */
        long one_sec = (long) Math.pow(10,6);
        long one_min = one_sec * 60;
        long one_hour = one_min*60;
        long one_day = one_hour*24;
        long one_month = one_day*30;
        long one_year = one_day*365;
        long one_cen = one_day*36524;

        /** all methods are commented out because some times are not compiled since they are huge numbers. */
        // That's why I left them empty here, but I completed them in the table with online calculating tools.

/*
        // 1 second => 62746
        compare(0,"nlogn",one_sec);
        // 1 minute => 2801417
        compare(0,"nlogn",one_min);
        // 1 hour => 133378058
        compare(0,"nlogn",one_hour);
        // 1 day =>
       compare(0,"nlogn",one_day);
        // 1 month =>
        compare(0,"nlogn",one_month);
        // 1 century =>
        compare(0,"nlogn",one_year);
        // 1 century =>
       compare(0,"nlogn",one_cen);
*/

/*
        // 1 second => 9
        compare(0,"n!",one_sec);
        // 1 minute => 11
        compare(0,"n!",one_min);
        // 1 hour =>
       compare(0,"n!",one_hour);
        // 1 day =>
        compare(0,"n!",one_day);
        // 1 month =>
        compare(0,"n!",one_month);
        // 1 year =>
        compare(0,"n!",one_year);
        // 1 century => compare("n!",one_cen)
       compare(0,"n!",one_cen);
*/
    }
}