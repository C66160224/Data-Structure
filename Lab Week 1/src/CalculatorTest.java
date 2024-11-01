//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class CalculatorTest {
//
//    @Test
//    @DisplayName("add method")
//    void add() {
//        Calculator cal = new Calculator();
//
//        assertEquals(2 , 1+1);
//        assertEquals(2 , new Calculator().add(1 , 1));
//        assertEquals(2 , cal.add(1 , 1));
//        assertEquals(2 , Calculator.add(1 , 1)); //static
//    }
//
//    @Test
//    void multiply() {
//        Calculator cal = new Calculator();
//
//        assertEquals(1 , 1 * 1);
//        assertEquals(4 ,cal.multiply(2 , 2));
//    }
//
//    @Test
//    void minus() {
//        Calculator cal = new Calculator();
//
//        assertEquals(0 , 1 - 1);
//        assertEquals(3 , cal.minus(6 , 3));
//    }
//
//    @Test
//    void divide() {
//        Calculator cal = new Calculator();
//
//        assertEquals(2 , 4 / 2);
//        assertEquals(6 , cal.divide(48 , 8));
//    }
//}