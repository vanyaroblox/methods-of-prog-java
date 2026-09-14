/*Найти все p-значные числа из заданной последовательности натуральных чисел, в
записи которых не повторяются цифры, и подсчитать их количество.*/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class task1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Ввод числа p
        System.out.print("Введите количество цифр p: ");
        int p = scanner.nextInt();

        // 2. Ввод последовательности чисел
        System.out.println("Введите натуральные числа через пробел (завершите ввод нажатием Enter):");
        scanner.nextLine(); // очистка буфера
        String line = scanner.nextLine();
        String[] tokens = line.trim().split("\\s+");

        // Преобразуем в список чисел
        List<Integer> numbers = new ArrayList<>();
        for (String token : tokens) {
            if (!token.isEmpty()) {
                try {
                    numbers.add(Integer.parseInt(token));
                } catch (NumberFormatException e) {
                    System.out.println("Пропущен некорректный ввод: " + token);
                }
            }
        }

        // 3. Поиск подходящих чисел
        List<Integer> result = new ArrayList<>();
        for (int num : numbers) {
            if (isPValued(num, p) && hasUniqueDigits(num)) {
                result.add(num);
            }
        }

        // 4. Вывод результата
        System.out.println("Найденные числа: " + result);
        System.out.println("Количество: " + result.size());
        scanner.close();
    }

    /**
     * Проверяет, является ли число p-значным (имеет ровно p цифр).
     * Натуральные числа не содержат ведущих нулей.
     */
    private static boolean isPValued(int num, int p) {
        if (num < 0) return false; // только натуральные
        if (p < 1) return false;   // p должно быть >= 1

        int count = 0;
        int temp = num;
        // Особый случай: число 0 (не натуральное, но для полноты)
        if (temp == 0) {
            count = 1;
        } else {
            while (temp > 0) {
                count++;
                temp /= 10;
            }
        }
        return count == p;
    }

    /**
     * Проверяет, что все цифры числа уникальны (не повторяются).
     * Использует массив булевых значений для отслеживания встреченных цифр.
     */
    private static boolean hasUniqueDigits(int num) {
        if (num < 0) return false;
        boolean[] seen = new boolean[10]; // цифры от 0 до 9

        int temp = num;
        // Обрабатываем случай num == 0 (одна цифра, она уникальна)
        if (temp == 0) {
            return true;
        }

        while (temp > 0) {
            int digit = temp % 10;
            if (seen[digit]) {
                return false; // цифра уже встречалась
            }
            seen[digit] = true;
            temp /= 10;
        }
        return true;
    }
}