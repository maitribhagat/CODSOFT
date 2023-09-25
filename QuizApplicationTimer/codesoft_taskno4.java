package javacode;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Random;

public class RefreshableQuiz {
    private String[][] questions = {
            {"What is the capital of France?", "A. London", "B. Paris", "C. Rome", "D. Madrid", "B"},
            {"What is the largest planet in our solar system?", "A. Jupiter", "B. Saturn", "C. Neptune", "D. Uranus", "A"},
            {"Which gas do plants primarily absorb from the atmosphere?", "A. Carbon dioxide", "B. Oxygen", "C. Nitrogen", "D. Hydrogen", "A"},
            {"What is the chemical symbol for gold?", "A. Au", "B. Ag", "C. Fe", "D. Hg", "A"},
            {"What is the powerhouse of the cell?", "A. Mitochondria", "B. Nucleus", "C. Ribosome", "D. Endoplasmic reticulum", "A"},
            {"Which planet is known as the 'Evening Star'?", "A. Venus", "B. Mars", "C. Jupiter", "D. Saturn", "A"},
            {"What is the largest mammal in the world?", "A. Elephant", "B. Blue Whale", "C. Giraffe", "D. Hippopotamus", "B"}
            // Add more questions in a similar format
    };

    private int score = 0;
    private int currentQuestion = 0;
    private Timer timer;

    public void displayQuestion(int questionNumber) {
        System.out.println("Question " + (questionNumber + 1) + ": " + questions[questionNumber][0]);
        for (int i = 1; i < questions[questionNumber].length - 1; i++) {
            System.out.println(questions[questionNumber][i]);
        }
    }

    public void checkAnswer(String userAnswer) {
        if (userAnswer.equalsIgnoreCase(questions[currentQuestion][questions[currentQuestion].length - 1])) {
            score++;
        }
    }

    public void startQuiz() {
        System.out.println("Welcome to the Quiz!\n");
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("\nTime's up! Moving to the next question...");
                currentQuestion++;
                if (currentQuestion < questions.length) {
                    displayQuestion(currentQuestion);
                } else {
                    endQuiz();
                }
            }
        }, 15000); // 15 seconds timer

        displayQuestion(currentQuestion);

        Scanner scanner = new Scanner(System.in);
        String userAnswer = scanner.nextLine().toUpperCase();

        // Clear screen - for a new "page" effect
        for (int i = 0; i < 50; ++i) System.out.println();

        checkAnswer(userAnswer);

        timer.cancel();
        timer.purge();

        currentQuestion++;
        if (currentQuestion < questions.length) {
            startQuiz();
        } else {
            endQuiz();
        }
    }

    public void endQuiz() {
        System.out.println("\nQuiz Completed!\nYour Score: " + score + "/" + questions.length);
    }

    public void refreshQuiz() {
        // Resetting quiz variables for a fresh start
        score = 0;
        currentQuestion = 0;
        timer = null;

        // Shuffle questions for a new order
        Random rand = new Random();
        for (int i = questions.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            String[] temp = questions[i];
            questions[i] = questions[j];
            questions[j] = temp;
        }

        // Start the refreshed quiz
        startQuiz();
    }

    public static void main(String[] args) {
        RefreshableQuiz quiz = new RefreshableQuiz();
        quiz.startQuiz();
    }
}
