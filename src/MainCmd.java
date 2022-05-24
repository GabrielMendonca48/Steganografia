import java.io.File;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;
import java.util.Scanner;

public class MainCmd {
    private static int keyLength = 200;


    public static void printMenu(){
        System.out.println("*****************");
        System.out.println("* 0) Esci       *");
        System.out.println("* 1) Cifra      *");
        System.out.println("* 2) Decifra    *");
        System.out.println("* 3) Opzioni    *");
        System.out.println("*****************");
        System.out.print("Scegli opzione : ");
    }
    public static void clearScreen(){
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int option;
        do{
            printMenu();
            option = scanner.nextInt();

            switch (option){
                case 1:
                    String pathToMP3 = null;
                    String pathToFileToHide= null;
                    scanner.nextLine();
                    //for a maximum of 3 time require a valid file
                    for (int i = 0; i < 3; i++) {
                        System.out.println("Inserisci il percorso del file mp3: ");
                        pathToMP3 = scanner.nextLine();
                        if(verifyPath(pathToMP3))
                            System.out.println("Percorso non esistente");
                        else
                            break;
                    }
                    //for a maximum of 3 time require a valid file
                    for (int i = 0; i < 3; i++) {
                        System.out.println("Inserisci il percorso da nascondere: ");
                        pathToFileToHide = scanner.nextLine();
                        if(verifyPath(pathToFileToHide))
                            System.out.println("Percorso non esistente");
                        else
                            break;
                    }

                    if(pathToMP3 != null && pathToFileToHide != null)
                        cifra(pathToMP3, pathToFileToHide);

                    System.out.println(generateKey());

                    break;
                case 2:
                    pathToMP3 = null;
                    //for a maximum of 3 time require a valid file
                    for (int i = 0; i < 3; i++) {
                        System.out.println("Inserisci il percorso del file mp3: ");
                        pathToMP3 = scanner.nextLine();
                        if(verifyPath(pathToMP3))
                            System.out.println("Percorso non esistente");
                        else
                            break;
                    }
                    if(pathToMP3 != null)
                        decifra(pathToMP3);
                    break;

                case 3:

                    break;
            }

            clearScreen();
        }while (option!=0);

        scanner.close();
    }

    public static boolean verifyPath(String path){
        return !Files.exists(Paths.get(path));
    }

    public static void cifra(String pathToMp3, String pathToFile){

    }

    public static void decifra(String pathToMp3){

    }

    public static String generateKey(){
        byte[] array = new byte[keyLength];
        new Random().nextBytes(array);
        return new String(array, StandardCharsets.UTF_8);

    }
}
