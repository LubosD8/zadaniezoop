package inputDevices;

public class Webcam extends Devices{

    public void isConnected() {
        if (connectionStatus == 1)
            System.out.println("Webcam is connected");
        else
            System.out.println("Webcam is not connected");
    }
}
