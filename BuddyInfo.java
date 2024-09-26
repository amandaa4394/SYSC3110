package SYSC3110;
public class BuddyInfo {

    public BuddyInfo(String name, String address, int phoneNumber){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private String name;
    String address;
    int phoneNumber;

    public static void main(String[] args) {
        System.out.println("Hello world");

        BuddyInfo buddyInfo = new BuddyInfo("Daphne", "June 8", 613);

    }
}
