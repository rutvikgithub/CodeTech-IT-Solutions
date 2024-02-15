package InternshipTasks;
import java.util.*;

public class QuizApplication {
    private static final Map<String, String> questionsAndAnswers = new HashMap<>();

    static {
        // Populate questions and answers
        questionsAndAnswers.put("Who is known as the 'Master Blaster' in cricket?", "Sachin Tendulkar");
        questionsAndAnswers.put("Which country won the ICC Cricket World Cup 2019?", "England");
        questionsAndAnswers.put("Who has scored the most runs in Test cricket?", "Sachin Tendulkar");
        questionsAndAnswers.put("What is the highest individual score by a batsman in Test cricket?", "Brian Lara");
        questionsAndAnswers.put("Which bowler has taken the most wickets in ODI cricket?", "Muttiah Muralitharan");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int score = 0;

        System.out.println("Welcome to the Cricket Quiz!");
        System.out.println("Answer the following questions:");

        for (Map.Entry<String, String> entry : questionsAndAnswers.entrySet()) {
            System.out.println(entry.getKey());
            String userAnswer = scanner.nextLine();

            if (userAnswer.equalsIgnoreCase(entry.getValue())) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect. The correct answer is: " + entry.getValue());
            }
        }

        System.out.println("Quiz complete! Your score is: " + score + "/" + questionsAndAnswers.size());
    }
}
