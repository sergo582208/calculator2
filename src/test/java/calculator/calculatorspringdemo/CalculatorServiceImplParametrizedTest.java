package calculator.calculatorspringdemo;

import calculator.CalculatorServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static calculator.calculatorspringdemo.CalcServiceImplTestConstants.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorServiceImplParametrizedTest {
        private final CalculatorServiceImpl out = new CalculatorServiceImpl();

        @ParameterizedTest
        @MethodSource("provideParamsForCorrectValueTests")
        public void shouldReturnCorrectResultWithMethodPlus(Integer num1, Integer num2) {
            Integer expected = num1 + num2;
            Integer actual = Integer.valueOf(out.plus(num1, num2));
            assertEquals(expected, actual);
        }

        @ParameterizedTest
        @MethodSource("provideParamsForCorrectValueTests")
        public void shouldReturnCorrectResultWithMethodMinus(Integer num1, Integer num2) {
            Integer expected = num1 - num2;
            Integer actual = Integer.valueOf(out.minus(num1, num2));
            assertEquals(expected, actual);
        }

        @ParameterizedTest
        @MethodSource("provideParamsForCorrectValueTests")
        public void shouldReturnCorrectResultWithMethodMultiply(Integer num1, Integer num2) {
            Integer expected = num1 * num2;
            Integer actual = Integer.valueOf(out.multiply(num1, num2));
            assertEquals(expected, actual);
        }

        @ParameterizedTest
        @MethodSource("provideParamsForCorrectValueTests")
        public void shouldReturnCorrectResultWithMethodDivide(Integer num1, Integer num2) {
            double expected = num1 / (double) num2;
            double actual = Double.parseDouble(out.divide(num1, num2));
            assertEquals(expected, actual);
        }

        @ParameterizedTest
        @MethodSource("provideParamsForExceptionsTests")
        public void shouldThrowNoArgumentSpecifiedExceptionWithMethodPlus(Integer num1, Integer num2) {
            assertThrows(IllegalArgumentException.class, () -> out.plus(num1, num2));
        }

        @ParameterizedTest
        @MethodSource("provideParamsForExceptionsTests")
        public void shouldThrowNoArgumentSpecifiedExceptionWithMethodMinus(Integer num1, Integer num2) {
            assertThrows(IllegalArgumentException.class, () -> out.minus(num1, num2));
        }

        @ParameterizedTest
        @MethodSource("provideParamsForExceptionsTests")
        public void shouldThrowNoArgumentSpecifiedExceptionWithMethodMultiply(Integer num1, Integer num2) {
            assertThrows(IllegalArgumentException.class, () -> out.multiply(num1, num2));
        }

        @ParameterizedTest
        @MethodSource("provideParamsForExceptionsTests")
        public void shouldThrowNoArgumentSpecifiedExceptionWithMethodDivide(Integer num1, Integer num2) {
            assertThrows(IllegalArgumentException.class, () -> out.divide(num1, num2));
        }

        @Test
        public void shouldThrowIllegalArgumentExceptionWithMethodDivide() {
            assertThrows(IllegalArgumentException.class, () -> out.divide(num1, zero));
        }

        public static Stream<Arguments> provideParamsForCorrectValueTests() {
            return Stream.of(
                    Arguments.of(num1, num3),
                    Arguments.of(num3, num4),
                    Arguments.of(num1, num4)
            );
        }

        public static Stream<Arguments> provideParamsForExceptionsTests() {
            return Stream.of(
                    Arguments.of(num1, null),
                    Arguments.of(null, num1)
            );
        }
    }

