package computer;

import inputDevices.Devices;
import inputDevices.Keyboard;
import inputDevices.Mouse;
import inputDevices.Usb;

public class Processor {
    private Devices devices;
    private Mouse mouse;
    private Keyboard keyboard;
    private Usb usb;
    private Memory memory;

    //Initialize memory
    public void initialize() {
        devices = new Devices();
        memory = new Memory();
        mouse = new Mouse();
        keyboard = new Keyboard();
        usb = new Usb();
    }

    public void intializeIds() {
        mouse.id = 1;
        keyboard.id = 2;
        usb.id = 0;
    }

    public void initializeMemory() {
        memory.place[mouse.id][0] = mouse.id;
        memory.place[keyboard.id][0] = keyboard.id;
        memory.place[usb.id][0] = usb.id;
    }

    private void writeToMemory(int id, int status) {
        memory.place[id][1] = status;
    }

    public void printMemory() {
        System.out.println("ID 0 = USB, ID 1 = Mouse, ID 2 = Keyboard");
        for (int i = 0; i < 5; i++)
            System.out.println("ID in memory:" + memory.place[i][0] + "  Status: " + memory.place[i][1] + "\n");
    }

    // Mouse stuff
    public void clicked(int action) {
        mouse.status = action;
        writeToMemory(mouse.id, action);
    }

    public void clicked() {
        switch (mouse.status) {
            case 1:
                System.out.println("Right Click was pressed");
                break;
            case 2:
                System.out.println("Left Click was pressed");
                break;
            case 3:
                System.out.println("Middle button was pressed");
                break;
            default:
                System.out.println("No action found");
                break;
        }
    }

    //Keyboard stuff
    public void pressKeys(String whatsWriten) {
        keyboard.status = 1;
        writeToMemory(keyboard.id, keyboard.status);
        keyboard.keysPressed = whatsWriten;
    }

    public void isKeyboard() {
        System.out.println(keyboard.keysPressed);
    }

    //USB stuff
    public void usbInfo() {
        System.out.println("Size of USB :" + usb.size + "  Free space:" + usb.freeSpace);
    }

    public void transfer(int data) {
        if (data < 0)
            usb.status = -1;
        else
            usb.status = 1;
        writeToMemory(usb.id, usb.status);

        if (data <= usb.freeSpace && data >= 0) {
            System.out.println("Copying data to USB");
            usb.freeSpace -= data;
            System.out.println("Data successfully transferred");
        } else if (data < 0 && ((usb.freeSpace + (-data)) <= usb.size)) {
            System.out.println("Removing data from USB");
            usb.freeSpace += -(data);
            System.out.println("Data successfully removed");
        } else if (data < 0) {
            System.out.println("You are trying to remove more than there is");
        } else {
            System.out.println("USB has not enough space");
        }
    }

    //What is connected
    public void connected(){
        devices.isConnected();
        mouse.isConnected();
        keyboard.isConnected();
        usb.isConnected();
    }
    //Clone mouse for new mouse
    //public Mouse newMouse = new Mouse(mouse);
}
