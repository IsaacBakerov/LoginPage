public class LoginPage {
    public static void loginPage(int currentPropIndex) {
        while (true) {
            System.out.println("""
                    What would you like to do? :
                    1. Change username
                    2. Change password
                    3. Show bio
                    4. Update your bio
                    5. Log out
                    """);
            int input = 0;
            try {
                input = Integer.parseInt(Main.sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("You entered string. Only integer allowed...");
            }
            if (input == 1) {
                changeUsername(currentPropIndex);
            } else if (input == 2) {
                changePassword(currentPropIndex);
            } else if (input == 3) {
                showBio();
            } else if (input == 4) {
                updateBio(currentPropIndex);
            } else if (input == 5) {
                System.out.println("LOGGING OUT");
                break;
            } else {
                System.out.println("Try again");
            }
        }
    }

    public static void changeUsername(int currentPropIndex) {
        while(true) {
            System.out.print("\nEnter new Username: ");
            String newUsername = Main.sc.nextLine();
            boolean alreadyExist = false;

            if (Main.propertiesList.get(currentPropIndex).getId().equals(newUsername)) {
                System.out.println("You can't use the same username. Try again - ");
            } else {
                for (UserProperties property: Main.propertiesList) {
                    if (property.getId().equals(newUsername)) {
                        alreadyExist = true;
                        break;
                    }
                }

                if (alreadyExist) {
                    System.out.println("This username is already taken by another user. Try again - ");
                } else {
                    Main.propertiesList.get(currentPropIndex).setId(newUsername);
                    System.out.println("Success. Your username is changed to: " + newUsername);
                    break;
                }
            }
        }
    }

    public static void changePassword(int currentPropIndex) {
        while (true) {
            System.out.println("\nEnter a password (Use one uppercase letter, at least 8 symbols): ");
            StringBuilder newPassword = new StringBuilder(Main.sc.nextLine());
            boolean alreadyExist = false;

            if (Main.propertiesList.get(currentPropIndex).getPassword().equals(newPassword.toString())) {
                System.out.println("You can't enter the same password. Try again - ");
            } else {
                boolean haveUppercase = false;
                boolean moreThanEight = false;

                if (newPassword.length() >= 8) {
                    moreThanEight = true;
                }

                for (int i = 0; i < newPassword.length(); i++) {
                    if (Character.isUpperCase(newPassword.charAt(i))) {
                        haveUppercase = true;
                        break;
                    }
                }

                if (haveUppercase && moreThanEight) {
                    Main.propertiesList.get(currentPropIndex).setPassword(newPassword.toString());
                    System.out.println("Your password has been updated.\n");
                    break;
                } else if (!haveUppercase && moreThanEight) {
                    System.out.println("New password doesn't include an uppercase letter, try again - ");
                } else if (haveUppercase && !moreThanEight) {
                    System.out.println("New password is less than 8 symbols, try again - ");
                } else {
                    System.out.println("New password is wrong, try again - ");
                }
            }
        }
    }

    public static void updateBio(int currentPropIndex) {
        System.out.println("Enter what you want to be in your bio: ");
        String yourBio = Main.sc.nextLine();
        Main.propertiesList.get(currentPropIndex).setBio(yourBio);
        System.out.println("Your bio has been updated.");
    }

    public static void showBio() {
        while (true) {
            System.out.println("Who's bio you want to see? Enter username: ");
            String inputUsername = Main.sc.nextLine();
            boolean userExist = false;

            for (UserProperties property: Main.propertiesList) {
                if (property.getId().equals(inputUsername)) {
                    userExist = true;
                    System.out.println("\n" + property.getId() + "'s bio: ");
                    System.out.println("\"" + property.getBio() + "\"\n");
                    break;
                }
            }

            if (!userExist) {
                System.out.println("No such user found, try again - ");
            } else {
                break;
            }
        }
    }
}
