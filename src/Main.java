import computer.Processor;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Processor processor = new Processor();
        processor.initialize();
        processor.intializeIds();
        processor.initializeMemory();
        System.out.println("Initialization successful");

        Scanner scanner = new Scanner(System.in);
        int typeOfCase;
        String a;
        int b;
        System.out.println("Cloned mouse ID "+processor.newMouse.id+"Cloned mouse Status :"+ processor.newMouse.status);
        System.out.println("What did you do?");
        System.out.println("1- Right Click 2- Left Click  3- Middle wheel 4- Print memory values 5- Press keys on keyboard 6- USB handling 7- What devices are connected");
        while ((typeOfCase = scanner.nextInt()) != 0) {
            switch (typeOfCase) {
                case 1:
                    processor.clicked(typeOfCase);
                    processor.clicked();
                    break;
                case 2:
                    processor.clicked(typeOfCase);
                    processor.clicked();
                    break;
                case 3:
                    processor.clicked(typeOfCase);
                    processor.clicked();
                    break;
                case 4:
                    processor.printMemory();
                    break;
                case 5:
                    System.out.println("Write what you want");
                    a = scanner.next();
                    processor.pressKeys(a);
                    processor.isKeyboard();
                    break;
                case 6:
                    processor.usbInfo();
                    System.out.println("If you want to transfer to USB type positive number. IF remove type negative number");
                    b= scanner.nextInt();
                    processor.transfer(b);
                    break;
                case 7:
                    processor.connected();
                    break;
                default:
                    System.out.println("No action found");
                    break;
            }
        }
    }
}
