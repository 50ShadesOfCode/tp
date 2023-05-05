package lab1;

/**
 * Абстрактный класс треугольника со свойствами <b>a</b>, <b>b</b> и
 * <b>angle</b>
 * 
 * @author Artyom Kaktysh
 * @version 1.0
 */
public abstract class Triangle {
    /** Виртуальная функция для вычисления площади */
    abstract double square();

    /** Виртуальная функция для вычисления периметра */
    abstract double perimeter();

    /** Сторона а */
    protected int a;
    /** Сторона b */
    protected int b;
    /** Угол между сторонами a и b */
    protected int angle;

}
