public class RegisterUser {
    public static void registerUser() {
        String id = checkAndAddUsername();
        String email = checkAndAddEmail();
        String password = checkAndAddPassword();

        Main.propertiesList.add(new UserProperties(id, password, email));

    }

    public static String checkAndAddUsername() {
        while (true) {
            System.out.print("Enter a username: ");
            String id = Main.sc.nextLine();
            boolean nameExists = false;

            for (UserProperties property: Main.propertiesList) {
                if (property.getId().equals(id)) {
                    nameExists = true;
                    break;
                }
            }

            if (nameExists) {
                System.out.println("Username exists, try again - ");
            } else {
                return id;
            }
        }
    }

    public static String checkAndAddPassword() {
        while (true) {
            System.out.print("Enter a password (8 symbols, one uppercase): ");
            StringBuilder password = new StringBuilder(Main.sc.nextLine());
            boolean haveUppercase = false;
            boolean moreThanEight = false;

            if (password.length() >= 8) {
                moreThanEight = true;
            }

            for (int i = 0; i < password.length(); i++) {
                if (Character.isUpperCase(password.charAt(i))) {
                    haveUppercase = true;
                    break;
                }
            }

            if (haveUppercase && moreThanEight) {
                return password.toString();
            } else if (!haveUppercase && moreThanEight) {
                System.out.println("Password doesn't include an uppercase letter - ");
            } else if (haveUppercase && !moreThanEight) {
                System.out.println("Password is less than 8 symbols - ");
            } else {
                System.out.println("Password is wrong, try again - ");
            }
        }
    }

    public static String checkAndAddEmail() {
        while (true) {
            System.out.print("Enter your email: ");
            StringBuilder email = new StringBuilder(Main.sc.nextLine().toLowerCase());
            boolean hasAt = false;

            for (int i = 0; i < email.length(); i++) {
                if (email.charAt(i) == '@') {
                    hasAt = true;
                    break;
                }
            }

            if (!hasAt) {
                System.out.println("It is not an email type, try again - ");
            } else {
                boolean emailExists = false;
                for (UserProperties property : Main.propertiesList) {
                    if (property.getEmail().contentEquals(email)) {
                        emailExists = true;
                        break;
                    }
                }

                if (emailExists) {
                    System.out.println("This email is already taken, try another - ");
                } else {
                    return email.toString();
                }
            }
        }
    }
}
