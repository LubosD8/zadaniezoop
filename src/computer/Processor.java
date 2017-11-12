package computer;

import inputDevices.*;

public class Processor {
    //Clone mouse for new mouse
    public Mouse newMouse;

    public Mouse mouse;
    private Devices devices;
    private Keyboard keyboard;
    private Usb usb;
    private Memory memory;
    private Webcam webcam;

    //Initialize memory
    public void initialize() {
        devices = new Devices();
        memory = new Memory();
        mouse = new Mouse();
        keyboard = new Keyboard();
        usb = new Usb();
        webcam = new Webcam();
        newMouse = new Mouse(mouse);
    }

    public void intializeIds() {
        mouse.id = 1;
        mouse.connectionStatus = 1;
        keyboard.id = 2;
        keyboard.connectionStatus = 1;
        usb.id = 0;
        usb.connectionStatus = 1;
    }

    private void reset(int idOfDevice) {
        int place[][]= memory.getPlace();
        place[idOfDevice][0] = -1;
        place[idOfDevice][1] = -1;
        System.out.println("Device with ID: " + idOfDevice + " was successfully disconnected");
    }
    private void connectedSuccessfuly(int idOfDevice) {
        System.out.println("Device with ID: " + idOfDevice + " was successfully connected");
    }

    public void disconnect(int idOfDevice) {
        int a = 0;
        int place[][]= memory.getPlace();
        int n = memory.getCapacity();
        for (int i = 0; i < n; i++) {
            a++;
            if (place[i][0] == idOfDevice) {
                switch (idOfDevice) {
                    case 0:
                        if (usb.connectionStatus == 0)
                            System.out.println("Device is not connected");
                        usb.connectionStatus = 0;
                        reset(idOfDevice);
                        break;
                    case 1:
                        if (mouse.connectionStatus == 0)
                            System.out.println("Device is not connected");
                        mouse.connectionStatus = 0;
                        reset(idOfDevice);
                        break;
                    case 2:
                        if (keyboard.connectionStatus == 0)
                            System.out.println("Device is not connected");
                        keyboard.connectionStatus = 0;
                        reset(idOfDevice);
                        break;
                    case 3:
                        if (webcam.connectionStatus == 0)
                            System.out.println("Device is not connected");
                        webcam.connectionStatus = 0;
                        reset(idOfDevice);
                        break;
                }
                break;
            }
        }
        if (a == n)
            System.out.println("No device found");
    }

    public void connect(int idOfDevice) {
        int place[][]= memory.getPlace();
        int n= memory.getCapacity();
        for (int i = 0; i < n ; i++) {
            if (place[i][0] == idOfDevice) {
                System.out.println("Device already connected");
            } else {
                switch (idOfDevice) {
                    case 0:
                        place[idOfDevice][0] = idOfDevice;
                        usb.connectionStatus = 1;
                        connectedSuccessfuly(idOfDevice);
                        break;
                    case 1:
                        place[idOfDevice][0] = idOfDevice;
                        mouse.connectionStatus = 1;
                        connectedSuccessfuly(idOfDevice);
                        break;
                    case 2:
                        place[idOfDevice][0] = idOfDevice;
                        keyboard.connectionStatus = 1;
                        connectedSuccessfuly(idOfDevice);
                        break;
                    case 3:
                        place[idOfDevice][0] = idOfDevice;
                        webcam.connectionStatus = 1;
                        connectedSuccessfuly(idOfDevice);
                        break;
                    default:
                        System.out.println("unknown device");
                        connectedSuccessfuly(idOfDevice);
                        break;
                }
                break;
            }
        }
    }

    //What is connected
    public void connected() {
        devices.isConnected();
        mouse.isConnected();
        keyboard.isConnected();
        usb.isConnected();
        webcam.isConnected();
    }

    public void initializeMemory() {
        int place[][]= memory.getPlace();
        int n= memory.getCapacity();
        for (int i = 0; i < n; i++) {
            place[i][0] = -1;
            place[i][1] = -1;
        }
        place[mouse.id][0] = mouse.id;
        place[keyboard.id][0] = keyboard.id;
        place[usb.id][0] = usb.id;
    }

    private void writeToMemory(int id, int status) {
        int place[][]= memory.getPlace();
        place[id][1] = status;
    }

    public void printMemory() {
        int place[][]= memory.getPlace();
        int n= memory.getCapacity();
        System.out.println("ID 0 = USB, ID 1 = Mouse, ID 2 = Keyboard, ID 3 = Webcam");
        for (int i = 0; i < n; i++) {
            System.out.println("ID in memory:" + place[i][0] + "  Status: " + place[i][1] + "\n");
            place[i][1] = -1;
        }
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

}
