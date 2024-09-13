import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        QuizQuestion q1 = new QuizQuestion(
                "What is the Capital of Bihar?",
                new String[]{"Jharkhand", "Patna", "Dehradun", "Lucknow"},
                1
        );
        QuizQuestion q2 = new QuizQuestion(
                "What is 2 + 2?",
                new String[]{"3", "4", "5", "6"},
                1
        );
        QuizQuestion q3 = new QuizQuestion(
                "What is the color of the sky on a clear day?",
                new String[]{"Green", "Blue", "Red", "Yellow"},
                1
        );


        List<QuizQuestion> questions = Arrays.asList(q1, q2, q3);


        QuizGame game = new QuizGame(questions);
        game.start();
    }
}
