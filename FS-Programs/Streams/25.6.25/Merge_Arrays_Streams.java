/*
 * Given two arrays a of size m and b of size n, 
merge them into a single sorted array and print it.

Input Format:
-------------
Line-1: two space separated integers m and n, sizes of two arrays
Line-2: m space separated integers, a₁ a₂ … a_m
Line-3: n space separated integers, b₁ b₂ … b_n

Output Format:
--------------
Sorted merged array in one line, space‐separated.

Sample Input:
-------------
4 4
4 2 7 1
8 3 9 5

Sample Output:
--------------
1 2 3 4 5 7 8 9
 */
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;
class Merge{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int [] a = new int[m];
        int [] b = new int[n];
        for(int i = 0 ; i < m ; i++){
            a[i] = sc.nextInt();
        }
        for(int i = 0 ; i < n ; i++){
            b[i] = sc.nextInt();
        }
        int [] result = Stream.of(a,b).flatMapToInt(Arrays::stream).sorted().toArray();
        for(int num:result){
            System.out.print(num+" ");
        }
    }
}
