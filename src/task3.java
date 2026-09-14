/* Найти и вывести все четырёхзначные числа из заданной последовательности
целых чисел. Подсчитать количество четырёхзначных чисел, сумма цифр которых равна */

import java.util.Scanner;

public class task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите k: ");
        int k = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Введите числа через пробел:");
        String line = scanner.nextLine();
        String[] parts = line.split(" ");

        int count = 0;

        for (int i = 0; i < parts.length; i++) {
            int num = Integer.parseInt(parts[i]);

            if (num >= 1000 && num <= 9999) {
                System.out.println("Четырёхзначное: " + num);

                int sum = 0;
                int temp = num;
                while (temp > 0) {
                    sum = sum + temp % 10;
                    temp = temp / 10;
                }

                if (sum == k) {
                    count++;
                }
            }
        }

        System.out.println("Количество с суммой цифр " + k + ": " + count);

        scanner.close();
    }
}