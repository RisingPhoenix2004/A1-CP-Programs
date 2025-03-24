import java.util.*;
public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int a [] = new int[n];
        for(int i =0;i<n;i++){
            a[i] =  sc.nextInt();
        }
        System.out.println(findmax(n,k,a));
    }
    static int findmax(int n,int k,int [] a){
        int sum = 0;
        for(int i =0;i<k;i++){
            sum += a[i];
        }
        int maxs = sum;
        for(int i=k;i<n;i++){
            sum += a[i] - a[i-k];
            maxs = Math.max(sum,maxs);
        }
        return maxs;
    }
}
