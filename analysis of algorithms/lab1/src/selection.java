import java.util.Arrays;
import java.util.Random;

public class selection
{
    public static void main(String [] args)
    {
        int array_size = 10;
        int n_repetitions = 10;

        int array [] = new int[array_size];

        Random rand = new Random();
        rand.setSeed(System.currentTimeMillis());

        //part(b) choosing one integer array and showing that the sort method works
        System.out.println("test array");
        int testArray[] = {6,4,7,5,2,1,70,84,93,107};
        print_array(testArray);
        selection_sort(testArray);
        print_array(testArray);

        //initialize elements of array with random integers
        for (int i = 0; i < array.length; i++)
            array[i] = rand.nextInt(100);

        System.out.println("random array");

        print_array(array);
        selection_sort(array);
        print_array(array);

        //part(c) min, average, max running times

        statistics(1000, 1000);
        statistics(10000, 1000);
    }

    //part(a) implementing selection sort algorithm as a method below
    public static void selection_sort(int [] A)
    {
        int n = A.length;
        for (int i = 0; i < n-1; i++)
        {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (A[j] < A[min_idx])
                    min_idx = j;

            // change min element with the first element

            int temp = A[min_idx];
            A[min_idx] = A[i];
            A[i] = temp;
        }
    }

    //prints the elements of the array A on the screen
    public static void print_array(int [] A)
    {
        System.out.printf("[");
        for (int i = 0; i < A.length-1; i++)
        {
            System.out.printf("%d, ", A[i]);
        }

        System.out.printf("%d]\n", A[A.length-1]);

    }

    //part (c) compute min, average, max times for repeatedly sorting random arrays
    public static void statistics(int array_size, int n_repetitions)
    {
        long min_time, max_time, sum_time;
        double average_time;

        int array [] = new int[array_size];

        Random rand = new Random();
        rand.setSeed(System.currentTimeMillis());

        min_time = 1000000000;
        max_time = 0;
        average_time = 0.0;
        sum_time = 0;

        for (int k = 0; k < n_repetitions; k++)
        {
            //initialize elements of array with random integers
            for(int i = 0; i<array_size; i++){
                array[i] = rand.nextInt();
            }
            //call selection sort method
            long startTime = System.nanoTime();
            selection_sort(array);
            long endTime = System.nanoTime();
            long elapsed = endTime - startTime;
            //compute min_time, max_time, sum_time

            if(elapsed<min_time){
                min_time =elapsed;
            }
            if(elapsed> max_time){
                max_time = elapsed;
            }
            sum_time += elapsed;

        }

        average_time = (double) sum_time / (double) n_repetitions;

        System.out.printf("Min time: %d\n", min_time);
        System.out.printf("Average time: %.2f\n", average_time);
        System.out.printf("Max time: %d\n", max_time);

    }

}

