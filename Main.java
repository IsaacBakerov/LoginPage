import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static List<UserProperties> propertiesList = new ArrayList<UserProperties>();

    public static void main(String[] args) {

        while (true) {
            System.out.println("""
                    \n
                    What would you like to do?
                    1. Register
                    2. Login
                    3. Forgot password
                    4. Exit
                    """);
            int input = 0;
            try {
                input = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e){
                System.out.println("You entered string. Only integer allowed...");
            }
            if (input == 1) {
                RegisterUser.registerUser();
            } else if (input == 2) {
                LoginUser.loginUser();
            } else if (input == 3) {
                RecoverPassword.recoverPassword();
            } else if (input == 4) {
                System.exit(0);
            } else {
                System.out.println("Try again");
            }
        }
    }


}