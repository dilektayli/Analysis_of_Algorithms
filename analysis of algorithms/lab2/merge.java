import java.util.Arrays;
import java.util.Random;

public class merge
{
	public static void main(String [] args)
	{
		int array_size = 16;
		int [] array = new int[array_size];
		long start_time, end_time, elapsed_time, elapsed_time_insertion, elapsed_time_merge;

		Random rand = new Random();
		rand.setSeed(System.currentTimeMillis());

		for (int i = 0; i < array_size; i++)
			array[i] = rand.nextInt(100);
	
		//part 2(b) 

		//part 3(a)	

		//part 3(b)

	}

	//indices p and r can start from 0
	public static void merge_sort(int [] A, int p, int r)
	{

	}

	//Part 2(a)
	public static void merge(int [] A, int p, int q, int r)
	{

	}	

        public static void insertion_sort(int [] A)
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

