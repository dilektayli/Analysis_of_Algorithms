import java.util.Arrays;
import java.util.Random;

public class permute
{
	public static void main(String [] args)
	{
		int array_size = 4;
		int array_size_a = 10;
		int array_size_b = 10;
		int [] array = new int[array_size];
		int [] array_a = new int[array_size_a];
		int [] array_b = new int[array_size_b];
		int [] frequency_array = new int[24];
		int [] frequency_array_b = new int[24];
		int permutation_index = 0;

		Random rand = new Random();

		for (int i = 0; i < array_size; i++)
			array[i] = rand.nextInt(100);

		for (int i = 0; i < array_size_a; i++)
			array_a[i] = rand.nextInt(100);

		for (int i = 0; i < array_size_b; i++)
			array_b[i] = rand.nextInt(100);

		// part 1.b
		System.out.println("-------------part 1.b-------------");
		System.out.println("Original array");
		print_array(array_a);
		for (int i= 0; i<5; i++){
			System.out.println("permutation "+(i+1)+":");
			randomize_in_place(array_a);
			print_array(array_a);
		}

		// part 2.b
		System.out.println();
		System.out.println("-------------part 2.b-------------");
		System.out.println("Original array");
		print_array(array_b);
		for (int i= 0; i<5; i++){
			System.out.println("permutation "+(i+1)+":");
			permute_with_all(array_b);
			print_array(array_b);
		}

		array[0] = 4;
		array[1] = 3;
		array[2] = 2;
		array[3] = 1;

		// part 3.a
		System.out.println();
		System.out.println("-------------part 3.a-------------");
		for(int i=0;i<24000; i++){
			randomize_in_place(array);
			permutation_index = compute_permutation_index(array);
			frequency_array[permutation_index] = frequency_array[permutation_index] + 1;
		}
		array_printing(frequency_array);

		// part 3.b
		System.out.println();
		System.out.println("-------------part 3.b-------------");
		for(int i=0;i<24000; i++){
			permute_with_all(array);
			permutation_index = compute_permutation_index(array);
			frequency_array_b[permutation_index] = frequency_array_b[permutation_index] + 1;
		}
		array_printing(frequency_array_b);
	}

	//Implement randomize in place algorithm below
	public static void randomize_in_place(int [] A)
	{
		Random random = new Random();
		int n = A.length;
		for(int i=0; i<n;i++){
			int temp_value = A[i];
			int random_value = random.nextInt(n-i)+i;
			A[i] = A[random_value];
			A[random_value] = temp_value;
		}
	}

	//Implement permute with all algorithm below
	public static void permute_with_all(int [] A)
	{
			Random random = new Random();
			int n = A.length;
			for(int i = 0; i<n;i++){
				int temp_value = A[i];
				int random_value = random.nextInt(n);
				A[i] = A[random_value];
				A[random_value] = temp_value;
			}
        }

	public static int compute_permutation_index(int [] A)
	{
		int permutation_index = 0;
		int next_number = 0;
		int index_next_number = 0;

		for (int starting_index = 0; starting_index < A.length-1; starting_index++)
		{	
			int [] remaining_numbers = new int [A.length-starting_index];
                        int [] remaining_numbers_sorted = new int [A.length-starting_index];

			for (int i = 0; i < remaining_numbers.length; i++)
			{
				remaining_numbers[i] = A[starting_index+i];
				remaining_numbers_sorted[i] = remaining_numbers[i];
			}

			insertion_sort(remaining_numbers_sorted);

			next_number = A[starting_index];

			for (int i = 0; i < remaining_numbers_sorted.length; i++)
			{
				if (remaining_numbers_sorted[i] == next_number)
				{
					index_next_number = i;
					break;
				}
			}

			permutation_index += index_next_number*factorial(remaining_numbers.length-1);	
		}	

		return permutation_index;
		
	}

	public static int factorial(int x)
	{	
		int product = 1;

		for (int i = x; i >= 1; i--)
			product *= i;

		return product;
	}

	public static void insertion_sort(int [] A)
	{
                int key;
                int i;

                for (int j = 1; j < A.length; j++)
                {
                        key = A[j];

                        //insert A[j] into the sorted sequence A[1..j-1]
                        i = j-1;

                        while ((i >= 0) && (A[i] > key))
                        {
                                A[i+1] = A[i];
                                i = i-1;
                        }

                        A[i+1] = key;
                }
        }


	// printing array with their indices.
	public static void array_printing(int [] A)
	{
			System.out.print("[");
			int i = 0;
			int n = A.length;
			for(i= 0; i<n-1; i++)
				System.out.print(i+"->"+ A[i]+", ");
			System.out.println(i+ " -> "+A[n-1]);
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

