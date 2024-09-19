public class AddressBook {
    BuddyInfo[] buddies;

    public void addBuddy(BuddyInfo buddy){}

    public void removeBuddy(BuddyInfo buddy){}

    public static void main(String[] args){
        BuddyInfo buddy = new BuddyInfo("Tom", "1 Ave", 613);
        AddressBook addressBook = new AddressBook();
        addressBook.addBuddy(buddy);
        addressBook.removeBuddy(buddy);

    }
}
