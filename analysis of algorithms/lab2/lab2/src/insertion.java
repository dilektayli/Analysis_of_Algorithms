import java.util.Arrays;
import java.util.Random;

public class insertion
{
    public static void main(String [] args)
    {
        int array_size = 10000;
        int array [] = new int[array_size];

        Random rand = new Random();
        rand.setSeed(System.currentTimeMillis());

        //initialize elements of array with random integers
        for (int i = 0; i < array.length; i++)
            array[i] = rand.nextInt(100);

        //part 1(c)
        System.out.println("random array to be sorted in ascending order");
       // print_array(array);
        insertion_sort(array);
        System.out.println("sorted random array in ascending order");
        //print_array(array);


        /** Best case */
        System.out.println("sorted array to be send again");
        long startTime = System.nanoTime();
        insertion_sort(array);
        long endTime = System.nanoTime();
        long elapsed = endTime - startTime;
       // print_array(array);
        System.out.println("best case: "+elapsed);


        //part 1(d)
        System.out.println("random array to be sorted in descending order");
        // print_array(array);
        insertion_sort_reverse(array);
        System.out.println("sorted array in descending order");
        //  print_array(array);

        /** worst case */
        System.out.println("reverse sorted array to be send again");
        long startTime_reverse = System.nanoTime();
        insertion_sort(array);
        long endTime_reverse = System.nanoTime();
        long elapsed_reverse = endTime_reverse - startTime_reverse;
        //  print_array(array);
        System.out.println("worst case: "+elapsed_reverse);


        //part 1(e)
        /** For this part I changed the array size of the random array and then found the values of running time.*/
//int array_size = 100000;
    }

    //part 1(a) implementing insertion sort algorithm as a method below
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

    //part 1(b) implementing insertion sort algorithm that sorts in descending order as a method below
    public static void insertion_sort_reverse(int [] A)
    {
        /** in order to be descending, I just change A[j]>key to key>A[j] to find the bigger value between them. */
        int n = A.length;
        for(int i=1; i<n; i++){
            // first element is accepted as it is already sorted that's why we start from the second element of array
            int key = A[i];
            int j = i -1;

            while (j>=0&& key>A[j]){
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
}

