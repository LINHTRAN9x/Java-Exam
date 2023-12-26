package javafx;

import java.time.LocalDate;

public class StudentData {
    private String fullName;
    private String email;
    private String telephone;
    private String address;
    private LocalDate dob;

    public StudentData(String fullName, String email, String telephone, String address, LocalDate dob) {
        this.fullName = fullName;
        this.email = email;
        this.telephone = telephone;
        this.address = address;
        this.dob = dob;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }
}

