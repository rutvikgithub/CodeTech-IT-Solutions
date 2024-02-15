package InternshipTasks;
import java.util.*;

public class QuizApplication {
    // Static map to hold questions as keys and correct answers as values
    private static final Map<String, String> questionsAndAnswers = new HashMap<>();

    static {
        // Populate questions and answers in the static block
        questionsAndAnswers.put("Who is known as the 'Master Blaster' in cricket?", "Sachin Tendulkar");
        questionsAndAnswers.put("Which country won the ICC Cricket World Cup 2019?", "England");
        questionsAndAnswers.put("Who has scored the most runs in Test cricket?", "Sachin Tendulkar");
        questionsAndAnswers.put("What is the highest individual score by a batsman in Test cricket?", "Brian Lara");
        questionsAndAnswers.put("Which bowler has taken the most wickets in ODI cricket?", "Muttiah Muralitharan");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int score = 0; // Variable to hold the user's score

        System.out.println("Welcome to the Cricket Quiz!");
        System.out.println("Answer the following questions:");

        // Loop through each question in the map
        for (Map.Entry<String, String> entry : questionsAndAnswers.entrySet()) {
            System.out.println(entry.getKey()); // Print the question
            String userAnswer = scanner.nextLine(); // Get user's answer

            // Check if the user's answer matches the correct answer (case-insensitive)
            if (userAnswer.equalsIgnoreCase(entry.getValue())) {
                System.out.println("Correct!"); // Print correct if the answer is right
                score++; // Increment the score
            } else {
                System.out.println("Incorrect. The correct answer is: " + entry.getValue()); // Print correct answer if the user's answer is wrong
            }
        }

        // Print the final score after all questions have been asked
        System.out.println("Quiz complete! Your score is: " + score + "/" + questionsAndAnswers.size());
    }
}
