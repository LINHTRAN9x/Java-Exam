package javafx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Observable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Iterator;

public class StudentFormController {

    public TextField ipFullName;
    public TextField ipEmail;
    public TextArea ipAddress;
    public TextField ipTelephone;
    public DatePicker ipDob;
    public Text textDob;
    public Text textStudentlist;
    private ArrayList<StudentData> studentList;
    private StudentData studentData;

    public void initialize() {
        studentList = new ArrayList<>();

        studentData = new StudentData("", "", "", "", LocalDate.now());
    }

    public void submit(ActionEvent actionEvent) {
        if (!isValidInput()) {
            return;
        }

        StudentData newStudentData = new StudentData(
                ipFullName.getText(),
                ipEmail.getText(),
                ipTelephone.getText(),
                ipAddress.getText(),
                ipDob.getValue()
        );

        // Thêm đối tượng StudentData mới vào danh sách
        studentList.add(newStudentData);

        // Hiển thị danh sách sinh viên
        displayStudentList();

        resetInputFields();

    }
    private void displayStudentList() {
        StringBuilder sb = new StringBuilder();
        for (StudentData student : studentList) {
            sb.append("Full Name: ").append(student.getFullName()).append("\n");
            sb.append("Email: ").append(student.getEmail()).append("\n");
            sb.append("Telephone: ").append(student.getTelephone()).append("\n");
            sb.append("Address: ").append(student.getAddress()).append("\n");
            sb.append("Date of Birth: ").append(student.getDob()).append("\n");
            sb.append("------------------------\n");
        }

        textStudentlist.setText(sb.toString());
    }
    private void resetInputFields() {
        ipFullName.clear();
        ipEmail.clear();
        ipTelephone.clear();
        ipAddress.clear();
        ipDob.setValue(null);
    }
    private boolean isValidInput() {
        boolean isValid = true;

        String fullName = ipFullName.getText();
        String email = ipEmail.getText();
        String telephone = ipTelephone.getText();
        LocalDate dob = ipDob.getValue();


        ipFullName.setPromptText("Nhập họ và tên");
        ipEmail.setPromptText("Nhập địa chỉ email");
        ipTelephone.setPromptText("Nhập số điện thoại");
        ipDob.setPromptText("Chọn ngày sinh");

        if (fullName.isEmpty()) {
            ipFullName.getStyleClass().add("error-textfield");
            ipFullName.setPromptText("Vui lòng nhập vào đây!");
            isValid = false;
        } else {
            ipFullName.getStyleClass().remove("error-textfield");
        }
        // Validate email using regular expression
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);

        if (email.isEmpty()) {
            ipEmail.getStyleClass().add("error-textfield");
            ipEmail.setPromptText("Vui lòng nhập vào đây!");
            isValid = false;
        } else if (!matcher.matches()) {
            ipEmail.getStyleClass().add("error-textfield");
            ipEmail.setText("");
            ipEmail.setPromptText("Vui lòng nhập đúng định dạng email!");
            isValid = false;
        } else {
            ipEmail.getStyleClass().remove("error-textfield");
        }

        if (telephone.isEmpty()) {
            ipTelephone.getStyleClass().add("error-textfield");
            ipTelephone.setPromptText("Vui lòng nhập vào đây!");
            isValid = false;
        } else if (!isValidPhoneNumber(telephone)) {
            ipTelephone.getStyleClass().add("error-textfield");
            ipTelephone.setText("");
            ipTelephone.setPromptText("Vui lòng chỉ nhập chữ số và 9 số trở lên!");
            isValid = false;
        } else {
            ipTelephone.getStyleClass().remove("error-textfield");
        }

        if (dob == null) {
            ipDob.getStyleClass().add("error-textfield");
            ipDob.setPromptText("Vui lòng nhập vào đây!");
            isValid = false;
        } else {
            ipDob.getStyleClass().remove("error-textfield");
        }

        return isValid;
    }
    private boolean isValidPhoneNumber(String phoneNumber) {
        // Kiểm tra xem chuỗi chỉ chứa các ký tự số và có độ dài từ 9 đến 15 ký tự
        return phoneNumber.matches("\\d{9,15}");
    }

    public void closeBtn(ActionEvent actionEvent) {
        studentList.remove(0);
        displayStudentList();
    }
}
