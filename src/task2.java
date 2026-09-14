/*Для каждого числа из заданной последовательности натуральных чисел
определить, сколько в нем цифр. Если количество цифр чётное, то получить из него такое
число, чтобы цифры в нём следовали в обратном порядке. Если количество цифр
нечётное, то получить из исходного числа такое число, в котором все цифры 1 заменены
на 2, а цифры 0 — на 7.*/

import java.util.Scanner;

public class task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите числа через пробел:");
        String line = scanner.nextLine();
        String[] parts = line.split(" ");

        for (int i = 0; i < parts.length; i++) {
            String num = parts[i];
            int len = num.length();
            String result = "";

            if (len % 2 == 0) {
                for (int j = len - 1; j >= 0; j--) {
                    result = result + num.charAt(j);
                }
            } else {
                for (int j = 0; j < len; j++) {
                    char c = num.charAt(j);
                    if (c == '1') {
                        result = result + '2';
                    } else if (c == '0') {
                        result = result + '7';
                    } else {
                        result = result + c;
                    }
                }
            }

            System.out.println(num + " -> " + result);
        }

        scanner.close();
    }
}