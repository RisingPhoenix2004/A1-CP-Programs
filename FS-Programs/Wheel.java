import java.util.*;
class Wheel {
    public static int minRotationsToMaximizeProfit(int[] arr, int boardingCost, int runningCost) {
        int maxProfit = 0, currentProfit = 0, rotations = 0, maxRotations = -1;
        int waitingCustomers = 0, i = 0;
        while (waitingCustomers > 0 || i < arr.length) {
            if (i < arr.length) {
                waitingCustomers += arr[i]; 
            }
            i++;
            int boarding = Math.min(4, waitingCustomers); 
            waitingCustomers -= boarding;
            rotations++;
            currentProfit += (boarding * boardingCost) - runningCost;
            if (currentProfit > maxProfit) {
                maxProfit = currentProfit;
                maxRotations = rotations;
            }
        }
        return maxProfit > 0 ? maxRotations : -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int boardingCost = sc.nextInt();
        int runningCost = sc.nextInt();
        System.out.println(minRotationsToMaximizeProfit(arr, boardingCost, runningCost));
    }
}
