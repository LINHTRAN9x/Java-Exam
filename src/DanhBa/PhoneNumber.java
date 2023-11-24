package DanhBa;
import java.util.List;
import java.util.ArrayList;

class PhoneNumber implements Comparable<PhoneNumber> {
    private String name;
    private ArrayList<String> phones;

    public PhoneNumber(String name, String phone) {
        this.name = name;
        this.phones = new ArrayList<>();
        this.phones.add(phone);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getPhone() {
        return new ArrayList<>(phones);
    }

    public void setPhone(ArrayList<String> phone) {
        this.phones = new ArrayList<>(phone);
    }

    public void addPhone(String phone) {
        this.phones.add(phone);
    }
    public int compareTo(PhoneNumber other) {
        return this.getName().compareToIgnoreCase(other.getName());
    }

}