/*You are given an array people, where each element people[i] represents the weight of the i-th person. 
You also have an unlimited number of boats, but each boat has a maximum weight capacity defined by limit.

Each boat can carry at most two people at the same time, as long as their combined weight does not exceed the limit.

Your task is to determine the minimum number of boats required to transport all the given people across safely.

Input Format:
-------------
Line 1: An integer N, representing the number of people.
Line 2: N space-separated integers, representing the weight of each person.
Line 3: An integer limit, representing the maximum weight capacity of a boat.

Output Format:
--------------
Print a single integer, the minimum number of boats needed.

Sample Input-1:
---------------
2
1 2
3

Sample Output-1:
----------------
1

Explanation: Only 1 boat is needed, as both people (weights 1 and 2) fit within the limit of 3.

Sample Input-2:
---------------
4
3 2 2 1
3

Sample Output-2:
----------------
3

Explanation:
------------
Boat 1: (1,2)
Boat 2: (2)
Boat 3: (3)
Total boats required: 3.

Sample Input-3:
---------------
4
3 5 3 4
5

Sample Output-3:
----------------
4

Explanation:
------------
Boat 1: (3)
Boat 2: (3)
Boat 3: (4)
Boat 4: (5)
Total boats required: 4.
 */

 import java.util.*;
 class Boat{
    static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int boats=0;
        int low=0;
        int high=people.length-1;
        while(low<=high){
            if(people[low]+people[high]<=limit){
                low++;
            }
            high--;
            boats++;
        }
        return boats;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int []arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int k=sc.nextInt();
        System.out.println(numRescueBoats(arr, k));
    }
 }