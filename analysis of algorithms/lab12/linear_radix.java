import java.util.Arrays;
import java.util.Random;

public class linear_radix
{
	public static void main(String [] args)
	{
		int array_size = 10;
		int [] array = new int[array_size];
		long start_time, end_time, elapsed_time, elapsed_time_insertion, elapsed_time_merge;

		Random rand = new Random();
		rand.setSeed(System.currentTimeMillis());

		for (int i = 0; i < array_size; i++)
			array[i] = rand.nextInt(999)+100;

		System.out.println("-----------part b -----------");
		print_array(array);
		radix_sort(array,array_size);
		print_array(array);

		//part c
		/*
		System.out.println("-----------part c -----------");
		for(int i = 10; i<=100000000; i= i*10){
			//initialize arrays
			int [] radix_array = new int[i];
			int [] count_A = new int[i];
			int [] count_B = new int[i];
			int [] merge = new int[i];
			int [] heap = new int[i];

			for(int k = 0 ; k<i ; k++){
				// set values of the arrays.
				count_A[k] = rand.nextInt(i);
				heap[k] = count_A[k];
				merge[k] = count_A[k];
			}


			start_time = System.nanoTime();
			radix_sort(radix_array,i);
			counting_sort(count_A,count_B,i);
			end_time = System.nanoTime();
			elapsed_time = end_time - start_time;
			System.out.println("Input Size: "+i+ " Elapsed time in nanoseconds for radix sort: " +elapsed_time);


			start_time = System.nanoTime();
			counting_sort(count_A,count_B,i);
			end_time = System.nanoTime();
			elapsed_time = end_time - start_time;
			System.out.println("Input Size: "+i+ " Elapsed time in nanoseconds for counting sort: " +elapsed_time);

			start_time = System.nanoTime();
			merge_sort(merge,0,i-1);
			end_time = System.nanoTime();
			elapsed_time = end_time - start_time;
			System.out.println("Input Size: "+i+ " Elapsed time in nanoseconds for merge sort: " +elapsed_time);

			start_time = System.nanoTime();
			heap_sort(heap);
			end_time = System.nanoTime();
			elapsed_time = end_time - start_time;
			System.out.println("Input Size: "+i+ " Elapsed time in nanoseconds for heap sort: " +elapsed_time);

			System.out.println("-----------------------------");
		}
		 */

		// run them one by one. 
		//part d
		/*
		System.out.println("----------- Part d -----------");
		int range = 10;
		int i= 100000;
		//for(int i= 10; i<=100000; i= i*10){
			//initialize arrays
			int [] radix_array = new int[i];
			int [] count_A = new int[i];
			int [] count_B = new int[i];
			int [] merge = new int[i];
			int [] heap = new int[i];

			for(int k = 0 ; k<i ; k++){
				// set values of the arrays.
				count_A[k] = rand.nextInt(range);
				heap[k] = count_A[k];
				merge[k] = count_A[k];
			}
/*
			start_time = System.nanoTime();
			radix_sort(radix_array,i);
			counting_sort(count_A,count_B,i);
			end_time = System.nanoTime();
			elapsed_time = end_time - start_time;
			System.out.println("Input Size: "+i+ " Elapsed time in nanoseconds for radix sort: " +elapsed_time);



 */
/*
			start_time = System.nanoTime();
			counting_sort(count_A,count_B,range);
			end_time = System.nanoTime();
			elapsed_time = end_time - start_time;
			System.out.println("Input Size: "+i+ " Elapsed time in nanoseconds for counting sort: " +elapsed_time);


 */

/*
			start_time = System.nanoTime();
			merge_sort(merge,0,i-1);
			end_time = System.nanoTime();
			elapsed_time = end_time - start_time;
			System.out.println("Input Size: "+i+ " Elapsed time in nanoseconds for merge sort: " +elapsed_time);


 */

/*
			start_time = System.nanoTime();
			heap_sort(heap);
			end_time = System.nanoTime();
			elapsed_time = end_time - start_time;
			System.out.println("Input Size: "+i+ " Elapsed time in nanoseconds for heap sort: " +elapsed_time);


 */
			System.out.println("-----------------------------");
		//}


	}

	//Implement radix sort algorithm below
	public static void radix_sort(int [] A,  int d) {
		int max = getMax(A, d); // find the max
		for (int i = 1; max / i > 0; i *= 10) // call counting sort
			countingSort(A, d, i);
	}

	static int getMax(int [] A, int d) {
		int max = A[0];
		for (int i = 1; i < d; i++){
			if (A[i] > max){
				max = A[i]; // update the max value
			}
		}
		return max;
	}
	
	//assumes that index i starts from 1
	public static int parent(int i)
	{
		return (int)Math.floor(i/2);
	}

        //assumes that index i starts from 1
	public static int left(int i)
	{
		return 2*i;
	}

        //assumes that index i starts from 1
	public static int right(int i)
	{
		return (2*i+1);
	}
	static void countingSort(int array[], int array_size, int k) {
		int [] output_array = new int[array_size + 1];
		int max = array[0];
		for (int i = 1; i < array_size; i++) {
			if (array[i] > max){
				max = array[i];
			}
		}
		int [] count = new int[max + 1];

		for (int i = 0; i < max; ++i){
			count[i] = 0;
		}

		for (int i = 0; i < array_size; i++){
			count[(array[i] / k) % 10]++;
		}

		for (int i = 1; i < 10; i++){
			count[i] += count[i - 1];
		}

		for (int i = array_size - 1; i >= 0; i--) { // put in order
			output_array[count[(array[i] / k) % 10] - 1] = array[i];
			count[(array[i] / k) % 10]--;
		}

		for (int i = 0; i < array_size; i++){
			array[i] = output_array[i];
		}
	}


	public static void counting_sort(int [] A, int [] B, int k)
	{
		int [] C = new int[k];

		for(int i = 0 ; i<k; i++){
			C[i] = 0;
		}

		for(int j = 0; j<A.length; j++){
			C[A[j]] = C[A[j]] +1;
		}

		for(int i = 1; i<k; i++){
			C[i] = C[i] + C[i-1];
		}

		for(int j=A.length-1; -1<j; j--){
			B[C[A[j]]-1] = A[j];
			C[A[j]] = C[A[j]]-1;
		}
	}
    //assumes that index i starts from 1
	public static void max_heapify(int [] A, int array_size, int i)
	{
		int left_index, right_index, index_of_largest;
		int temp;

		left_index = left(i);
                right_index = right(i);

		if ((left_index <= array_size) && (A[left_index-1] > A[i-1]))
			index_of_largest = left_index;
		else
			index_of_largest = i;

		if ((right_index <= array_size) && (A[right_index-1] > A[index_of_largest-1]))
			index_of_largest = right_index;

		if (index_of_largest != i)
		{
			temp = A[i-1];
			A[i-1] = A[index_of_largest-1];
			A[index_of_largest-1] = temp;
			max_heapify(A, array_size, index_of_largest);
		}
	}

	public static void build_max_heap(int [] A)
	{
		int middle_index = (int)Math.floor(A.length/2);
		int array_size = A.length;

		for (int i = middle_index; i >= 1; i--)
			max_heapify(A, array_size, i);
	}

	public static void heap_sort(int [] A)
	{
		int temp;
		int array_size = A.length;
		build_max_heap(A);
		
		for (int i = A.length; i >= 2; i--)
		{
			temp = A[0];
			A[0] = A[i-1];
			A[i-1] = temp;
			array_size--;
			max_heapify(A, array_size, 1);
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

