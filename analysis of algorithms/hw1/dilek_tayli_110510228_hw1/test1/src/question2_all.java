import static java.lang.Math.pow;

public class question2_all{
    /** IF YOU WANT TO RUN THIS CODE, YOU NEED TO UNCOMMENT THE WANTED PARTS...!!!!!!!!!! */

    public static void compare(long start,String function,double time) {
        /**  I added all the running times since I used them to fill the table. */

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

        if (function== "2^n") {
            int increment = 1;
            while (start<= time){
                increment++;
                start = (long) pow(2,increment);
            }
            System.out.println("The closest one for " + function + " in interval of  " +time + ": "  +(increment-1));
        }

        if (function== "n^3") {
            int increment = 1;
            while (start<= time){
                increment++;
                start = (long) pow(increment,3);
            }
            System.out.println("The closest one for " + function + " in interval of  " +time + ": "  +(increment-1));
        }

        if (function== "n^2") {
            int increment = 1;
            while (start<= time){
                increment++;
                start = (long) pow(increment,2);
            }
            System.out.println("The closest one for " + function + " in interval of  " +time + ": "  +(increment-1));
        }

        if (function== "logn") {
            int increment = 1;
            while (start<= time){
                increment++;
                start = (long) ((Math.log(increment) / Math.log(2)));
            }
            System.out.println("The closest one for " + function + " in interval of  " +time + ": "  +(increment-1));
        }

        if (function== "n") {
            int increment = 1;
            while (start<= time){
                increment++;
                start = increment;
            }
            System.out.println("The closest one for " + function + " in interval of  " +time + ": "  +(increment-1));
        }

        if (function== "n^(1/2)") {
            int increment = 1;
            while (start<= time){
                increment++;
                start = (long) pow(increment,0.5);
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

/*
        // 1 second => 19
       compare(0,"2^n",one_sec);
        // 1 minute => 25
        compare(0,"2^n",one_min);
        // 1 hour => 31
        compare(0,"2^n",one_hour);
        // 1 day => 36
       compare(0,"2^n",one_day);
        // 1 month => 41
        compare(0,"2^n",one_month);
        // 1 year => 44
        compare(0,"2^n",one_year);
        // 1 century => 51
        compare(0,"2^n",one_cen);
*/

/*
        // 1 second => 100
        compare(0,"n^3",one_sec);
        // 1 minute => 391
         compare(0,"n^3",one_min);
        // 1 hour => 1532
         compare(0,"n^3",one_hour);
        // 1 day => 4420
          compare(0,"n^3",one_day);
        // 1 month => 13736
         compare(0,"n^3",one_month);
        // 1 year =>31593
        compare(0,"n^3",one_year);
        // 1 century => 146677
           compare(0,"n^3",one_cen);
*/
/*
        // 1 second => 1000
        compare(0,"n^2",one_sec);
        // 1 minute => 7745
        compare(0,"n^2",one_min);
        // 1 hour => 60000
        compare(0,"n^2",one_hour);
        // 1 day => 293938
        compare(0,"n^2",one_day);
        // 1 month => 1609968
        compare(0,"n^2",one_month);
        // 1 year => 5615692
        compare(0,"n^2",one_year);
        // 1 century =>56175382
        compare(0,"n^2",one_cen);
*/


/*
        // 1 second =>
        compare(0,"logn",one_sec);
        // 1 minute =>
        compare(0,"logn",one_min);
        // 1 hour =>
        compare(0,"logn",one_hour);
        // 1 day =>
        compare(0,"logn",one_day);
        // 1 month =>
        compare(0,"logn",one_month);
        // 1 year =>
        compare(0,"logn",one_year);
        // 1 century =>
        compare(0,"logn",one_cen);
*/

/*
        // 1 second => 1000000
        compare(0,"n",one_sec);
        // 1 minute => 60000000
        compare(0,"n",one_min);
        // 1 hour =>
        compare(0,"n",one_hour);
        // 1 day =>
        compare(0,"n",one_day);
        // 1 month =>
        compare(0,"n",one_month);
        // 1 year =>
        compare(0,"n",one_year);
        // 1 century =>
        compare(0,"n",one_cen);

*/


/*
        // 1 second => 87901
        compare(0,"n^(1/2)",one_sec);
        // 1 minute => 3950201
        compare(0,"n^(1/2)",one_min);
        // 1 hour => 188909201
        compare(0,"n^(1/2)",one_hour);
        // 1 day => 3911758601
        compare(0,"n^(1/2)",one_day);
        // 1 month => 102245912601
        compare(0,"n^(1/2)",one_month);
        // 1 year =>
        compare(0,"n^(1/2)",one_year);
        // 1 century =>
        compare(0,"n^(1/2)",one_cen);
*/

    }
}