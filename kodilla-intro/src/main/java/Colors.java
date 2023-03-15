public class Colors {
    public void displayFullColorName() {
        String userSelected = UserDialogs.getUserColorSelection();

        switch (userSelected) {
            case "White":
                System.out.println("White");
                break;
            case "Red":
                System.out.println("Red");
                break;
            case "Blue":
                System.out.println("Blue");
                break;
            case "Yellow":
                System.out.println("Yellow");
                break;
        }
    }
}
