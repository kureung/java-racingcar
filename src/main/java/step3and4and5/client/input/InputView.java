package step3and4and5.client.input;

import java.io.IOException;

public interface InputView {

    int answerToQuestion(String question) throws IOException;

    String[] carsNames(String question) throws IOException;

}