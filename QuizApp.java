
import java.util.*;

class Question {

    String questionText;
    List<String> options;
    int correctAnswer; // index of correct option (0-based)

    public Question(String questionText, List<String> options, int correctAnswer) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public void displayQuestion() {
        System.out.println("\n" + questionText);
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + ". " + options.get(i));
        }
    }

    public boolean checkAnswer(int userChoice) {
        return (userChoice - 1) == correctAnswer;
    }
}

public class QuizApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create a list of questions
        List<Question> quizQuestions = new ArrayList<>();
        quizQuestions.add(new Question("What is the capital of India?",
                Arrays.asList("Delhi", "Mumbai", "Kolkata", "Chennai"), 0));

        quizQuestions.add(new Question("Which language is platform-independent?",
                Arrays.asList("C", "C++", "Java", "Python"), 2));

        quizQuestions.add(new Question("Which keyword is used to inherit a class in Java?",
                Arrays.asList("implement", "inherit", "extends", "using"), 2));

        int score = 0;

        System.out.println("=== Welcome to the Quiz Application ===");

        // Ask questions
        for (Question q : quizQuestions) {
            q.displayQuestion();
            System.out.print("Enter your answer (1-" + q.options.size() + "): ");
            int answer = sc.nextInt();

            if (q.checkAnswer(answer)) {
                System.out.println(" Correct!");
                score++;
            } else {
                System.out.println(" Wrong!");
            }
        }

        // Display results
        System.out.println("\n=== Quiz Finished ===");
        System.out.println("Your Score: " + score + " / " + quizQuestions.size());

        if (score == quizQuestions.size()) {
            System.out.println(" Excellent! You got all correct.");
        } else if (score >= quizQuestions.size() / 2) {
            System.out.println(" Good job, keep practicing!");
        } else {
            System.out.println(" Keep learning and try again.");
        }

        sc.close();
    }
}
