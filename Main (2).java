package com.company;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Генерация случайного количества монстров и их жизней
        int numberOfMonsters = generateRandomNumber(5, 10); // Минимум 5 монстров, максимум 10
        int[] originalMonsterLives = generateRandomLives(numberOfMonsters);
        int[] currentMonsterLives = Arrays.copyOf(originalMonsterLives, originalMonsterLives.length);

        // Вывод начальной информации
        System.out.println("Начальные параметры:");
        System.out.println("Количество монстров: " + numberOfMonsters);
        System.out.println("Жизни монстров: " + Arrays.toString(originalMonsterLives));

        // Ввод количества жизней, которые отнимает охотник за выстрел
        System.out.print("Введите количество жизней, которые отнимает охотник за выстрел: ");
        int damagePerShot = scanner.nextInt();

        // Охота на монстров
        while (!allMonstersDefeated(currentMonsterLives)) {
            int targetMonsterIndex = findStrongestMonster(currentMonsterLives);
            if (targetMonsterIndex != -1) {
                currentMonsterLives[targetMonsterIndex] -= damagePerShot;
                if (currentMonsterLives[targetMonsterIndex] <= 0) {
                    System.out.println("Монстр " + (targetMonsterIndex + 1) + " повержен!");
                    System.out.println("Исходные жизни монстра: " + originalMonsterLives[targetMonsterIndex]);
                    currentMonsterLives[targetMonsterIndex] = 0;
                }
            }
        }

        // Вывод сообщения о победе
        System.out.println("\nВсе монстры побеждены! Охотник победил!");
    }

    // Генерация случайного числа в заданном диапазоне
    private static int generateRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    // Генерация случайных жизней для монстров
    private static int[] generateRandomLives(int numberOfMonsters) {
        int[] lives = new int[numberOfMonsters];
        for (int i = 0; i < numberOfMonsters; i++) {
            lives[i] = generateRandomNumber(1, 100); // Жизни от 1 до 100
        }
        return lives;
    }

    // Проверка, все ли монстры побеждены
    private static boolean allMonstersDefeated(int[] monsterLives) {
        for (int lives : monsterLives) {
            if (lives > 0) {
                return false;
            }
        }
        return true;
    }

    // Поиск индекса монстра с наибольшим количеством жизней
    private static int findStrongestMonster(int[] monsterLives) {
        int maxLives = 0;
        int targetMonsterIndex = -1;
        for (int i = 0; i < monsterLives.length; i++) {
            if (monsterLives[i] > maxLives) {
                maxLives = monsterLives[i];
                targetMonsterIndex = i;
            }
        }
        return targetMonsterIndex;
    }
}
