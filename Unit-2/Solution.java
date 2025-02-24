import java.util.Scanner;

class Solution {
    static String getBinary(int n){
        String res=new String();
        while(n!=1){
            if(n%2==1){
                res+='1';
            }
            else{
                res+='0';
            }
            n=n/2;
        }
        res+='1';
        String result=new StringBuilder(res).reverse().toString();
        return result;
    }
    static String getComplement(String binary){
        StringBuilder res=new StringBuilder();
        for(int i=0;i<binary.length();i++){
            if(binary.charAt(i)=='1'){
                res.append("0");
            }
            else{
                res.append("1");
            }
        }
        System.out.println(res);
        return res.toString();
    }
    static int convert2Decimal(String complement){
        int num=0;
        int p2=1;
        int len=complement.length();
        for(int i=len-1;i>0;i--){
            if(complement.charAt(i) == '1'){
                num+=p2;
            }
            p2=p2*2;
        }
        return num;
    }
    static int findComplement(int num) {
        String binary=getBinary(num);
        String complement=getComplement(binary);
        int res=convert2Decimal(complement);
        return res;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(findComplement(n));
    }
}