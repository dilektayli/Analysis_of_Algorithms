import java.util.Random;

public class max_subarray {
	public static void main(String[] args) {
		int array_size = 65536;
		int[] A = new int[array_size];
		int[] test_A = new int[5];
		int[] diff_test_A = new int[4];
		int[] diff_A = new int[array_size - 1];
		int[] outputs = new int[3];
		int best_left_index = 0;
		int best_right_index = 0;
		int max_difference = 0;

		long start_time, end_time, elapsed_time;
		long elapsed_time_brute_force, elapsed_time_divide_and_conquer;

		Random rand = new Random();
		rand.setSeed(System.currentTimeMillis());


		//part 1(b)
		test_A[0] = 10;
		test_A[1] = 11;
		test_A[2] = 7;
		test_A[3] = 10;
		test_A[4] = 6;
		/** brute_force(test_A); */

		//initialize elements of array with random integers and compute difference array
		for (int i = 0; i < A.length; i++) {
			A[i] = rand.nextInt(100);
			if (i > 0)
				diff_A[i - 1] = A[i] - A[i - 1];
		}

		/**
		 // print array  for testing
		 for (int i = 0; i < A.length; i++)
		 {
		 System.out.print(A[i]+" ");
		 }
		 */

/**
		//part 1(c) compute the elapsed time for brute-force algorithm
		start_time = System.nanoTime();
		brute_force(A);
		end_time = System.nanoTime();
		elapsed_time_brute_force = end_time - start_time;
		System.out.println("1.c. elapsed time for this array is: " + elapsed_time_brute_force + " nanoseconds");
*/

		//part 2(b)
		diff_test_A[0] = 1;
		diff_test_A[1] = -4;
		diff_test_A[2] = 3;
		diff_test_A[3] = -4;
		find_maximum_subarray(diff_test_A,0,diff_test_A.length-1,diff_test_A);




		//print the left index, right index and maximum difference (i.e. net profit)

		//part 2(c) compute the elapsed time for divide and conquer algorithm

		//print the left index, right index and maximum difference (i.e. net profit)

		//part 3

		int max_array_size = 1000;
		int[] A_2 = new int[max_array_size];
		int[] diff_A_2 = new int[max_array_size - 1];

		//initialize elements of array with random integers and compute difference array
		for (int i = 0; i < A_2.length; i++) {
			A_2[i] = rand.nextInt(100);
			if (i > 0)
				diff_A_2[i - 1] = A_2[i] - A_2[i - 1];
		}

		for (array_size = 2; array_size <= max_array_size; array_size++) {


		}

	}

	//part 1(a) implementing the brute-force algorithm
	public static void brute_force(int[] A) {
		int max_diff = 0, diff = 0, i = 0, j = 0;

		for (i = 0; i < A.length - 1; i++) { // A.length -1 for not going outside of the array
			for (j = i + 1; j < A.length; j++) {
				if (A[j] > A[i]) {
					diff = Math.abs(A[i] - A[j]);
					max_diff = Integer.max(max_diff, diff);
				}
			}
		}
		i--;
		j--;
		System.out.println("i=> " + i + " j=> " + j);
		System.out.println("Maximum difference: " + max_diff);
		//print the left index, right index and maximum difference (i.e. net profit)
	}

	public static void brute_force_2(int[] A, int array_size) {

		//print the left index, right index and maximum difference (i.e. net profit)

	}

	//part 2(a) implementing the recursive algorithm that uses divide and conquer and finds the maximum subarray
	public static int[] find_maximum_subarray(int[] diff_A, int low, int high, int[] outputs) {
		//print the left index, right index and maximum difference (i.e. net profit)
		if (high == low) {
			outputs[0] = low;
			outputs[1] = high;
			outputs[2] = diff_A[low];
			return outputs;
		} else {
			int mid = (int) Math.floor((low + high) / 2);


			// left subarray
			int left_low = find_maximum_subarray(diff_A, low, mid, outputs)[0];
			int left_high = find_maximum_subarray(diff_A, low, mid, outputs)[1];
			int left_sum = find_maximum_subarray(diff_A, low, mid, outputs)[2];

			//right subarray
			int right_low = find_maximum_subarray(diff_A, mid + 1, high, outputs)[0];
			int right_high = find_maximum_subarray(diff_A, mid + 1, high, outputs)[1];
			int right_sum = find_maximum_subarray(diff_A, mid + 1, high, outputs)[2];

			//cross subarray
			int cross_low=find_max_crossing_subarray(diff_A,low,mid,high,outputs)[0];
			int cross_high=find_max_crossing_subarray(diff_A,low,mid,high,outputs)[1];
			int cross_sum=find_max_crossing_subarray(diff_A,low,mid,high,outputs)[2];

			if(left_sum>=right_sum && left_sum>=cross_sum){
				outputs[0] = left_low;
				outputs[1] = left_high;
				outputs[2] = left_sum;
				System.out.print(outputs);
				return  outputs;
			}
			else if(right_sum>=left_sum && right_sum>=cross_sum){
				outputs[0] = right_low;
				outputs[1] = right_high;
				outputs[2] = right_sum;
				System.out.print(outputs);
				return  outputs;
			}
			else{outputs[0] = cross_low;
				outputs[1] = cross_high;
				outputs[2] = cross_sum;
				System.out.print(outputs);
				return  outputs;
			}


		}
	}

        public static int[] find_max_crossing_subarray(int [] diff_A, int low, int mid, int high, int [] outputs)
	{
		int left_sum = Integer.MIN_VALUE;
		int sum = 0;
		int max_left = 0, max_right = 0, max_cross=0;
		for (int i=mid;i>low;i--){
			sum = sum + diff_A[i];
			if(sum>left_sum){
				left_sum = sum;
				 max_left = i;
			}
		}
		int right_sum = Integer.MIN_VALUE;
		sum = 0;
		for (int j=mid;j>low;j--){
			sum = sum + diff_A[j];
			if(sum>right_sum){
				right_sum = sum;
				 max_right = j;
			}
		}
		outputs[0] = max_left;
		outputs[1] = max_right;
		outputs[2] = max_cross;
		return outputs;


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

