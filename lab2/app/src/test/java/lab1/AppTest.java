package lab1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

class AppTest {
    @Test
    void wrongConstructorTest1() {
        IsoscelesTriangle triangle;
        triangle = new IsoscelesTriangle(5, 6, 0, "black", "red");
        Assertions.assertFalse(triangle.getAngle() < 90 && triangle.getAngle() > 0);
    }

    @Test
    void wrongConstructorTest2() {
        IsoscelesTriangle triangle;
        triangle = new IsoscelesTriangle(-1, 6, 55, "black", "red");
        Assertions.assertFalse(triangle.getA() > 0 && triangle.getB() > 0);
    }

    @Test
    void wrongConstructorTest3() {
        IsoscelesTriangle triangle;
        triangle = new IsoscelesTriangle(5, 6, 55, "black", "red");
        Assertions.assertFalse(triangle.getB() == 2 * triangle.getA() * Math.cos(triangle.getAngle()));
    }

    @Test
    void contructorTest() {
        IsoscelesTriangle triangle;
        triangle = new IsoscelesTriangle(6, 6, 60, "black", "red");
        Assertions.assertTrue(triangle.getAngle() < 90 && triangle.getAngle() > 0);
        Assertions.assertTrue(triangle.getA() > 0 && triangle.getB() > 0);
        Assertions.assertTrue(
                triangle.getB() == Math.round(2 * triangle.getA() * Math.cos(Math.toRadians(triangle.getAngle()))));
    }

    @Test
    void squareTest() {
        IsoscelesTriangle triangle;
        double expected = 6 * 6 / 4 * Math.sqrt(3);
        triangle = new IsoscelesTriangle(6, 6, 60, "black", "red");
        Assertions.assertEquals(expected, triangle.square());
    }

    @Test
    void perimeterTest() {
        IsoscelesTriangle triangle;
        int expected = 18;
        triangle = new IsoscelesTriangle(6, 6, 60, "black", "red");
        Assertions.assertEquals(expected, triangle.perimeter());
    }

    @Test
    void getSideATest() {
        IsoscelesTriangle triangle;
        triangle = new IsoscelesTriangle(6, 6, 60, "black", "red");
        int expected = 6;
        Assertions.assertEquals(expected, triangle.getA());
    }

    @Test
    void getSideBTest() {
        IsoscelesTriangle triangle;
        triangle = new IsoscelesTriangle(6, 6, 60, "black", "red");
        int expected = 6;
        Assertions.assertEquals(expected, triangle.getB());
    }

    @Test
    void getAngleTest() {
        IsoscelesTriangle triangle;
        triangle = new IsoscelesTriangle(6, 6, 60, "black", "red");
        int expected = 60;
        Assertions.assertEquals(expected, triangle.getAngle());
    }

    @Test
    void getFillColorTest() {
        IsoscelesTriangle triangle;
        triangle = new IsoscelesTriangle(6, 6, 60, "black", "red");
        String expected = "red";
        Assertions.assertEquals(expected, triangle.getFillColor());
    }

    @Test
    void getOutlineColorTest() {
        IsoscelesTriangle triangle;
        triangle = new IsoscelesTriangle(6, 6, 60, "black", "red");
        String expected = "black";
        Assertions.assertEquals(expected, triangle.getOutlineColor());
    }

    @Test
    void hasNextTest() {
        // given
        IsoscelesTriangle triangle;
        triangle = new IsoscelesTriangle(6, 6, 60, "black", "red");
        // when
        triangle.next();
        triangle.next();
        // then
        Assertions.assertTrue(triangle.hasNext());
    }

    @Test
    void wrongHasNextTest() {
        IsoscelesTriangle triangle;
        triangle = new IsoscelesTriangle(6, 6, 60, "black", "red");
        triangle.next();
        triangle.next();
        triangle.next();
        triangle.next();
        triangle.next();
        Assertions.assertFalse(triangle.hasNext());
    }

    @Test
    void removeTest() {
        IsoscelesTriangle triangle;
        triangle = new IsoscelesTriangle(6, 6, 60, "black", "red");
        Assertions.assertThrows(UnsupportedOperationException.class, () -> {
            triangle.remove();
        });
    }

    @Test
    void nextTest() {
        IsoscelesTriangle triangle;
        triangle = new IsoscelesTriangle(6, 6, 60, "black", "red");
        triangle.next();
        triangle.next();
        Assertions.assertEquals(60, triangle.next());
    }

    @Test
    void testToString() {
        IsoscelesTriangle triangle;
        triangle = new IsoscelesTriangle(6, 6, 60, "black", "red");
        String expected = "Triangle: 6 6 60 black red";
        Assertions.assertEquals(expected, triangle.toString());
    }

    @Test
    void testFromString() {
        IsoscelesTriangle expected = new IsoscelesTriangle(6, 6, 60, "black", "red");
        Assertions.assertEquals(expected.compareTo(IsoscelesTriangle.fromString("Triangle: 6 6 60 black red")), 0);
    }

    @Test
    void testCompareTo() {
        IsoscelesTriangle triangle = new IsoscelesTriangle(6, 6, 60, "black", "red");
        IsoscelesTriangle testTriangle = new IsoscelesTriangle(6, 6, 60, "black", "red");
        Assertions.assertEquals(triangle.compareTo(testTriangle), 0);
    }

    @Test
    void testWrongCompareTo() {
        IsoscelesTriangle triangle = new IsoscelesTriangle(6, 6, 60, "black", "red");
        IsoscelesTriangle testTriangle = new IsoscelesTriangle(5, 6, 60, "black", "red");
        Assertions.assertEquals(triangle.compareTo(testTriangle), 1);
    }
}
