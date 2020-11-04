package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step3.application.RandomMovableStrategy;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarFactoryTest {
    private final MovableStrategy movableStrategy = new RandomMovableStrategy();

    @DisplayName("'RacingCar' 다중 생성 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
    void createCars(final int numberOfCar) {
        // when
        final List<RacingCar> result = RacingCarFactory.createCars(numberOfCar, movableStrategy);

        // then
        assertThat(result.size()).isEqualTo(numberOfCar);
    }
}