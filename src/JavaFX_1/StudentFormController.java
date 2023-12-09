package JavaFX_1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.text.Text;

import java.time.LocalDate;
import java.util.ArrayList;

public class StudentFormController {

    public TextField ipFullName;
    public TextField ipEmail;
    public TextField ipTel;
    public TextArea ipAddress;
    public DatePicker ipDoB;
    public ListView<Student> listView;

    private ObservableList<Student> list = FXCollections.observableArrayList();

    public void submit(ActionEvent actionEvent) {
        try {
            String fullName = ipFullName.getText();
            String email = ipEmail.getText();
            String tel = ipTel.getText();
            String address = ipAddress.getText();
            LocalDate dob = ipDoB.getValue();
            if(fullName.isEmpty()|| fullName.length() < 5){
                throw new Exception("Vui lòng điền họ và tên");
            }
            // set view
            Student s = new Student(fullName,email,tel,address,dob);
            list.add(s);
            render();
            clearInput();
        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(e.getMessage());
            alert.show();
        }
    }

    private void render() throws Exception{ // print list student to information
        listView.setItems(list);
        listView.refresh();
    }

    private void clearInput() throws Exception{
        ipFullName.clear();
        ipEmail.clear();
        ipTel.clear();
        ipAddress.clear();
        ipDoB.setValue(null);
    }
}