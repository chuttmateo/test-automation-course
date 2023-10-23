import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //1. Create a simple system.out app.
        // Print info about the user that should be passed to the main function as a parameter.
        // Compile and run the program from the command line using javac and java from JDK.

        for (String arg: args) {
            System.out.println(arg);
        }

        //2. Sorting algorithm implementation.
        // Choose any from the list: Insertion sort, Selection sort, bubble sort, Merge sort, Quicksort.

        int[] nums = {1,4,2,3,5,9,8,6,7};
        for (int n : nums){
            System.out.println(n);
        }

       System.out.println("Bubble sort");

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - 1; j++) {
                if ( nums[j] > nums[j + 1]){
                    int aux = nums[j];
                    nums[j] = nums[j+1];
                    nums[j + 1] = aux;
                }
            }
        }

        Arrays.stream(nums).forEach(System.out::println);
    }
}