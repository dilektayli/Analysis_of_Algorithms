import java.util.Arrays;
import java.util.Random;

public class insertion
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
        insertion_sort(testArray);
       print_array(testArray);

        //initialize elements of array with random integers
        for (int i = 0; i < array.length; i++)
            array[i] = rand.nextInt(100);

        System.out.println("random array");
        print_array(array);
        insertion_sort(array);
        print_array(array);

        //part(c) min, average, max running times

        statistics(1000, 1000);
        statistics(10000, 1000);
    }

    //part(a) implementing insertion sort algorithm as a method below
    public static void insertion_sort(int [] A)
    {
        int n = A.length;
        for(int i=1; i<n; i++){
            // first element is accepted as it is already sorted that's why we start from the second element of array
            int key = A[i];
            int j = i -1;

            while (j>=0&& A[j]>key){
                A[j+1] = A[j];
                j = j -1;
            }
            A[j+1] = key;
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
        // otherwise, the min value is not working. That is why I assigned to this huge value.
        max_time = 0;
        average_time = 0.0;
        sum_time = 0;

            for (int k = 0; k < n_repetitions; k++)
            {
                //initialize elements of array with random integers
                for(int i = 0; i<array_size; i++){
                    array[i] = rand.nextInt();
                }
                //call insertion sort method
                long startTime = System.nanoTime();
                insertion_sort(array);
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

