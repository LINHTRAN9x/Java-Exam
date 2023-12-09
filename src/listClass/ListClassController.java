package listClass;

import javafx.scene.control.Button;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.TextField;

import java.awt.*;
import java.net.URL;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;


public class ListClassController implements Initializable {

    public TextField className;
    public TextField classRoom;
    public TextField classId;
    public DatePicker dayStart;
    public ListView list;
    public ChoiceBox<String> choiceBox;
    public Button btn;
    private Class selectedClass;
    private boolean isEditing = false;
    private int indexCounter = 1; // Biến đếm để theo dõi index


    private ObservableList<Class> listClass = FXCollections.observableArrayList();
    public String[] types = {"Aptech","Arena","SkillKing"};

    public void submit(ActionEvent actionEvent) {
        try {
            String getClassName = className.getText();
            String getClassRoom = classRoom.getText();
            String getClassId = classId.getText();
            String getType = choiceBox.getValue();
            LocalDate getDayStart = dayStart.getValue();
            if(getClassName.isEmpty()){
                throw new Exception("Class Name không được để trống");
            }

            Class s = new Class(getClassName, getClassRoom, getClassId, getType, getDayStart);

            // Thêm lớp mới vào danh sách
            listClass.add(s);

            render();
            clearInput();
        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(e.getMessage());
            alert.show();
        }

    }
    private void render() throws Exception{
        list.setItems(listClass);
        list.refresh();
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        choiceBox.getItems().addAll(types);
        // Xử lý sự kiện khi chọn một mục trong ListView
        list.setOnMouseClicked(event -> {
            if (event.getClickCount() == 1) {
                // Kiểm tra xem người dùng đã nhấn không
                int selectedIndex = list.getSelectionModel().getSelectedIndex();
                if (selectedIndex >= 0 && selectedIndex < listClass.size()) {

                    selectedClass = listClass.get(selectedIndex);

                    // Hiển thị cửa sổ thông báo
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Confirmation");
                    alert.setHeaderText("Bạn có muốn chỉnh sửa thông tin không?");

                    ButtonType okButton = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
                    ButtonType cancelButton = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);

                    alert.getButtonTypes().setAll(okButton, cancelButton);

                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.isPresent() && result.get() == okButton) {
                        // Hiển thị thông tin lớp trong các trường dữ liệu của giao diện người dùng để chỉnh sửa
                        className.setText(selectedClass.getClassName());
                        classRoom.setText(selectedClass.getClassRoom());
                        classId.setText(selectedClass.getClassId());
                        choiceBox.setValue(selectedClass.getChoiceBox());
                        dayStart.setValue(selectedClass.getDayStart());
                        btn.setText("Update");
                        isEditing = true;
                    }
                }
            };
        });
        btn.setOnAction(event -> {
            if (isEditing) {
                updateClass();
            } else {
                submit(event);
            }
        });
    };
    private void updateClass() {
        try {
            if (selectedClass != null) {
                // Thực hiện chức năng chỉnh sửa dựa trên thông tin lớp đã chọn
                // Ví dụ: Cập nhật thông tin của lớp trong ObservableList
                selectedClass.setClassName(className.getText());
                selectedClass.setClassRoom(classRoom.getText());
                selectedClass.setClassId(classId.getText());
                selectedClass.setChoiceBox(choiceBox.getValue());
                selectedClass.setDayStart(dayStart.getValue());

                // Cập nhật giao diện
                render();
                clearInput();

                // Chuyển trạng thái về làm mới (không phải chế độ chỉnh sửa)
                btn.setText("Submit");
                isEditing = false;
            }
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(e.getMessage());
            alert.show();
        }
    }

    public void clearInput() throws Exception{
        className.clear();
        classRoom.clear();
        classId.clear();
        dayStart.setValue(null);
        choiceBox.setValue(null);
    }

}
