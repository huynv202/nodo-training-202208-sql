package NODO_tranning_JV_Core_Basic1;

public class SwitchExample {
    public static void main(String[] args) {
        int value = Integer.parseInt(args[0]);
        switch (value){
            case 0:
                System.out.println("bad");
                break;
            case 1:
                System.out.println("ok");
                break;
            default:
                System.out.println("invalid");
                break;
        }
    }

}
