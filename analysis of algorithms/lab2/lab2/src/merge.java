import java.util.Arrays;
import java.util.Random;

public class merge
{
    public static void main(String [] args)
    {
        int array_size = 1048576;
        int [] array = new int[array_size];

        long start_time, end_time, elapsed_time, elapsed_time_insertion, elapsed_time_merge;

        Random rand = new Random();
        rand.setSeed(System.currentTimeMillis());

        for (int i = 0; i < array_size; i++)
            array[i] = rand.nextInt(100);


        //part 2(b)
        /**
       // print_array(array);
      //  merge_sort(array,0,array_size-1); // until array size -1 to merge it.
       // print_array(array);
         */

        //part 3(a)

        /*
        long startTime = System.nanoTime();
        insertion_sort(array);
        long endTime = System.nanoTime();
        long elapsed = endTime - startTime;
        System.out.println("insertion: "+elapsed);
*/
/*
        long startTime2 = System.nanoTime();
        merge_sort(array,0,array_size-1); // until array size -1 to merge it.
        long endTime2 = System.nanoTime();
        long elapsed2 = endTime2 - startTime2;
        System.out.println("merge: "+elapsed2);
*/

        //part 3(b)
        // to compare them, we use their algorithms.
        for (int i = 0; i<100; i++){
            while(8*Math.pow(i,2)<=64*i*Math.log(i)/Math.log(2)){
                System.out.println(i);
                i++;
            }
        }
    }

    //indices p and r can start from 0
    public static void merge_sort(int [] A, int p, int r)
    {
        if(p<r){
            int middle = p + (r - p) / 2;
            merge_sort(A,p,middle); // sort left sub-array
            merge_sort(A,middle+1,r); // sort right sub-array
            merge(A,p,middle,r); // merge the sorted sub-arrays
        }
    }

    //Part 2(a)
    public static void merge(int [] A, int p, int q, int r)
    {

        // size of sub-arrays
        int size1 = q - p + 1;
        int size2 = r - q;

        // temporary arrays & copy the data
        int left[] = new int[size1];
        int right[] = new int[size2];

        for(int i=0; i<size1; i++){
            left[i] = A[p+i];}
        for(int i=0; i<size1; i++){
            right[i] = A[q+1+i];}

        // merging the arrays
        int first_index = 0, second_index=0;
        int merged_index= p;
        while (first_index<size1&& second_index<size2){
            if(left[first_index]<=right[second_index]){
                A[merged_index] = left[first_index];
                first_index++;
            }
            else {
                A[merged_index] = right[second_index];
                second_index++;
            }
            merged_index++;
        }

        // get the rest of the elements from arrays
        while(first_index<size1){
            A[merged_index] = left[first_index];
            first_index++; merged_index++;
        }
        while (second_index<size2){
            A[merged_index] = right[second_index];
            second_index++; merged_index++;
        }
    }

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
}

