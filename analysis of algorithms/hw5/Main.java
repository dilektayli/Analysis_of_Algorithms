public class Main {
    public static void main(String[] args) {
        int [] array = new int[] {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
        int [] answer = find_max_sub_array_linear(0,array.length,array); // call the function
            System.out.print("The sum of max array is:" +answer[2]); // print the largest sum
    }
    public static int[] find_max_sub_array_linear(int low, int high,int [] A){
        int best = Integer.MIN_VALUE;
        int current = 0, left=0, right = 0, current_left=0;
        for(int i = low; i<high; i++){
            current += A[i];
            // compare current sum and best
            if(current>best){
                // change the values to find the next sum
                // update sum
                best = current;
                left = current_left;
                right = i;
            }
            if(current<0){
                // make sum to 0
                current = 0;
                current_left = i+1;
            }
        }
        return new int[] {left, right,best}; // return all the current sum but the sum of max sub-array is stored in the 2nd index.
    }
}