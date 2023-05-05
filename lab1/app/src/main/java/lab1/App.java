package lab1;

import java.util.*;

/**
 * Класс приложения содержащий функцию <b>main()</b>. Предназначен для
 * демонстрации работы класса {@link IsoscelesTriangle}.
 * 
 * @author Artyom Kaktysh
 * @version 1.0
 */
public class App {
    /**
     * Главная функция приложения объявляющая и сортирующая массив объектов
     * {@link IsoscelesTriangle}.
     * 
     * @param args - аргументы консольного приложения
     */
    public static void main(String[] args) {
        IsoscelesTriangle[] arr = { new IsoscelesTriangle(1, 2, 25, "black", "white"),
                new IsoscelesTriangle(2, 3, 55, "yellow", "orange"),
                new IsoscelesTriangle(1, 2, 35, "red", "white"), };
        Arrays.sort(arr, IsoscelesTriangle.byAngle);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
