package step3and4and5.client.output;

import step3and4and5.game.car.Cars;
import step3and4and5.game.car.WinningCars;

import java.util.List;

public class ConsoleOutputView implements OutputView {

    @Override
    public void print(Cars cars) {
        List<String> positionsAndNames = cars.positionsAndNames();
        positionsAndNames.forEach(System.out::println);
        System.out.println();
    }

    @Override
    public void print(WinningCars winningCars) {
        List<String> winners = winningCars.winners();
        int numberOfWinners = winners.size();

        for (int i = 0; i < numberOfWinners - 1; i++) {
            String outputValue = winners.get(i) + ", ";
            System.out.print(outputValue.trim());
        }

        String outputValue = winners.get(numberOfWinners - 1) + "가 최종 우승했습니다.";
        System.out.print(outputValue.trim());
    }

}