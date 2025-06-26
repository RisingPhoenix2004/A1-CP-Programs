/*
 * Given n strings, compute how many times each string appears, 
and output a frequency map in lexicographic order of the string.

Input Format:
-------------
Line-1: A integer n, number of strings
Line-2: n space separated strings

Output Format:
--------------
<string>:<count> 
One line per unique string

Sample Input:
-------------
8
Pen Eraser Notebook Pen Pencil Stapler Notebook Pencil

Sample Output:
--------------
Eraser:1
Notebook:2
Pen:2
Pencil:2
Stapler:1
 */
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
class Main{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String [] words = sc.nextLine().split(" ");
        Arrays.stream(words).collect(Collectors.groupingBy(s-> s, Collectors.counting()))
        .entrySet()
        .stream()
        .sorted(Map.Entry.comparingByKey())
        .forEach(entry -> System.out.println(entry.getKey()+":"+entry.getValue()));
        
    }
}
