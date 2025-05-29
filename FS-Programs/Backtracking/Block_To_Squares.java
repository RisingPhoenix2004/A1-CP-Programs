/*
 * Bablu is working in a construction field.
He has N number of building blocks, where the height and width of all the blocks are same.
And the length of each block is given in an array, blocks[].

Bablu is planned to build a wall in the form of a square.
The rules to cunstruct the wall are as follows:
	- He should use all the building blocks.
	- He should not break any building block, but you can attach them with other.
	- Each building-block must be used only once.
	
Your task is to check whether Bablu can cunstruct the wall as a square
with the given rules or not. If possible, print true. Otherwise, print false.

Input Format:
-------------
Line-1: An integer N, number of BuildingBlocks.
Line-2: N space separated integers, length of each block.

Output Format:
--------------
Print a boolean value.


Sample Input-1:
---------------
6
1 2 6 4 5 6

Sample Output-1:
----------------
true


Sample Input-2:
---------------
6
5 3 2 5 5 6

Sample Output-2:
----------------
false

 */
import java.util.*;
public class Main{
    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            max = Math.max(arr[i], max);
        }
        System.out.println(canFormSquare(arr));
    }
    private static boolean canFormSquare(int[] blocks) {
        int totalLength = Arrays.stream(blocks).sum();
        if (totalLength % 4 != 0) {
            return false;
        }
        int sideLength = totalLength / 4;
        Arrays.sort(blocks);
        return backtrack(blocks, new int[4], blocks.length - 1, sideLength);
    }
    private static boolean backtrack(int[] blocks, int[] sides, int index, int target) {
        if (index < 0) {
            return sides[0] == target && sides[1] == target && sides[2] == target && sides[3] == target;
        }
        for (int i = 0; i < 4; i++) {
            if (sides[i] + blocks[index] <= target) {
                sides[i] += blocks[index];
                if (backtrack(blocks, sides, index - 1, target)) {
                    return true;
                }
                sides[i] -= blocks[index];
            }
            if (sides[i] == 0) break; 
        }
        
        return false;
    }
}
