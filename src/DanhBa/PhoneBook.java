package DanhBa;

import java.util.ArrayList;
import java.util.Collections;

class PhoneBook extends Phone {
    public ArrayList<PhoneNumber> PhoneList = new ArrayList<>();

    public void printPhoneList(){
        for (PhoneNumber num : PhoneList) {
            System.out.println("------------------------");
            System.out.println("Name: " + num.getName());
            System.out.println("Phone Numbers:");

            for (String phoneNumber : num.getPhone()) {
                System.out.println(phoneNumber);
            }

            System.out.println("------------------------");
        }
    }
    @Override
    public void insertPhone(String name, String phone) {
        for (PhoneNumber num : PhoneList) {
            if (num.getName().equals(name)) {

                if (!num.getPhone().contains(phone)) {

                    num.addPhone(phone);

                    System.out.println("Added phone: " + phone + " for " + name);
                } else {

                    System.out.println("Phone number already exists for " + name);
                }
                return;
            }
        }


        PhoneNumber newContact = new PhoneNumber(name, phone);
        PhoneList.add(newContact);
        System.out.println("Added new entry: " + name + ", " + phone);
    }


    @Override
    public void removePhone(String name) {
        PhoneList.removeIf(n -> n.getName().equals(name));
        System.out.println("Remove :"+ name);
    }

    @Override
    public void updatePhone(String name, String oldPhone, String newPhone) {
        for (PhoneNumber num : PhoneList) {
            if (num.getName().equals(name)) {
                if (num.getPhone().contains(oldPhone)) {
                    ArrayList<String> updatedPhones = new ArrayList<>(num.getPhone());
                    updatedPhones.remove(oldPhone);
                    updatedPhones.add(newPhone);
                    num.setPhone(updatedPhones);
                    System.out.println("Updated phone number for " + name + " from " + oldPhone + " to " + newPhone);
                } else {
                    System.out.println("Old phone number not found in " + name);
                }
                return;
            }
        }
        System.out.println("User not found: " + name);
    }





    @Override
    public PhoneNumber searchPhone(String name) {
        for (PhoneNumber entry : PhoneList) {
            if (entry.getName().equals(name)) {
                System.out.println("Search Name: " + entry.getName() + entry.getPhone());

                return entry;

            }
        }
        return null;
    }

    @Override
    public void sort() {
        Collections.sort(PhoneList);
        System.out.println("Sort completed!");
    }
}