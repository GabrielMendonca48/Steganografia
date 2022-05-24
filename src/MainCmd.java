import java.util.Scanner;

public class MainCmd {

    public static void printMenu(){
        System.out.println("**************************");
        System.out.println("* 0) Esci");
        System.out.println("* 1) Cifra");
        System.out.println("* 2) Decifra");
        System.out.println("* 3) Boh");
        System.out.print("Scegli opzione : ");
    }
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int option;
        do{
            printMenu();
            option = scanner.nextInt();
        }while (option!=0);

        scanner.close();
    }
}
