package Loo_GCD_Recursive_call;

public class MainGcd {
    public static void main(String[] args) {
        int result = gcd(20,11);
        System.out.println(result);
    }
    static int gcd(int a, int b){
        int x = a % b;
        if(x==0){ // base Condition
            return b;
        }
        return gcd(b,x);
    }
}
