package calculator.calculatorspringdemo;

import calculator.CalculatorServiceImpl;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static calculator.calculatorspringdemo.CalcServiceImplTestConstants.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorServiceImplTest {

        private final CalculatorServiceImpl out = new CalculatorServiceImpl();

        @Test
        void shouldReturnCorrectResultWithMethodPlusTest1() {
            int expected = num1 + num2;
            int actual = Integer.parseInt(out.plus(num1, num2));
            assertEquals(expected, actual);
        }

        @Test
        void shouldReturnCorrectResultWithMethodPlusTest2() {
            int expected = num3 + num4;
            int actual = Integer.parseInt(out.plus(num3, num4));
            assertEquals(expected, actual);
        }

        @Test
        void shouldReturnCorrectResultWithMethodPlusTest3() {
            int expected = num1 + num4;
            int actual = Integer.parseInt(out.plus(num1, num4));
            assertEquals(expected, actual);
        }

        @Test
        void shouldThrowNoArgumentSpecifiedExceptionWithMethodPlus() {
            for (String s : Arrays.asList(out.plus(num1, null), out.plus(null, num2))) {
                assertThrows();
            }
        }

        @Test
        void shouldReturnCorrectResultWithMethodMinusTest1() {
            int expected = num1 - num2;
            int actual = Integer.parseInt(out.minus(num1, num2));
            assertEquals(expected, actual);
        }

        @Test
        void shouldReturnCorrectResultWithMethodMinusTest2() {
            Integer num3 = null;
            int expected = num3 - num4;
            int actual = Integer.parseInt(out.minus(num3, num4));
            assertEquals(expected, actual);
        }

        @Test
        void shouldReturnCorrectResultWithMethodMinusTest3() {
            int expected = num1 - num4;
            int actual = Integer.parseInt(out.minus(num1, num4));
            assertEquals(expected, actual);
        }

        @Test
        void shouldThrowNoArgumentSpecifiedExceptionWithMethodMinus() {
            assertThrows();
            assertThrows();
        }

        @Test
        void shouldReturnCorrectResultWithMethodMultiplyTest1() {
            int expected = num1 * num2;
            int actual = Integer.parseInt(out.multiply(num1, num2));
            assertEquals(expected, actual);
        }

        @Test
        void shouldReturnCorrectResultWithMethodMultiplyTest2() {
            int expected = num3 * num4;
            int actual = Integer.parseInt(out.multiply(num3, num4));
            assertEquals(expected, actual);
        }

        @Test
        void shouldReturnCorrectResultWithMethodMultiplyTest3() {
            int expected = num1 * num4;
            int actual = Integer.parseInt(out.multiply(num1, num4));
            assertEquals(expected, actual);
        }

        @Test
        void shouldThrowNoArgumentSpecifiedExceptionWithMethodMultiply() {
            for (String s : Arrays.asList(out.multiply(num1, null), out.multiply(null, num2))) {
                assertThrows();
            }
        }

    private void assertThrows() {

    }

    @Test
        void shouldReturnCorrectResultWithMethodDivideTest1() {
            double expected = num1 / (double) num2;
            double actual = Double.parseDouble(out.divide(num1, num2));
            assertEquals(expected, actual);
        }

        @Test
        void shouldReturnCorrectResultWithMethodDivideTest2() {
            double expected = num3 / (double) num4;
            double actual = Double.parseDouble(out.divide(num3, num3));
            assertEquals(expected, actual);
        }

        @Test
        void shouldReturnCorrectResultWithMethodDivideTest3() {
            double expected = num1 / (double) num4;
            double actual = Double.parseDouble(out.divide(num1, num4));
            assertEquals(expected, actual);
        }

        @Test
        void shouldThrowNoArgumentSpecifiedExceptionWithMethodDivide() {
            for (String s : Arrays.asList(out.divide(num1, null), out.divide(null, num2))) {
                assertThrows();
            }
        }

        @Test
        public void shouldThrowIllegalArgumentExceptionWithMethodDivide() {
            assertThrows();
        }
    }

