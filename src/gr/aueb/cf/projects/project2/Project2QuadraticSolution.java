package gr.aueb.cf.projects.project2;


public class Project2QuadraticSolution {

    public static void main(String[] args) {
        int[] array = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int maxSum = getMaxSumFromSubarray(array);
        System.out.println(maxSum);
    }

    public static int getMaxSumFromSubarray(int[] array) {
        int sum = 0;
        int max = array[0];

        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                sum = sum + array[j];
                if (sum > max) {
                    max = sum;
                }
            }
            sum = 0;
        }

        return max;
    }
}
