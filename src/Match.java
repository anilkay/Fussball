import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.security.SecureRandom;

public class Match {
    private final int RANDOM_BOUND=50;
    private final int TOUR_NUMBER=180;
    private final int SECONDARY_BOUND=500;
    private int MatchId;
    private Team HomeTeam;
    private Team AwayTeam;
    private int HomeGoal;
    private int AwayGoal;

    public Match(Team homeTeam, Team awayTeam) {
        HomeTeam = homeTeam;
        AwayTeam = awayTeam;
        HomeGoal = 0;
        AwayGoal = 0;
    }

    public void HandleMatch() throws Exception {
        SecureRandom whatIsGoing = new SecureRandom();
        int tour = 0;
        while (tour++ < TOUR_NUMBER) {
            int tourVariable = whatIsGoing.nextInt(RANDOM_BOUND);
            decisionMaker(tourVariable, whatIsGoing);
        }
        System.out.println("Match is over");
        System.out.printf(" %d - %d", HomeGoal, AwayGoal);
    }

    public static void main(String[] args) throws Exception {
        Team home = new Team("TeamHome");
        Team away = new Team("TeamAway");
        Match match = new Match(home, away);

        match.HandleMatch();
    }

    public void decisionMaker(int tourVariable, SecureRandom whatIsGoing) {

        if (tourVariable > 0 && tourVariable <= 3) {
            System.out.println("Foul in Middle area");
        } else if (tourVariable > 3 && tourVariable <= 6) {
            System.out.println("Foul Free Kick in 40 metre");
        } else if (tourVariable > 6 && tourVariable <= 10) {
            System.out.println("Throw in ");
        } else if (tourVariable > 10 && tourVariable <= 16) {
            System.out.println("Defence Action");
        } else if (tourVariable == 17) {
            System.out.println("Penalty");
            if (tourVariable % 2 == 0) { //Home Penalty
                int penaltyVar = whatIsGoing.nextInt(SECONDARY_BOUND);
                if (penaltyVar % 2 == 0) {
                    System.out.println("Goal");
                    HomeGoal++;
                } else {
                    System.out.println("Missed penalty");
                }
            } else { //Away Penalty
                int penaltyVar = whatIsGoing.nextInt(SECONDARY_BOUND);
                if (penaltyVar % 2 == 0) {
                    System.out.println("Goal");
                    AwayGoal++;
                } else {
                    System.out.println("Missed penalty");
                }
            }
        } else if (tourVariable > 17 & tourVariable <= 21) {
            System.out.println("Hard Faul");
            System.out.println("Home Yellow Card");

        } else if (tourVariable > 21 && tourVariable <= 25) {
            System.out.println("Hard Faul");
            System.out.println("Away Yellow Card");
        } else if (tourVariable == 26) { //Red Card
            System.out.println("Unprofessional Behavior");
            System.out.println("Home Red Card");
        } else if (tourVariable == 27) {  //Read Card
            System.out.println("Unprofessional Behavior");
            System.out.println("Away Red Card");
        } else if (tourVariable > 27 && tourVariable <= 32) {
            System.out.println("Corner kick");
        } else if (tourVariable > 32 && tourVariable <= 38) {
            System.out.println(" ");
        } else if (tourVariable > 38 && tourVariable <= 49) {
            System.out.println("Midfield Actions");
        } else {
            System.out.println("Goal Goal Goal !!!!!!");
            if (tourVariable % 2 == 0) {
                System.out.println(" Home Goal");
                HomeGoal++;
            } else {
                System.out.println(" Away Goal");
                AwayGoal++;
            }
        }
    }
}
