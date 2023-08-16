import java.util.Arrays;
import java.util.Scanner;;

public class CliAssignment1 {
    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        
        final String CLEAR = "\033[H\033[2J";
        final String LIGHT_BLUE_COLOR_BOLD = "\033[36;1m";
        final String PURPLE_COLOR_BOLD = "\033[35;1m";
        final String GREEN_COLOR_BOLD = "\033[32;1m";
        final String WHITE_COLOR_BOLD = "\033[37;1m";
        final String BLUE_COLOR_BOLD = "\033[34;1m";
        final String YELLOW_COLOR_BOLD = "\033[33;1m";
        final String RED_COLOR_BOLD = "\033[31;1m";
        
        final String RESET = "\033[0m";

        final String DASHBOARD = "Smart Banking System";
        final String CREATE_ACCOUNT = "Create New Account";
        final String DEPOSITE = "Deposit";
        final String WITHDRAWAL = "Withdrawal";
        final String TRANSFER = "Transfer";
        final String PRINT_STATEMENT = "Print Statement";
        final String DELETE_ACOOUNT= "Delete Account";
        String screen = DASHBOARD;
        int[] idArray = new int[0];
        String[] nameArray = new String[0];
        int idnum;
        boolean valid=true;

        do{
            String customerID;
            final String APP_TITLE = String.format("%s%s%s", GREEN_COLOR_BOLD, screen, RESET);

            System.out.println(CLEAR);
            System.out.printf("%s%s%s \n", GREEN_COLOR_BOLD, "-".repeat(100), RESET);
            System.out.printf("%s%s%s \n", " ".repeat((100 - APP_TITLE.length()) / 2), APP_TITLE," ".repeat((100 - APP_TITLE.length()) / 2));
            System.out.printf("%s%s%s \n\n",GREEN_COLOR_BOLD, "-".repeat(100), RESET);
            switch (screen) {
                case DASHBOARD: {

                    System.out.printf("%s%s%s \n", BLUE_COLOR_BOLD, "[1].Create New Account", RESET);
                    System.out.printf("%s%s%s \n", BLUE_COLOR_BOLD, "[2].Deposit", RESET);
                    System.out.printf("%s%s%s \n", BLUE_COLOR_BOLD, "[3].Withdrawal", RESET);
                    System.out.printf("%s%s%s \n", BLUE_COLOR_BOLD, "[4].Transfer", RESET);
                    System.out.printf("%s%s%s \n", BLUE_COLOR_BOLD, "[5].Print Statement", RESET);
                    System.out.printf("%s%s%s \n", BLUE_COLOR_BOLD, "[6].Delete Account", RESET);
                    System.out.printf("%s%s%s \n\n", BLUE_COLOR_BOLD, "[7].Exit", RESET);

                    System.out.printf("%s%s%s \n", WHITE_COLOR_BOLD, "Enter an option to continue : ", RESET);

                    int option = scanner.nextInt();
                    scanner.nextLine();
                    switch (option) {
                        case 1: {
                            screen = CREATE_ACCOUNT;
                            break;
                        }
                        case 2: {
                            screen = DEPOSITE;
                            break;
                        }
                        case 3: {
                            screen = WITHDRAWAL;
                            break;
                        }
                        case 4: {
                            screen = TRANSFER;
                            break;
                        }
                        case 5: {
                            screen = PRINT_STATEMENT;
                            break;
                        }
                        case 6: {
                            screen = DELETE_ACOOUNT;
                            break;
                        }
                        case 7: {
                            System.exit(0);
                            break;
                        }
                        default:
                            continue;

                    }
                    break;

                }
                
            case CREATE_ACCOUNT: {
                idnum = idArray.length;
                int[] newIdArray = new int[idArray.length + 1];
                String[] newNameArray = new String[nameArray.length+1];
                valid = false;
                System.out.printf("%sID : %s%sSDB-%05d %s \n", WHITE_COLOR_BOLD, RESET, LIGHT_BLUE_COLOR_BOLD,
                        (idArray.length + 1), RESET);
                for (int i = 0; i < idnum; i++) {
                    newIdArray[i] = idArray[i];

                }
                newIdArray[idArray.length ] = idnum;
                idArray = newIdArray;
                do {

                    System.out.printf("%sName : %s ", WHITE_COLOR_BOLD, RESET);
                    String name = scanner.nextLine().strip();
                    if (name.isBlank()) {
                        System.out.printf("%sName can't be empty%s\n", RED_COLOR_BOLD, RESET);
                        valid = true;
                    }
                    for (int index = 0; index < name.length(); index++) {
                        if (!(Character.isLetter(name.charAt(index)) || Character.isSpaceChar(name.charAt(index)))) {
                            System.out.printf("%sInvalid Name%s\n", RED_COLOR_BOLD, RESET);
                            valid = true;
                            break;
                        }
                    }
                    for (int i = 0; i < idnum; i++) {
                        newNameArray[i] = nameArray[i];

                        }
                    newNameArray[nameArray.length ] = name;
                    nameArray=newNameArray;

                } while (valid);

            }
                
            }

        } while (valid);
    }

}
