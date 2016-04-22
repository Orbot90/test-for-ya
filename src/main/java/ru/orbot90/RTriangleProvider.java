package ru.orbot90;

/**
 * Класс, возвращающий прямоугольный треугольник
 */
public class RTriangleProvider {

    public static RTriangle getRTriangle() {
        return RTriangleImpl.builder()
                .apexX1(3)
                .apexY1(4)
                .apexX2(5)
                .apexY2(6)
                .apexX3(7)
                .apexY3(4)
                .build();
    }
}
