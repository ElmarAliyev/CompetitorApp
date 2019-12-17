package util;

import java.util.Scanner;

public class MenuUtil {

    public static int showMenu() {
        while (true) {
            System.out.println("Please select menu:");
            String str = "1-Yarışanları daxil et\n" +
                    "2-Yarışa başla\n" +
                    "3-Xalını öyrən\n" +
                    "4-İştirakçıların sayını artır\n" +
                    "5-Yarışanlara bax\n" +
                    "6-LogOut\n";
            System.out.println(str);
            Scanner sc = new Scanner(System.in);
            int selectedMenu = sc.nextInt();
            if (selectedMenu > 0 && selectedMenu < 7)
                return selectedMenu;
            else {
                System.out.println("Invalid menu selected");
                {
                    return -1;
                }
            }
        }
    }

    public static int showMenuInfinite() {
        while (true) {
            int selectedMenu = showMenu();


            if (selectedMenu == 1) {
                CompetitionUtil.registrCompetitorsAndShowInfo();
            } else if (selectedMenu == 2) {
                CompetitionUtil.startCompetition();
            } else if (selectedMenu == 3) {
                CompetitionUtil.showPoint();
            } else if (selectedMenu == 4) {
                CompetitionUtil.increaseCompetitors();
            } else if (selectedMenu == 5) {
                CompetitionUtil.printCompetitors();
            } else if (selectedMenu == 6) {
                UserUtil.requiredInputsAndLogin(3, true);
            }
        }
    }
}
