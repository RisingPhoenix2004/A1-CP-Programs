
import java.util.Scanner;

/*Andy and Berry are serving water to N guests seated in a row. 
The guests are labeled from 0 to N-1, where the i-th guest is seated at position x = i.

Each guest requires a specific amount of water, represented in an array. Andy and Berry have water jars with a limited capacity and serve guests as follows:
-> Andy starts serving from left to right (from guest 0).
-> Berry starts serving from right to left (from guest N-1).
-> They serve simultaneously, meaning each guest gets served at the same time by the respective server.

Rules:
------
-> If Andy or Berry has enough water in their jar, they serve the guest.
-> If a server does not have enough water, they refill their jar (refill is instant).
-> If both Andy and Berry reach the same guest, the one with more water serves them. If they have equal amounts, Andy serves.
-> The goal is to find the minimum number of refills required for both Andy and Berry to serve all guests.

Input Format:
-------------
Line 1: An integer N, the number of guests.
Line 2: N space-separated integers, where each integer represents the amount of water required by each guest.
Line 3: An integer capacityA, the initial water capacity of Andy's jar.
Line 4: An integer capacityB, the initial water capacity of Berry's jar.

Output Format:
--------------
Line-1: Print a single integer, representing the minimum number of refills required.

Sample Input-1:
---------------
4
2 2 3 3
5
5

Sample Output-1:
----------------
1

Explanation:
------------
Andy starts from the left and Berry starts from the right.
Andy serves guest 0 (2 units) and Berry serves guest 3 (3 units).
Remaining water: Andy = 3, Berry = 2.
Andy serves guest 1 (2 units). Now Andy = 1.
Berry cannot serve guest 2 (3 units), so he refills → Total refills = 1.
Berry serves guest 2. No more refills needed.
Total refills = 1.

Sample Input-2:
---------------
4
2 2 3 3
3
4

Sample Output-2:
----------------
2

Explanation:
------------
Andy (3 units) serves guest 0 (2 units), Berry (4 units) serves guest 3 (3 units).
Remaining: Andy = 1, Berry = 1.
Both Andy and Berry cannot serve their next guests, so both refill.
Total refills = 2.


 */
class MinNoOfRefill{
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int low = 0, high = plants.length - 1;
        int refills = 0;
        int currA = capacityA, currB = capacityB;

        while (low < high) {
            if (plants[low] > currA) {
                refills++;
                currA = capacityA;
            }
            currA -= plants[low];
            low++;

            if (plants[high] > currB) {
                refills++;
                currB = capacityB;
            }
            currB -= plants[high];
            high--;
        }

        if (low == high) {
            if (plants[low] > Math.max(currA, currB)) {
                refills++;
            }
        }

        return refills;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
    }
}