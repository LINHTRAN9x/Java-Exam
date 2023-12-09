package listClass;

import java.time.LocalDate;

public class Class {
    private String className;
    private String classRoom;
    private String classId;
    private LocalDate dayStart;

    private String choiceBox;

    private static int indexCounter = 1;
    private int index;
    public String getChoiceBox() {
        return choiceBox;
    }

    public void setChoiceBox(String choiceBox) {
        this.choiceBox = choiceBox;
    }

    public Class(String className, String classRoom, String classId,String choiceBox, LocalDate dayStart) {

        this.className = className;
        this.classRoom = classRoom;
        this.classId = classId;
        this.choiceBox = choiceBox;
        this.dayStart = dayStart;
        this.index = indexCounter++;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(String classRoom) {
        this.classRoom = classRoom;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public LocalDate getDayStart() {
        return dayStart;
    }

    public void setDayStart(LocalDate dayStart) {
        this.dayStart = dayStart;
    }
    public String toString(){
        return "STT: "+index+"\n"+"Class Name: "+className+"\n"+"Class Room: "+classRoom+"\n"+"Class ID: "+classId+"\n"
                +"Day Start: "+dayStart
                +"\n"+"Skill type: "+choiceBox;
    }

}
