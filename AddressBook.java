package SYSC3110;

import javax.swing.DefaultListModel; //Notify view when list is updated

import java.util.ArrayList;

public class AddressBook extends DefaultListModel<BuddyInfo>{


    public AddressBook(){
    }
    public void addBuddy(BuddyInfo aBuddy){
        if(aBuddy != null){
            this.addElement(aBuddy);
        }
    }

    public BuddyInfo removeBuddy(int index){
        if(index >= 0 && index < this.size()){
            return this.remove(index);
        }
        return null;
    }



}
