package recursive_problem;

import java.util.Scanner;

class SumofDigits{

    // recursive -> n % 10 + f(n/10)
    // 34 % 10 = 4  & f(n/10) -> f(3)
    // 3 % 10 = 3 & f(n/10) -> f(0)
    // base case = n -> 0 return 0
    static int getSumOfDigits(int n){
        if (n == 0) return 0;
        return n % 10 + getSumOfDigits(n/10);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num;
        System.out.print("Enter number : ");
        num = sc.nextInt();
        System.out.println("Sum of Digits : " + getSumOfDigits(num));
    }
}