package SYSC3110;

import javax.swing.*;
import java.awt.event.*;

public class AddressBookGUI {
    private AddressBook addressBook;
    private JFrame frame;
    private JList<BuddyInfo> buddyList;
    private DefaultListModel<BuddyInfo> buddyListModel;

    public AddressBookGUI() {
        addressBook = new AddressBook();  // Create empty address book
        buddyListModel = new DefaultListModel<>();  // List model for displaying buddies
        frame = new JFrame("AddressBook");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);

        // JList for displaying buddies
        buddyList = new JList<>(buddyListModel);  // Set model to the buddy list
        JScrollPane scrollPane = new JScrollPane(buddyList);
        frame.add(scrollPane);

        // Menu bar:
        JMenuBar menuBar = new JMenuBar();

        // Menu for addressBook
        JMenu addressBookMenu = new JMenu("AddressBook");
        JMenuItem newAddressBookItem = new JMenuItem("New AddressBook");
        addressBookMenu.add(newAddressBookItem);

        // Buddy info Menu
        JMenu buddyInfoMenu = new JMenu("BuddyInfo");
        JMenuItem addBuddyItem = new JMenuItem("Add Buddy");
        JMenuItem removeBuddyItem = new JMenuItem("Remove Buddy");

        buddyInfoMenu.add(addBuddyItem);
        buddyInfoMenu.add(removeBuddyItem);

        menuBar.add(addressBookMenu);
        menuBar.add(buddyInfoMenu);

        frame.setJMenuBar(menuBar);

        // Action listeners for menu items:

        // Create a new AddressBook and clear the list
        newAddressBookItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addressBook = new AddressBook();  // Reset the address book
                buddyListModel.clear();  // Clear the list displayed in the JList
                JOptionPane.showMessageDialog(frame, "New AddressBook created!");
            }
        });

        // Add a new buddy to the address book
        addBuddyItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = JOptionPane.showInputDialog(frame, "Enter Buddy's name");
                String address = JOptionPane.showInputDialog(frame, "Enter address");
                String phone = null;
                int phoneNumber = -1;

                // Loop to get valid phone number
                while (true) {
                    phone = JOptionPane.showInputDialog(frame, "Enter phone number");
                    try {
                        phoneNumber = Integer.parseInt(phone);
                        break;  // If valid, exit the loop
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(frame, "Please enter a valid number.");
                    }
                }

                // Add the buddy if all fields are valid
                if (name != null && address != null && phone != null) {
                    BuddyInfo buddy = new BuddyInfo(name, address, phoneNumber);
                    addressBook.addBuddy(buddy);
                    buddyListModel.addElement(buddy);  // Add buddy to the displayed list
                }
            }
        });

        // Remove a selected buddy from the address book
        removeBuddyItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = buddyList.getSelectedIndex();  // Get selected buddy index
                if (index != -1) {
                    addressBook.removeBuddy(index);  // Remove buddy from address book
                    buddyListModel.remove(index);  // Remove buddy from the displayed list
                } else {
                    JOptionPane.showMessageDialog(frame, "Please select a valid buddy.");
                }
            }
        });

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        // Makes sure the GUI is made on the event dispatch thread
        SwingUtilities.invokeLater(AddressBookGUI::new);
    }
}
