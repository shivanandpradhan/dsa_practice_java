package recursive_problem;
import java.util.Scanner;

public class Gcd {

    // find Gcd of a and b
    static int findGCD(int a, int b){
        a = Math.abs(a); b = Math.abs(b);
        if (a > b) return recursiveGCD(a, b);
        return recursiveGCD(b, a);
    }   

    // recursive solution for gcd
    static int recursiveGCD(int a, int b){
        if (b == 0) return a;
        return findGCD(b, a % b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a : ");
        int a = sc.nextInt();
        System.out.println("Enter b : ");
        int b = sc.nextInt();
        System.out.println("GCD(a, b) : " + findGCD(a, b));
    }
}
