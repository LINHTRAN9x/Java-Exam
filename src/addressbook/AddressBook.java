package addressbook;

import java.util.HashMap;

public class AddressBook {
    private HashMap<String, Contact> contacts = new HashMap<>();

    public void addContact(String name, String phoneNumber) {
        Contact contact = new Contact(name, phoneNumber);
        contacts.put(name, contact);
        System.out.println("Contact added successfully!");
    }

    public void findContact(String name) {
        Contact contact = contacts.get(name);
        if (contact != null) {
            System.out.println("Phone number for " + name + ": " + contact.getTelephone());
        } else {
            System.out.println("Contact Not Found!");
        }
    }

    public void displayContacts() {
        System.out.println("Contact Name  Phone Number");
        for (HashMap.Entry<String, Contact> entry : contacts.entrySet()) {
            System.out.println(entry.getKey() +"          "+ entry.getValue().getTelephone());
        }
    }
}
