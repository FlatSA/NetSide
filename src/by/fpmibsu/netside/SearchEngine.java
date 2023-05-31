package src.by.fpmibsu.netside;

import src.by.fpmibsu.netside.entity.Question;

import java.util.List;

public class SearchEngine {
    private List<Question> questionList;
    private String query;

    public SearchEngine(List<Question> questionList, String string) {
        this.questionList = questionList;
        this.query = string;
    }

    public Question getClosestQuestion() {
        Question closestQuestion = questionList.get(0);
        int minDistance = Integer.MAX_VALUE;

        for(Question question : questionList) {
            String questionMessage = question.getMessage().replaceAll("[\\p{Punct}\\s]", "");
            int distance = calculate(query, questionMessage);
            if(distance < minDistance) {
                minDistance = distance;
                closestQuestion = question;
            }
        }

        return closestQuestion;
    }

    static int calculate(String x, String y) {
        if(x.isEmpty() || y.isEmpty()) return Integer.MAX_VALUE;
        int[][] dp = new int[x.length() + 1][y.length() + 1];

        for (int i = 0; i <= x.length(); i++) {
            for (int j = 0; j <= y.length(); j++) {
                if (i == 0) {
                    dp[i][j] = j;
                }
                else if (j == 0) {
                    dp[i][j] = i;
                }
                else {
                    dp[i][j] = min(dp[i - 1][j - 1]
                                    + costOfSubstitution(x.charAt(i - 1), y.charAt(j - 1)),
                            dp[i - 1][j] + 1,
                            dp[i][j - 1] + 1);
                }
            }
        }

        return dp[x.length()][y.length()];
    }

    public static int min(int... numbers) {
        if (numbers.length == 0) {
            throw new IllegalArgumentException("No numbers provided.");
        }

        int min = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
            }
        }

        return min;
    }

    public static int costOfSubstitution(char a, char b) {
        return a == b ? 0 : 1;
    }
}
