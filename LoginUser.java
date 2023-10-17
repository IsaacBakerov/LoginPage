public class LoginUser {
    public static void loginUser() {
        checkAndGetUsername();
    }

    public static void checkAndGetUsername() {
        while (true) {
            System.out.print("Enter your email: ");
            String inputEmail = Main.sc.nextLine();
            boolean emailExist = false;
            int currentPropIndex = 0;

            for (UserProperties property : Main.propertiesList) {
                if (property.getEmail().equals(inputEmail)) {
                    emailExist = true;
                    currentPropIndex = Main.propertiesList.indexOf(property);
                    break;
                }
            }

            if (emailExist) {
                System.out.print("Enter your password: ");
                String password = Main.sc.nextLine();
                if (Main.propertiesList.get(currentPropIndex).getPassword().equals(password)) {
                    System.out.println("\nWelcome, " + Main.propertiesList.get(currentPropIndex).getId() + ". Login successful.");
                    LoginPage.loginPage(currentPropIndex);
                    break;
                } else if (password.equals("exit")) {
                    break;
                } else {
                    System.out.println("Wrong password, try again - ");
                }
            } else if (inputEmail.equals("exit")) {
                break;
            } else {
                System.out.println("No user with such email, try again - ");
            }
        }
    }
}
