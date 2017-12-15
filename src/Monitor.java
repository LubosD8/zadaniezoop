import computer.*;

import java.util.Scanner;

public class Monitor {
    public static void main(String[] args) {
        Processor processor = new Processor();
        Memory memory = new Memory();
        processor.memorySize(memory);
        processor.memoryInit();
        processor.initIds();
        processor.initializeMemory();
        System.out.println("Initialization successful");

        Scanner scanner = new Scanner(System.in);
        int typeOfCase;
        int b;
        System.out.println("What do you want to do?");
        System.out.println("1- Right Click 2- Left Click  3- Middle wheel 4- Print memory values 5- Press keys on keyboard ");
        System.out.println("6- USB handling 7- What devices are connected 8- Clone mouse to newMouse 9- Disconnect device 10- Connect known device");
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
                    String a = scanner.next();
                    processor.pressKeys(a);
                    processor.isKeyboard();
                    break;
                case 6:
                    processor.usbInfo();
                    System.out.println("If you want to transfer to USB type positive number. IF remove type negative number");
                    b = scanner.nextInt();
                    processor.transfer(b);
                    break;
                case 7:
                    processor.deviceConnected();
                    break;
                case 8:
                    System.out.println("Original mouse ID " + processor.mouse.id + " Original mouse Status :" + processor.mouse.status);
                    System.out.println("Cloned mouse ID " + processor.newMouse.id + " Cloned mouse Status :" + processor.newMouse.status);
                    break;
                case 9:
                    System.out.println("ID 0 = USB, ID 1 = Mouse, ID 2 = Keyboard, ID 3 = Webcam");
                    System.out.println("Type ID of device you want to disconnect");
                    b = scanner.nextInt();
                    processor.disconnect(b);
                    break;
                case 10:
                    System.out.println("ID 0 = USB, ID 1 = Mouse, ID 2 = Keyboard, ID 3 = Webcam");
                    System.out.println("Type ID of device you want to disconnect");
                    b = scanner.nextInt();
                    processor.connectDevice(b);
                    break;
                default:
                    System.out.println("No action found");
                    break;
            }
            System.out.println("\n1- Right Click 2- Left Click  3- Middle wheel 4- Print memory values 5- Press keys on keyboard");
            System.out.println("6- USB handling 7- What devices are connected 8- Clone mouse to newMouse 9- Disconnect device 10- Connect known device");
        }
    }
}
