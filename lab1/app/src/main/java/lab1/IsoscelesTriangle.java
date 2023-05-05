package lab1;

import java.util.*;

/**
 * Класс равнобедренного треугольника со свойствами <b>a</b>, <b>b</b> и
 * <b>angle</b>, <b>outlineColor</b> и <b>fillColor</b>. Класс реализует
 * интерфейсы Comparable<T>, Iterable<T>, Iterator<T> и наследуется от класса
 * Triangle.
 * 
 * @author Artyom Kaktysh
 * @version 1.0
 */
public class IsoscelesTriangle extends Triangle
        implements Comparable<IsoscelesTriangle>, Iterable<Object>, Iterator<Object> {

    /** Метод для вычисления площади треугольника */
    @Override
    double square() {
        return a * b * 0.5 * Math.sin(angle);
    }

    /** Метод для вычисления периметра треугольника */
    @Override
    double perimeter() {
        return a + a + b;
    }

    /**
     * Метод получения значения поля а {@link IsoscelesTriangle#a}
     * 
     * @return длина стороны а
     */
    public int getA() {
        return a;
    }

    /**
     * Метод получения значения поля b {@link IsoscelesTriangle#b}
     * 
     * @return длина стороны b
     */
    public int getB() {
        return b;
    }

    /**
     * Метод получения значения поля аngle {@link IsoscelesTriangle#angle}
     * 
     * @return величина угла между сторонами а и b
     */
    public int getAngle() {
        return angle;
    }

    /**
     * Метод получения значения поля outlineColor
     * {@link IsoscelesTriangle#outlineColor}
     * 
     * @return цвет контура треугольника
     */
    public String getOutlineColor() {
        return outlineColor;
    }

    /**
     * Метод получения значения поля fillColor {@link IsoscelesTriangle#fillColor}
     * 
     * @return цвет заливки треугольника
     */
    public String getFillColor() {
        return fillColor;
    }

    /** Поле цвета контура треугольника */
    private String outlineColor;
    /** Поле цвета заливки треугольника */
    private String fillColor;

    /**
     * Конструктор - создание нового объекта IsoscelesTriangle с заданными
     * значениями
     * 
     * @param a            - длина стороны a
     * @param b            - длина стороны b
     * @param angle        - величина угла между сторонами a и b
     * @param outlineColor - цвет контура треугольника
     * @param fillColor    - цвет заливки треугольника
     */
    public IsoscelesTriangle(int a, int b, int angle, String outlineColor, String fillColor) {
        this.a = a;
        this.b = b;
        this.angle = angle;
        this.outlineColor = outlineColor;
        this.fillColor = fillColor;
    }

    /**
     * Объект класса Comparator<IsoscelesTriangle> предназначенный для сравнения
     * двух объектов по полю {@link IsoscelesTriangle#a}
     */
    public static Comparator<IsoscelesTriangle> byA = Comparator.comparing(IsoscelesTriangle::getA);
    /**
     * Объект класса Comparator<IsoscelesTriangle> предназначенный для сравнения
     * двух объектов по полю {@link IsoscelesTriangle#b}
     */
    public static Comparator<IsoscelesTriangle> byB = Comparator.comparing(IsoscelesTriangle::getB);
    /**
     * Объект класса Comparator<IsoscelesTriangle> предназначенный для сравнения
     * двух объектов по полю {@link IsoscelesTriangle#angle}
     */
    public static Comparator<IsoscelesTriangle> byAngle = Comparator.comparing(IsoscelesTriangle::getAngle);
    /**
     * Объект класса Comparator<IsoscelesTriangle> предназначенный для сравнения
     * двух объектов по полю {@link IsoscelesTriangle#fillColor}
     */
    public static Comparator<IsoscelesTriangle> byFillColor = Comparator.comparing(IsoscelesTriangle::getFillColor);
    /**
     * Объект класса Comparator<IsoscelesTriangle> предназначенный для сравнения
     * двух объектов по полю {@link IsoscelesTriangle#outlineColor}
     */
    public static Comparator<IsoscelesTriangle> byOutlineColor = Comparator
            .comparing(IsoscelesTriangle::getOutlineColor);

    /**
     * Переопределенный метод интерфейса Comparable<T> для сравнения двух объектов
     * {@link IsoscelesTriangle}
     * 
     * @param entry - объект с которым производится сравнение
     * @return результат сравнения двух объектов
     */
    @Override
    public int compareTo(IsoscelesTriangle entry) {

        int res = outlineColor.compareTo(entry.outlineColor);
        if (res != 0) {
            return res;
        }

        res = fillColor.compareTo(entry.fillColor);
        if (res != 0) {
            return res;
        }

        res = a - entry.a;
        if (res != 0) {
            return (int) res / Math.abs(res);
        }

        res = b - entry.b;
        if (res != 0) {
            return (int) res / Math.abs(res);
        }

        res = angle - entry.angle;
        if (res != 0) {
            return (int) res / Math.abs(res);
        }

        return 0;
    }

    /** Поле индекса для итератора */
    private int iterator_idx = -1;

    /** Процедура для сброса значения итератора */
    private void resetIterator() {
        iterator_idx = -1;
    }

    /**
     * Переопределенный метод интерфейса Iterable<T> для получения итератора по
     * полям объекта
     * 
     * @return итератор по полям объекта
     */
    @Override
    public Iterator<Object> iterator() {
        resetIterator();
        return this;
    }

    /**
     * Переопределенный метод интерфейса Iterator<T> для проверки на существование
     * следующего поля для итерирования
     * 
     * @return true - следующий элемент существует, false - нет
     */
    @Override
    public boolean hasNext() {
        return iterator_idx < 4;
    }

    /**
     * Переопределнный метод интерфейса Iterator<T> для удаления элемента
     * полученного
     * последним вызовом метода {@link IsoscelesTriangle#next()}
     * Метод не предназначен для использования так как поля класса не могут быть
     * удалены.
     */
    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

    /**
     * Переопределенный метод интерфейса Iterator<T> для получения следующего поля
     * объекта класса.
     * 
     * @return следующее поле объекта класса
     */
    @Override
    public Object next() {
        ++iterator_idx;
        switch (iterator_idx) {
            case 0:
                return a;
            case 1:
                return b;
            case 2:
                return angle;
            case 3:
                return outlineColor;
            case 4:
                return fillColor;
        }
        throw new NoSuchElementException();

    }

    /**
     * Метод возвращающий строку содержащую данные об объекте класса.
     * 
     * @return строка вида Triangle: a b angle outlineColor fillColor
     */
    @Override
    public String toString() {
        return "Triangle: " + a + " " + b + " " + angle + " " + outlineColor + " " + fillColor;
    }

    /**
     * Метод для создания нового объекта класса {@link IsoscelesTriangle} из строки.
     * 
     * @param input - исходная строка вида возвращаемой методом
     *              {@link IsoscelesTriangle#toString()}
     *
     * @return объект класса {@link IsoscelesTriangle} с параметрами заданными во
     *         входной строке
     */
    public static IsoscelesTriangle fromString(String input) {
        String[] arr = input.split(" ");
        return new IsoscelesTriangle(Integer.parseInt(arr[1]), Integer.parseInt(arr[2]), Integer.parseInt(arr[3]),
                arr[4], arr[5]);
    }
}
