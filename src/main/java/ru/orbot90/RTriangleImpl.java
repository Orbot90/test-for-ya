package ru.orbot90;

/**
 * Реализация треугольника
 */
public class RTriangleImpl implements RTriangle {

    private int apexX1;
    private int apexY1;
    private int apexX2;
    private int apexY2;
    private int apexX3;
    private int apexY3;

    public RTriangleImpl(int apexX1, int apexY1, int apexX2, int apexY2, int apexX3, int apexY3) {
        this.apexX1 = apexX1;
        this.apexY1 = apexY1;
        this.apexX2 = apexX2;
        this.apexY2 = apexY2;
        this.apexX3 = apexX3;
        this.apexY3 = apexY3;
    }

    public static RTrianbleBuilder builder() {
        return new RTrianbleBuilder();
    }

    public int getApexX1() {
        return apexX1;
    }

    public int getApexY1() {
        return apexY1;
    }

    public int getApexX2() {
        return apexX2;
    }

    public int getApexY2() {
        return apexY2;
    }

    public int getApexX3() {
        return apexX3;
    }

    public int getApexY3() {
        return apexY3;
    }
}

/**
 * Билдер для треугольника
 */
class RTrianbleBuilder {
    private int apexX1;
    private int apexY1;
    private int apexX2;
    private int apexY2;
    private int apexX3;
    private int apexY3;

    public RTrianbleBuilder apexX1(int apexX1) {
        this.apexX1 = apexX1;
        return this;
    }

    public RTrianbleBuilder apexY1(int apexY1) {
        this.apexY1 = apexY1;
        return this;
    }

    public RTrianbleBuilder apexX2(int apexX2) {
        this.apexX2 = apexX2;
        return this;
    }

    public RTrianbleBuilder apexY2(int apexY2) {
        this.apexY2 = apexY2;
        return this;
    }

    public RTrianbleBuilder apexX3(int apexX3) {
        this.apexX3 = apexX3;
        return this;
    }

    public RTrianbleBuilder apexY3(int apexY3) {
        this.apexY3 = apexY3;
        return this;
    }

    public RTriangle build() {
        return new RTriangleImpl(apexX1, apexY1, apexX2, apexY2, apexX3, apexY3);
    }
}
