package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class TestExample {

    static Stream<Arguments> 메서드_소스_테스트_케이스() {
        return Stream.of(
                Arguments.of("안녕", "하세요", "안녕하세요"),
                Arguments.of("잘", "가세요", "잘가세요")
        );
    }

    @Test
    void 기본_테스트() {
        // Given
        int a = 4;
        int b = 7;

        // When
        int expected = 11;

        // Then
        assertThat(a + b).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"hello", "hillo"})
    void 문자열_value_테스트(String value) {

        // When
        int expected = 5;

        // Then
        assertThat(value.length()).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,45,46", "1,10,11"}, delimiter = ',')
    void csv_테스트(int a, int b, int actual) {

        // When
        int expected = a + b;

        // Then
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest(name = "a: {0}, b: {1}, actual: {2}")
    @MethodSource("메서드_소스_테스트_케이스")
    void 메서드_소스_테스트(String a, String b, String actual) {

        // When
        String expected = a + b;

        // Then
        assertThat(expected).isEqualTo(actual);
    }
}
