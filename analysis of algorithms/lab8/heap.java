import java.util.Arrays;
import java.util.Random;

public class heap
{
	static int heap_size;
	public static void main(String [] args)
	{

		int array_size = 10;
		int [] array = new int[array_size];
		long start_time, end_time, elapsed_time, elapsed_time_insertion, elapsed_time_merge;

		Random rand = new Random();
		rand.setSeed(System.currentTimeMillis());


		for (int i = 0; i < array_size; i++)
			array[i] = rand.nextInt(100);


		// part b
		System.out.println(" -------- Part b --------");
		print_array(array); // random array before sort
		heap_sort(array); // call heap sort
		print_array(array); // sorted array



		// part c
		System.out.println(" -------- Part c --------");

		for(int i =4; i<=67108864; i = i*4){
			System.out.println("\nSize "+i);

			int array1[] = new int[i];
			int array2[] = new int[i];
			for (int k=0; k<i;k++){
				array1[k] = rand.nextInt(100);
				array2[k] = array1[k]; // same array
			}

			// heap sort for array1
			start_time = System.nanoTime();
			heap_sort(array1);
			end_time = System.nanoTime();
			elapsed_time = end_time - start_time;
			System.out.print("Elapsed time in nanoseconds for heap sort: " + elapsed_time);
			System.out.println();
			// merge sort for array2
			start_time = System.nanoTime();
			merge(array2,0,0,array2.length-1);
			end_time = System.nanoTime();
			elapsed_time = end_time - start_time;
			System.out.print("Elapsed time in nanoseconds for merge sort: "+ elapsed_time);
			System.out.println();
		}



		// part d
		System.out.println(" -------- Part d --------");
		int [] array3 = new int[67108864];
		int [] array4 = new int[67108864];

		for(int i=0;i<67108864;i++){
			array3[i] = rand.nextInt(100);
			array4[i] = rand.nextInt(100);
		}


		// heap sort for array3
		start_time = System.nanoTime();
		heap_sort(array3);
		end_time = System.nanoTime();
		elapsed_time = end_time - start_time;
		//System.out.print("Elapsed time in nanoseconds for heap sort: " + elapsed_time);
		System.out.println();





		// merge sort for array4
		start_time = System.nanoTime();
		merge(array4,0,0,array4.length-1);
		end_time = System.nanoTime();
		elapsed_time = end_time - start_time;
		//System.out.print("Elapsed time in nanoseconds for merge sort: "+ elapsed_time);
		System.out.println();



	}

	//Implement heap sort algorithm below
	public static void heap_sort(int [] A)
	{
		build_max_heap(A);
		for(int i= A.length-1; 0<i; i--){
			int temp_value = A[0];
			A[0] = A[i];
			A[i] = temp_value;
			heap_size = heap_size -1;
			max_heapify(A,0);
		}
	}
	public static int parent(int i){
		return (int) Math.floor(i/2);
	}
	public static int left(int i){
		return i*2;
	}
	public static int right(int i){
		return i*2+1;
	}
	public static void build_max_heap(int [] A){
		heap_size = A.length - 1;
		for(int i= (int) Math.floor(A.length/2); 0<=i; i--)
			max_heapify(A,i);
	}
	public static void max_heapify(int [] A,int i){
		int l = left(i);
		int r = right(i);
		int largest;
		if(l<=heap_size && A[l] >A[i])
			largest = l;
		else largest = i;

		if(r<=heap_size && A[r] >A[largest])
			largest = r;

		if(largest != i){
			int temp_value = A[i];
			A[i] = A[largest];
			A[largest] = temp_value;
			max_heapify(A,largest);
		}
	}

	//indices p and r can start from 0
	public static void merge_sort(int [] A, int p, int r)
	{
		int q;

		if (p < r)
		{
			q = (int)Math.floor((p+r)/2);
			merge_sort(A, p, q);
			merge_sort(A, q+1, r);
			merge(A, p, q, r);
		}
	}

	//Part 2(a)
	public static void merge(int [] A, int p, int q, int r)
	{
		int n1, n2;
		int i, j;

		n1 = q-p+1;
		n2 = r-q;

		int [] L = new int[n1];
		int [] R = new int[n2];

		for (i = 0; i < n1; i++)
			L[i] = A[p+i];

                for (i = 0; i < n2; i++)
                        R[i] = A[q+i+1];

		i = 0;
		j = 0;

		for (int k=p; k <= r; k++)
		{
			if (i >= n1) //the left array finished, copy from right array
			{
				A[k] = R[j];
				j++;
				continue;
			}

			if (j >= n2) //the right array finished, copy from left array
			{
				A[k] = L[i];
				i++;
				continue;
			}

			if (L[i] <= R[j])
			{
				A[k] = L[i];
				i++;
			}
			else
			{
				A[k] = R[j];
				j++;
			}
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

