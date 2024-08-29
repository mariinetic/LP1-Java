class HelloKitty {
    String name = "Hello Kitty";
    String color = "White";
    String favoriteFood = "Apple pie";

    void greet() {
        System.out.println("Hello! I'm " + name + ".");
    }

    void showFavoriteFood() {
        System.out.println("My favorite food is " + favoriteFood + ".");
    }

    void describePersonality() {
        System.out.println("I'm friendly and love to help others.");
    }
}

class TestaClasse {
    public static void main(String[] args) {
        HelloKitty kitty = new HelloKitty();
        kitty.greet();
        kitty.showFavoriteFood();

        // Implement menu loop here as required
    }
}