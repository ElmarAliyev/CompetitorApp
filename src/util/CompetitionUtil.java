package util;

import bean.Competitor;
import bean.User;
import config.Initialization;

import java.util.Random;
import java.util.Scanner;

public class CompetitionUtil {

    public static Competitor[] registrCompetitors() {
        Scanner sc = new Scanner(System.in);
        System.out.println("How many competitors will participate in competition?");
        int competitorCount = sc.nextInt();
        Competitor[] competitors = new Competitor[competitorCount];
        for (int i = 0; i < competitorCount; i++) {
            Competitor competitor = registrCompetitor();
            competitors[i] = competitor;
        }
        Initialization.config.setCompetitors(competitors);
        System.out.println("All competitors succesfully registered!");
        return competitors;
    }

    public static Competitor[] registrCompetitorsAndShowInfo() {
        Competitor[] competitors = registrCompetitors();
        CompetitionUtil.printCompetitors(competitors);
        return competitors;
    }

    public static Competitor registrCompetitor() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Competitor name:");
        String name = sc.nextLine();

        System.out.println("Competitor surname:");
        String surname = sc.nextLine();

        System.out.println("Competitor age:");
        int age = sc.nextInt();
        Competitor competitor = new Competitor(name, surname, age);
        return competitor;
    }

    public static void printCompetitors(Competitor[] competitors) {
        if (competitors == null || competitors.length == 0) {
            return;
        }
        for (int i = 0; i < competitors.length; i++) {
            Competitor competitor = competitors[i];
            System.out.println(competitor);
        }
    }

    public static void printCompetitors() {
        printCompetitors(Initialization.config.getCompetitor());
    }

    public static boolean startCompetition() {
        int winner = chooseWinner(Initialization.config.getCompetitor().length);
        System.out.println("Guest winner?");
        Scanner sc = new Scanner(System.in);
        int guestWinner = sc.nextInt();
        if (guestWinner == winner) {
            CompetitionUtil.increasePoint();
            System.out.println("You won! You point increase to " + Initialization.config.getUser().getPoint());
            return true;
        } else {
            System.out.println("you failed");
            return false;
        }
    }

    public static void increasePoint() {
        User user = Initialization.config.getUser();
        user.setPoint(user.getPoint() + 10);
        Initialization.refreshConfig();
    }

    public static void showPoint() {
        System.out.println("You point: " + Initialization.config.getUser().getPoint());
    }

    public static void increaseCompetitors() {
        Competitor[] competitorsOld = Initialization.config.getCompetitor();
        Scanner sc = new Scanner(System.in);
        System.out.println("How many competitors you want to append?");
        int increaseCount = sc.nextInt();//3
        Competitor[] competitorsNew = new Competitor[competitorsOld.length + increaseCount];
        for (int i = 0; i < competitorsOld.length; i++) {
            competitorsNew[i] = competitorsOld[i];
        }
        for (int i = competitorsOld.length; i < competitorsOld.length + increaseCount; i++) {
            competitorsNew[i] = registrCompetitor();
        }
        Initialization.config.setCompetitors(competitorsNew);


    }

    public static int chooseWinner(int number) {
        Random random = new Random();
        int selectNumber = random.nextInt(number);
        int result = ((selectNumber - 1) + 1) + 1;
        return result;
    }
}
