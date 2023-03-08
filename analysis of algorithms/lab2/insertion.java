import java.util.Arrays;
import java.util.Random;

public class insertion
{
	public static void main(String [] args)
	{
		int array_size = 1000;
		long start_time, end_time, elapsed_time;

		int array [] = new int[array_size];

		Random rand = new Random();
		rand.setSeed(System.currentTimeMillis());

		//initialize elements of array with random integers
		for (int i = 0; i < array.length; i++)
			array[i] = rand.nextInt(100);

		//part 1(c)

		//part 1(d) 

		//part 1(e)
	}

        //part 1(a) implementing insertion sort algorithm as a method below
        public static void insertion_sort(int [] A)
        {

        }

        //part 1(b) implementing insertion sort algorithm that sorts in descending order as a method below
        public static void insertion_sort_reverse(int [] A)
        {
 
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

