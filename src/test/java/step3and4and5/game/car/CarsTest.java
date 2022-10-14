package step3and4and5.game.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3and4and5.client.number.RandomNumber;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarsTest {

    @Test
    @DisplayName("자동차들에게 턴을 사용할 있게 알람을 줄 수 있다.")
    void a() {
        Number number = new Number.Fake(4);
        Car car = new Car.Factory(number, "1").car();
        Cars sut = new Cars(List.of(car));

        Car movedCar = new Car.Factory(number, new Position(1), "1").car();
        assertThat(sut.carsWithTurnUsed()).isEqualTo(new Cars(List.of(movedCar)));
    }

    @Test
    @DisplayName("만드려는 자동차의 이름을 입력하면 이름의 개수 만큼 자동차들이 만들어진다")
    void b() {
        Cars.Factory sut = new Cars.Factory(new String[]{"abc"});

        Car car = new Car.Factory(new RandomNumber(), "abc").car();
        assertThat(sut.cars(new Number.Fake(1))).isEqualTo(new Cars(List.of(car)));
    }

    @Test
    @DisplayName("자동차들을 출력할 수 있다.")
    void c() {
        Number number = new Number.Fake(4);
        Car car = new Car.Factory(number, "abced").car();
        Cars sut = new Cars(List.of(car));

        assertThat(sut.positionsAndNames()).containsExactly(car.print());
    }

    @Test
    @DisplayName("자동차 생성시 입력값 유효성 검증")
    void d() {
        assertThatThrownBy(() -> new Cars.Factory(new String[]{}).cars(new Number.Fake(1)))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("빈 공백일 수 없습니다.");
    }

}