import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class linear_2
{
	public static void main(String [] args)
	{
		int array_size = 10;
		float [] A = new float[array_size];
		long start_time, end_time, elapsed_time, elapsed_time_insertion, elapsed_time_merge;

		//an array of linked lists
		SinglyLinkedList <Float>[] B = new SinglyLinkedList[array_size];

		for (int i = 0; i < A.length; i++)
			B[i] = new SinglyLinkedList<>(); //each element of B array is a linked list object

		/*
		Float value = new Float(1.0);
		Float value_2 = new Float(2.0);
		Float value_3 = new Float(3.0);

		B[0].addFirst(value);
		B[0].addFirst(value_2);
		B[0].addFirst(value_3);
		B[0].insertion_sort();

		System.out.printf("%s\n", B[0]);

		 */

		Random rand = new Random();
		rand.setSeed(System.currentTimeMillis());

		for (int i = 0; i < array_size; i++)
			A[i] = rand.nextFloat();

		//part b
		System.out.println("------------------- part b -------------------");
		System.out.println("Before sorting");
		print_float_array(A);
		bucket_sort(A,A.length);
		System.out.println("After sorting");
		print_float_array(A);


		//part c
		/*
		System.out.println("------------------- part c -------------------");
		for(int i = 10; i<=100000000; i= i*10){
			//initialize arrays
			float [] merge = new float[i];
			float [] heap = new float[i];
			float [] bucket = new float[i];

			start_time = System.nanoTime();
			bucket_sort(bucket,bucket.length);
			end_time = System.nanoTime();
			elapsed_time = end_time - start_time;
			System.out.println("Input Size: "+i+ " Elapsed time in nanoseconds for bucket sort: " +elapsed_time);

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

		// part d
		System.out.println("----------- Part d -----------");
		int size = 10000000;
		float [] bucket_d = new float[size];
		float [] merge = new float[size];
		float [] heap = new float[size];

		for(int i = 0; i<size; i++){
			bucket_d[i] = rand.nextFloat();
			heap[i] = bucket_d[i];
			merge[i] = bucket_d[i];
		}
		// run them one by one

		//bucket_sort(bucket_d,size);
		//merge_sort(merge,0,size-1);
		//heap_sort(heap);

	}

	//Implement bucket sort algorithm below
	public static void bucket_sort(float [] array,int length)
	{
		if (length <= 0)return;
		ArrayList<Float>[] bucket = new ArrayList[length];

		for (int i = 0; i < length; i++) // empty buckets
			bucket[i] = new ArrayList<Float>();

		for (int i = 0; i < length; i++) { // add the elements
			int bucket_index = (int) array[i] * length;
			bucket[bucket_index].add(array[i]);
		}

		for (int i = 0; i < length; i++)// sort them using collections instead of using insertion sort
			Collections.sort((bucket[i]));

		// sorted array
		int index = 0;
		for (int i = 0; i < length; i++)
			for (int j = 0, size = bucket[i].size(); j < size; j++)
				array[index++] = bucket[i].get(j);
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

        //assumes that index i starts from 1
	public static void max_heapify(float [] A, int array_size, int i)
	{
		int left_index, right_index, index_of_largest;
		float temp;

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

	public static void build_max_heap(float [] A)
	{
		int middle_index = (int)Math.floor(A.length/2);
		int array_size = A.length;

		for (int i = middle_index; i >= 1; i--)
			max_heapify(A, array_size, i);
	}

	public static void heap_sort(float [] A)
	{
		float temp;
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
	public static void merge_sort(float [] A, int p, int r)
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

	public static void merge(float [] A, int p, int q, int r)
	{
		int n1, n2;
		int i, j;

		n1 = q-p+1;
		n2 = r-q;

		float [] L = new float[n1];
		float [] R = new float[n2];

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
        public static void print_float_array(float [] A)
        {       
                System.out.printf("[");
                for (int i = 0; i < A.length-1; i++)
                {       
                        System.out.printf("%f, ", A[i]);
                }
                
                System.out.printf("%f]\n", A[A.length-1]);
        
        }

  private static class Node<E> {

    /** The element stored at this node */
    private E element;            // reference to the element stored at this node

    /** A reference to the subsequent node in the list */
    private Node<E> next;         // reference to the subsequent node in the list

    /**
     * Creates a node with the given element and next node.
     *
     * @param e  the element to be stored
     * @param n  reference to a node that should follow the new node
     */
    public Node(E e, Node<E> n) {
      element = e;
      next = n;
    }

    // Accessor methods
    /**
     * Returns the element stored at the node.
     * @return the element stored at the node
     */
    public E getElement() { return element; }

    public void setElement(E e) { element = e; }

    /**
     * Returns the node that follows this one (or null if no such node).
     * @return the following node
     */
    public Node<E> getNext() { return next; }

    // Modifier methods
    /**
     * Sets the node's next reference to point to Node n.
     * @param n    the node that should follow this one
     */
    public void setNext(Node<E> n) { next = n; }
  } //----------- end of nested Node class -----------

}

