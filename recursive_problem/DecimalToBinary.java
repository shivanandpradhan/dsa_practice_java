package recursive_problem;

import java.util.Scanner;

public class DecimalToBinary {

    // static String convertDecimalToBinary(int num){
    //     if (num < 1) return "";
    //     return convertDecimalToBinary(num/2) + num % 2;
    // }

    static int convertDecimalToBinary(int num){
        if (num < 1) return 0;
        return num % 2 + 10 * convertDecimalToBinary(num/2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num;
        System.out.print("Enter number : ");
        num = sc.nextInt();
        System.out.println("Binary : " + convertDecimalToBinary(num));
    }
}
