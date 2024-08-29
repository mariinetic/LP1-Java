import java.util.Scanner;

class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HelloKitty kitty = new HelloKitty();
        Keroppi keroppi = new Keroppi();
        BadtzMaru badtz = new BadtzMaru();

        int option;
        do {
            System.out.println("Choose a character:");
            System.out.println("1. Hello Kitty");
            System.out.println("2. Keroppi");
            System.out.println("3. Badtz-Maru");
            System.out.println("4. Exit");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    kitty.greet();
                    kitty.showFavoriteFood();
                    kitty.describePersonality();
                    break;
                case 2:
                    keroppi.greet();
                    keroppi.showFavoriteActivity();
                    keroppi.describePersonality();
                    break;
                case 3:
                    badtz.greet();
                    badtz.showHobby();
                    badtz.describePersonality();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        } while (option != 4);

        scanner.close();
    }
}

class Keroppi {
    String name = "Keroppi";
    String color = "Green";
    String favoriteActivity = "Swimming";

    void greet() {
        System.out.println("Hi! I'm " + name + ".");
    }

    void showFavoriteActivity() {
        System.out.println("My favorite activity is " + favoriteActivity + ".");
    }

    void describePersonality() {
        System.out.println("I'm energetic and love adventures.");
    }
}

class BadtzMaru {
    String name = "Badtz-Maru";
    String color = "Black";
    String hobby = "Being mischievous";

    void greet() {
        System.out.println("Hey! I'm " + name + ".");
    }

    void showHobby() {
        System.out.println("My hobby is " + hobby + ".");
    }

    void describePersonality() {
        System.out.println("I'm cool and a bit rebellious.");
    }
}
