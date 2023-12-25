package javafx_mutipage.factory;

import javafx_mutipage.dao.ClassDAO;
import javafx_mutipage.dao.DAOInterface;
import javafx_mutipage.dao.StudentDAO;
import javafx_mutipage.enums.DAOType;

public class DAOFactory { //Factory design pattern.
    public final static DAOInterface getDaoInstance(DAOType daoType){
        switch (daoType){
            case STUDENT: return new StudentDAO();
            case CLASS: return new ClassDAO();
        }
        return null;
    }
}
