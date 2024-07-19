package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Fetch fetch = new Fetch();
        String apiUrl = "https://api.cuvora.com/car/partner/cricket-data";
        String apiKey = "test-creds@2320";

        try {
            String response = fetch.run(apiUrl, apiKey);
            JsonConverter converter = new JsonConverter(response);
            ApiResponse apiResponse = converter.convert();
            List<Match> matches = apiResponse.getData();

            String highestScoringTeam = "";
            int highestScore = 0;
            int count300PlusMatches = 0;

            for (Match match : matches) {
                int t1Score = parseScore(match.getT1s());
                int t2Score = parseScore(match.getT2s());

                // Find the highest score in one innings
                if (t1Score > highestScore) {
                    highestScore = t1Score;
                    highestScoringTeam = match.getT1();
                }
                if (t2Score > highestScore) {
                    highestScore = t2Score;
                    highestScoringTeam = match.getT2();
                }

                // Count matches with total score > 300
                if ((t1Score + t2Score) > 300) {
                    count300PlusMatches++;
                }
            }
            //result
            String result = String.format(
                    "Highest Score: Highest Score and Team Name is: %d by %s\n" +
                            "Number Of Matches with total 300 Plus Score: %d",
                    highestScore, highestScoringTeam, count300PlusMatches
            );

            System.out.println(result);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int parseScore(String score) {
        if (score == null || score.isEmpty()) {
            return 0;
        }
        String[] parts = score.split("/");
        try {
            return Integer.parseInt(parts[0]);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
