public class RecoverPassword {
    public static void recoverPassword() {
        while (true) {
            System.out.print("Enter your email: ");
            String email = Main.sc.nextLine();
            boolean emailExist = false;
            int currentPropIndex = 0;

            for (UserProperties property: Main.propertiesList) {
                if (property.getEmail().equals(email)) {
                    currentPropIndex = Main.propertiesList.indexOf(property);
                    emailExist = true;
                }
            }

            if (emailExist) {
                System.out.print("Enter your username: ");
                String username = Main.sc.nextLine();
                if (Main.propertiesList.get(currentPropIndex).getId().equals(username)) {
                    System.out.println("\nThis is your password: " + Main.propertiesList.get(currentPropIndex).getPassword());
                    break;
                } else {
                    System.out.println("Wrong. Try again - ");
                }
            } else if (email.equals("exit")) {
                break;
            } else {
                System.out.println("Such email doesn't exist. Try again -");
            }
        }
    }
}
