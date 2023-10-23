package org.spaceship;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CodeWarsTest {
    private CodeWars codeWars;
    @BeforeEach
    void setUp() {
        codeWars = new CodeWars();
    }

    @ParameterizedTest
    @MethodSource({"sofixitCase", "defaultCase", "boundariesCase"})
    void materialTest(int[] spaceship, int expectedMaterial) {
        final int actualMaterial = codeWars.material(spaceship);
        assertEquals(expectedMaterial, actualMaterial);
    }

    static Stream<Arguments> sofixitCase() {
        return Stream.of(
                Arguments.of(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}, 6),
                Arguments.of(new int[]{0, 1, 0, 2, 1, 0, 3, 1, 0, 1, 2}, 8),
                Arguments.of(new int[]{4, 2, 0, 3, 2, 4}, 9),
                Arguments.of(new int[]{0, 1, 0, 2, 1, 0, 3, 1, 2, 0}, 5),
                Arguments.of(new int[]{0, 3, 2, 0, 3, 2, 0, 4, 2, 0}, 8)
        );
    }

    static Stream<Arguments> defaultCase() {
        return Stream.of(
                Arguments.of(new int[]{4, 2, 4}, 2),
                Arguments.of(new int[]{10, 0, 9, 0, 10}, 21),
                Arguments.of(new int[]{1, 2, 1}, 0)
        );
    }

    static Stream<Arguments> boundariesCase() {
        return Stream.of(
                Arguments.of(new int[]{}, 0),
                Arguments.of(new int[]{0}, 0),
                Arguments.of(new int[]{1}, 0),
                Arguments.of(new int[]{2}, 0),
                Arguments.of(new int[]{0, 0}, 0),
                Arguments.of(new int[]{0, 2}, 0),
                Arguments.of(new int[]{2, 0}, 0),
                Arguments.of(new int[]{2, 2}, 0),
                Arguments.of(new int[]{1, 2, 1}, 0)

        );
    }

}