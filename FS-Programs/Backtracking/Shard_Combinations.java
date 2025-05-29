/*
 * You are given a crystal with an energy level n. Your goal is to discover all the different ways this crystal could have been created by combining smaller shards.

Each combination must:
- Use only shards with energy values between 2 and n - 1.
- Be represented as a list of shard values whose product equals n.
- Use any number of shards (minimum 2), and the order is ascending order.

Your task is to return all unique shard combinations that can multiply together to recreate the original crystal.

Input Format:
-------------
Line-1: An integer

Output Format:
--------------
Line-1: List of all unique shard combinations

Sample Input-1:
---------------
28

Sample Output-1:
----------------
[[2, 14], [2, 2, 7], [4, 7]]

Sample Input-2:
---------------
23

Sample Output-2:
----------------
[]


Constraints:
- 1 <= n <= 10^4
- Only shards with energy between 2 and n - 1 can be used.

 */

 import java.util.ArrayList;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        ArrayList<Integer> products = new ArrayList<>();
        ArrayList<ArrayList<Integer>> solution = new ArrayList<>();
        findcomb(num, 2,products, solution);
        System.out.println(solution);
    }

    public static void findcomb(int num, int start, ArrayList<Integer> products, ArrayList<ArrayList<Integer>> solution) {
        if (num == 1) {
            if (products.size() > 1) {
                solution.add(new ArrayList<>(products));
            }
            return;
        }

        for (int i = start; i <= num; i++) {
            if (num % i == 0) {
                products.add(i);
                findcomb(num / i,i, products, solution);
                products.remove(products.size() - 1);
            }
        }
    }
}