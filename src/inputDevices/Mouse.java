package inputDevices;

public class Mouse extends Devices {

    public void isConnected() {
        System.out.println("Mouse is connected");
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
