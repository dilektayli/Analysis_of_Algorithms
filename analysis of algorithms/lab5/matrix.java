import java.util.Random;

public class matrix
{
	public static void main(String [] args)
	{
		int size = 2;
		int size_2 = 16;
                int size_3 = 64;

		int [][] A = new int[size][size];
                int [][] B = new int[size][size];
                int [][] C = new int[size][size];
	
                int [][] A_2 = new int[size_2][size_2];
                int [][] B_2 = new int[size_2][size_2];
                int [][] C_2 = new int[size_2][size_2];

                int [][] A_3 = new int[size_3][size_3];
                int [][] B_3 = new int[size_3][size_3];
                int [][] C_3 = new int[size_3][size_3];

                long start_time, end_time, elapsed_time;

		Random rand = new Random();
		rand.setSeed(System.currentTimeMillis());

		//part 1(b)
		A[0][0] = 1;
                A[0][1] = 3;
                A[1][0] = 7;
                A[1][1] = 5;
                B[0][0] = 6;
                B[0][1] = 8;
                B[1][0] = 4;
                B[1][1] = 2;

		square_matrix_multiply(A, B, C);
        System.out.println("the beginning of the part 1: ");
		print_2d_array(A);
        print_2d_array(B);
        System.out.println("the result: ");
        print_2d_array(C);
        System.out.println("the end of the part 1");


		
		//part 1(c)
		//initialize elements of matrices with random integers 
		initialize_2d_array_random(A_2);
        initialize_2d_array_random(B_2);

		//compute the elapsed time
        start_time = System.nanoTime();
        square_matrix_multiply(A_2,B_2,C_2);
        end_time = System.nanoTime();
        elapsed_time = end_time - start_time;
        System.out.println("the elapsed time for part 1.c. : " +elapsed_time + " nanoseconds.");



		//part 1(d)
                //initialize elements of matrices with random integers
                initialize_2d_array_random(A_3);
                initialize_2d_array_random(B_3);
                initialize_2d_array(C_3);

                //compute the elapsed time
        start_time = System.nanoTime();
        square_matrix_multiply(A_3,B_3,C_3);
        end_time = System.nanoTime();
        elapsed_time = end_time - start_time;
        System.out.println("the elapsed time for part 1.d. : "+elapsed_time + " nanoseconds.");

		
		//part 2(b)

		//set elements of C to zero first
        initialize_2d_array(C);
        C = square_matrix_multiply_recursive(A,B,0,0,0,0,A.length);
        System.out.println("the beginning of the part 2: ");
        print_2d_array(A);
                print_2d_array(B);
        System.out.println("the result: ");
        print_2d_array(C);
        System.out.println("the end of the part 2");



        //part 2(c)

                //set elements of C_2 to zero first
                initialize_2d_array(C_2);

                //compute the elapsed time
        start_time = System.nanoTime();
        square_matrix_multiply_recursive(A_2,B_2,0,0,0,0,size_2);
        end_time = System.nanoTime();
        elapsed_time = end_time - start_time;
        System.out.println("the elapsed time for part 2.c. : "+elapsed_time + " nanoseconds.");

                //second version of recursive algorithm implementation that uses less variable assignmens for divide step
                //set elements of C_2 to zero first
                initialize_2d_array(C_2);

                //compute the elapsed time
        start_time = System.nanoTime();
        square_matrix_multiply_recursive(A_3,B_3,0,0,0,0,size_3);
        end_time = System.nanoTime();
        elapsed_time = end_time - start_time;
        System.out.println("the elapsed time for part 2.d. : "+elapsed_time + " nanoseconds.");

                //part 2(d)

                //set elements of C_3 to zero first
                initialize_2d_array(C_3);

                //compute the elapsed time

		//second version of recursive algorithm implementation that uses less variable assignmens for divide step
                //set elements of C_3 to zero first
                initialize_2d_array(C_3);

                //compute the elapsed time
	}

	//part 1(a) implementing the square matrix multiply algorithm
	public static int[][] square_matrix_multiply(int [][] A, int [][] B, int [][] C)
	{
        // here we will be iterating in the matrices to calculate the multiplication of them.
        int n = A.length;
        for(int i=0; i<n;i++){
            for(int j=0;j<n;j++){
                C[i][j] = 0;
                for(int k=0;k<n;k++){
                    C[i][j] = C[i][j] + A[i][k] * B[k][j];
                }
            }
        }
        // to return result matrix I changed the type of the method from void to int[][]
        return C;
	}

    /** Firstly, I tried to solve the question with given template however I got too confused with given parameters that's why I used different approach.*/
    //part 2(a)
    public static int[][] square_matrix_multiply_recursive(int[][] A, int[][] B, int row_A, int col_A, int row_B, int col_B,int size) {
        int[][] C = new int[size][size];  // define the result matrix
        if (size == 1) { // matrix has only one element
            C[0][0] = A[row_A][col_A] * B[row_B][col_B];
        } else {
            // here we have 8 different parts of matrices, we divided them and combine them again with add_matrices method.
            // after adding them, we assign them to the result matrix.
            int newSize = size / 2;
            // C11 = A11 * B11 + A12 * B21  => recursive call here to find the first quarter of the result matrix
            sum(C, square_matrix_multiply_recursive(A, B, row_A, col_A, row_B, col_B, newSize),//A11*B11
                    square_matrix_multiply_recursive(A, B, row_A, col_A + newSize, row_B + newSize, col_B, newSize), //A12*B21
                    0, 0);//C11

            // C12 = A11 * B12 + A12 * B22=> recursive call here to find the second quarter of the result matrix
            sum(C, square_matrix_multiply_recursive(A, B, row_A, col_A, row_B, col_B + newSize, newSize),//A11*B12
                    square_matrix_multiply_recursive(A, B, row_A, col_A + newSize, row_B + newSize, col_B + newSize, newSize),//A12*B22
                    0, newSize);//C12

            // C21 = A21 * B11 + A22 * B21 => recursive call here to find the third quarter of the result matrix
            sum(C, square_matrix_multiply_recursive(A, B, row_A + newSize, col_A, row_B, col_B, newSize),//A21*B11
                    square_matrix_multiply_recursive(A, B, row_A + newSize, col_A + newSize, row_B + newSize, col_B, newSize),//A22*B21
                    newSize, 0);//C21

            // C22 = A21 * B12 + A22 * B22 => recursive call here to find the fourth quarter of the result matrix
            sum(C, square_matrix_multiply_recursive(A, B, row_A + newSize, col_A, row_B, col_B + newSize, newSize),//A21*B12
                    square_matrix_multiply_recursive(A, B, row_A + newSize, col_A + newSize, row_B + newSize, col_B + newSize, newSize), //A22*B22
                    newSize, newSize);//C22
        }
        return C; // return the result matrix with int[][] method
    }
    private static void sum(int[][] C, int[][] A, int[][] B, int rowC, int colC) {
        int n = A.length;
        for (int i = 0; i < n; i++) {// iterate for size of the square matrix
            for (int j = 0; j < n; j++) { // here we make the summations when the method is called. It is just summations.
                C[i + rowC][j + colC] = A[i][j] + B[i][j];
            }
        }

    }


    public static void square_matrix_multiply_recursive_2(int [][] A, int [][] B, int A_row_index_start, int A_row_index_end, int A_col_index_start, int A_col_index_end, int B_row_index_start, int B_row_index_end, int B_col_index_start, int B_col_index_end, int C_row_index_start, int C_row_index_end, int C_col_index_start, int C_col_index_end, int [][] C)
    {
        int A_row_index_mid, A_col_index_mid, B_row_index_mid, B_col_index_mid;

        A_row_index_mid = (A_row_index_end+A_row_index_start)/2;
        A_col_index_mid = (A_col_index_end+A_col_index_start)/2;
        B_row_index_mid = (B_row_index_end+B_row_index_start)/2;
        B_col_index_mid = (B_col_index_end+B_col_index_start)/2;

        if (A_row_index_end-A_row_index_start+1 == 1){

        }
		else
        {
            //implement the recursive part here
            //Recursive call 1 for C11

            //Recursive call 2 for C11

            //Recursive call 1 for C12

            //Recursive call 2 for C12

            //Recursive call 1 for C21

            //Recursive call 2 for C21

            //Recursive call 1 for C22

            //Recursive call 2 for C22

        }
    }


	//prints the elements of the array A on the screen
	public static void print_2d_array(int [][] A)
	{
		//System.out.printf("[");
		for (int i = 0; i < A.length; i++)
		{
			for (int j = 0; j < A[0].length; j++)
				System.out.printf("%d ", A[i][j]);
			System.out.printf("\n");
		}
		
		//System.out.printf("%d]\n", A[A.length-1]);

	}

	public static void initialize_2d_array_random(int [][] A)
	{
                Random rand = new Random();
                rand.setSeed(System.currentTimeMillis());

                for (int i = 0; i < A.length; i++)
                {
                        for (int j = 0; j < A[0].length; j++)
                                A[i][j] = rand.nextInt(100);
                }
	}

        public static void initialize_2d_array(int [][] A)
        {
                Random rand = new Random();
                rand.setSeed(System.currentTimeMillis());

                for (int i = 0; i < A.length; i++)
                {
                        for (int j = 0; j < A[0].length; j++)
                                A[i][j] = 0;
                }
        }
}

