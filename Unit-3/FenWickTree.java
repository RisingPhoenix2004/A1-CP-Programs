/*
 * Malika taught a new fun time program practice for Engineering Students.
 * As a part of this she has given set of N numbers, and asked the students
 * to perform the operations listed below:
 * 1. sumRange(start, end) - return the sum of numbers between the indices start
 * and end, both are inclusive.
 * 2. update(ind, val) - update the value at the index 'ind' to 'val'.
 * 
 * Your task is to solve this problem using Fenwick Tree concept.
 * 
 * Input Format:
 * -------------
 * Line-1: Two integers N and Q, size of the array(set of numbers) and query
 * count.
 * Line-2: N space separated integers.
 * next Q lines: Three integers option, start/ind and end/val.
 * 
 * Output Format:
 * --------------
 * An integer result, for every sumRange query.
 * 
 * 
 * Sample Input-1:
 * ---------------
 * 8 5
 * 1 2 13 4 25 16 17 8
 * 1 2 6 //sumRange
 * 1 0 7 //sumRange
 * 2 2 18 //update
 * 2 4 17 //update
 * 1 2 7 //sumRange
 * 
 * Sample Output-1:
 * ----------------
 * 75
 * 86
 * 80
 * 
 * 
 * 
 * Sample Input-2:
 * ---------------
 * 8 5
 * 1 2 13 4 25 16 17 8
 * 1 2 6
 * 1 0 7
 * 2 2 18
 * 2 4 17
 * 1 0 7
 * 
 * Sample Output-2:
 * ----------------
 * 75
 * 86
 * 83
 */
import java.util.*;
class FenWickTree{
    static int []BIT;
    static int n;
    
    FenWickTree(int n){
        this.n=n;;
        BIT=new int[n+1];
    }
    
    static void init(int i,int val){
        while(i<=n){
            BIT[i]+=val;
            i+=(i&-i);
        }
    }
    
    static int getSum(int i){
        i++;
        int sum=0;
        while(i>0){
            sum+=BIT[i];
            i-=(i&-i);
        }
        return sum;
    }
    
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int op=sc.nextInt();
        int[]arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        FenWickTree ft=new FenWickTree(n);
        for(int i=0;i<n;i++){
            init(i+1,arr[i]);
        }
        ArrayList<Integer> result=new ArrayList<>();
        for(int i=0;i<op;i++){
            int operation=sc.nextInt();
            if(operation==1){
                int l=sc.nextInt();
                int r=sc.nextInt();
                result.add(getSum(r)-getSum(l-1));
            }
            else if(operation==2){
                int index=sc.nextInt();
                int value=sc.nextInt();
                int diff=value-arr[index];
                init(index+1,diff);
            }
        }
        
        for(Integer a: result){
            System.out.println(a);
        }
    }
}