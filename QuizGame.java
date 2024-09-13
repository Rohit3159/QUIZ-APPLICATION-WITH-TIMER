import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class QuizGame {
    private List<QuizQuestion> questions;
    private int score;
    private int totalQuestions;
    private List<Boolean> results;

    public QuizGame(List<QuizQuestion> questions) {
        this.questions = questions;
        this.score = 0;
        this.totalQuestions = questions.size();
        this.results = new ArrayList<>();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < totalQuestions; i++) {
            QuizQuestion question = questions.get(i);
            boolean result = askQuestion(scanner, question);
            results.add(result);
            if (result) {
                score++;
            }
        }
        displayResults();
        scanner.close();
    }

    private boolean askQuestion(Scanner scanner, QuizQuestion question) {
        System.out.println("\n" + question.getQuestion());
        String[] options = question.getOptions();
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }

        System.out.print("You have 10 seconds to answer (enter number 1-" + options.length + "): ");
        long startTime = System.currentTimeMillis();
        int answerIndex = -1;
        boolean answered = false;

        while (System.currentTimeMillis() - startTime < 10000) {
            if (scanner.hasNextInt()) {
                answerIndex = scanner.nextInt() - 1;
                if (answerIndex >= 0 && answerIndex < options.length) {
                    answered = true;
                    break;
                } else {
                    System.out.print("Invalid choice. Enter number 1-" + options.length + ": ");
                }
            }
        }

        if (!answered) {
            System.out.println("\nTime's up!");
            return false;
        }

        return question.isCorrectAnswer(answerIndex);
    }

    private void displayResults() {
        System.out.println("\nQuiz Completed!");
        System.out.println("Your final score: " + score + "/" + totalQuestions);
        for (int i = 0; i < totalQuestions; i++) {
            System.out.println("Question " + (i + 1) + ": " + (results.get(i) ? "Correct" : "Incorrect"));
        }
    }
}

