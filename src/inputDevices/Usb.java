package inputDevices;

public class Usb extends Devices {
    public int size = 8192;
    public int freeSpace = 8192;

    public void isConnected() {
        if (connectionStatus == 1)
            System.out.println("USB is connected");
        else
            System.out.println("USB is not connected");
    }
}
