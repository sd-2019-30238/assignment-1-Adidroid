package BusinessLogic.Service;

import PersistenceLayer.SessionUtil;
import BusinessLogic.Model.Staff;
import PersistenceLayer.impl.StaffDAO;

public class StaffService {

    public static boolean checkStaff(String username,String password) {

        Staff staff = new StaffDAO(SessionUtil.getSessionFactory()).findByUsername(username);
        if (staff == null)
            return false;

        if (!staff.getPassword().equals(password))
            return false;
        return true;
    }

    public static void addStaff(Staff staff){
        new StaffDAO(SessionUtil.getSessionFactory()).save(staff);
    }
}
