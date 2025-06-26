/*
 * Given a list of n strings, remove duplicate entries, 
preserving only the first occurrence, and output the deduplicated list.

Input Format:
-------------
Line-1: A integer n, number of strings
Line-2: n space separated strings

Output Format:
--------------
Space‐separated list of unique strings in original order.

Sample Input:
-------------
6
Java Python C# Java Kotlin Python

Sample Output:
--------------
Java Python C# Kotlin
 */
import java.util.*;
import java.util.stream.*;
class Sol{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String [] words = sc.nextLine().split(" ");
        Arrays.stream(words).collect(Collectors.toCollection(LinkedHashSet::new)).forEach(word -> System.out.println(word+" "));
    }
}
