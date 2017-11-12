package inputDevices;

public class Keyboard extends Devices {
    public String keysPressed;

    public void isConnected() {
        if (connectionStatus == 1)
            System.out.println("Keyboard is connected");
        else
            System.out.println("Keyboard is not connected");
    }
}
