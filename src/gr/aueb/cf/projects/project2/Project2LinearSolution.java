package gr.aueb.cf.projects.project2;

public class Project2LinearSolution {

    public static void main(String[] args) {
        int[] array = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(getMaxSumFromSubarray(array));
       // System.out.println(getMaxSumFromSubarrayOptimized(array));
    }

    public static int getMaxSumFromSubarray(int[] array) {
        int[] maxSums = new int[array.length];
        maxSums[0] = array[0];
        int max = maxSums[0];
        for (int i = 1; i < array.length; i++) {
            maxSums[i] = Math.max(array[i], maxSums[i - 1] + array[i]);
            if (maxSums[i] > max) {
                max = maxSums[i];
            }
        }
        return max;
    }


    // Version b. Without an extra array

    public static int getMaxSumFromSubarrayOptimized(int[] array) {
        int maxSumPrevious = 0;
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            int maxSumsCurrent = Math.max(array[i], maxSumPrevious + array[i]);
            maxSumPrevious = maxSumsCurrent;
            if (maxSumsCurrent > max) {
                max = maxSumsCurrent;
            }
        }
        return max;
    }

}
