package inputDevices;

public class Mouse extends Devices {

    public void isConnected() {
        if (connectionStatus == 1)
            System.out.println("Mouse is connected");
        else
            System.out.println("Mouse is not connected");
    }
    public Mouse(){
        id=1;
        status=0;
    }
    public Mouse(Mouse original){
        this.id = original.id;
        this.status= original.status;
    }
}
