package ru.orbot90;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Тест, проверяющий, что RTriangleProvider возвращает прямоугольный треугольник
 *
 * testShouldReturnTriangle - проверяет, что полученные три точки образуют треугольник
 * testShouldReturnRTriangle - проверяет, что треугольник является прямоугольным
 */
public class RTriangleProviderTest {

    @Test
    public void testShouldReturnTriangle() {
        RTriangle triangle = RTriangleProvider.getRTriangle();
        Assert.assertFalse("Apexes should not lay on same line", isOnSameLine(triangle));
    }

    @Test
    public void testShouldReturnRTriangle() {
        RTriangle triangle = RTriangleProvider.getRTriangle();

        List<Double> sortedSizes = getSortedSizes(triangle);
        double firstCathetus = sortedSizes.get(1);
        double secondCathetus = sortedSizes.get(2);
        double delta = 0.001;

        Assert.assertEquals("Triangle is not right-angled",
                Math.pow(sortedSizes.get(0), 2), Math.pow(firstCathetus, 2) + Math.pow(secondCathetus, 2), delta);

    }

    private boolean isOnSameLine(RTriangle triangle) {
        int xArg = triangle.getApexY2() - triangle.getApexY1();
        int yArg = triangle.getApexX1() - triangle.getApexX2();
        int freeArg = triangle.getApexX2() * triangle.getApexY1() - triangle.getApexX1() * triangle.getApexY2();
        return  (xArg * triangle.getApexX3() + yArg * triangle.getApexY3() + freeArg) == 0;
    }

    private List<Double> getSortedSizes(RTriangle triangle) {
        List<Double> sizes = new ArrayList<>();
        sizes.add(
                getSideLength(triangle.getApexX1(), triangle.getApexY1(),
                        triangle.getApexX2(), triangle.getApexY2())
        );
        sizes.add(
                getSideLength(triangle.getApexX1(), triangle.getApexY1(),
                        triangle.getApexX3(), triangle.getApexY3())
        );
        sizes.add(
                getSideLength(triangle.getApexX2(), triangle.getApexY2(), triangle.getApexX3(), triangle.getApexY3())
        );
        return sizes.stream().sorted((size1, size2) -> Double.compare(size2, size1)).collect(Collectors.toList());
    }

    private Double getSideLength(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }
}
