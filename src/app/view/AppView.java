package app.view;

import java.util.Scanner;

public class AppView {

    private final Scanner SCANNER = new Scanner(System.in);

    public String selectAction(){
        System.out.println("""
                ----------------------------------
                Select an action:
                1 - create and write data to file
                2 - read data from file
                3 - delete file by filename
                4 - rename file
                0 - exit
                ----------------------------------
                """);
        return SCANNER.nextLine();
    }

    public String getFilename(){
        System.out.println("Input filename: ");
        return SCANNER.nextLine();
    }

    public String getNewFilename(){
        System.out.println("Input new filename: ");
        return SCANNER.nextLine();
    }

    public String getContent(){
        System.out.println("Enter you content: ");
        return SCANNER.nextLine();
    }

    public void getOutput(String output) {
        System.out.println(output);
    }

}
