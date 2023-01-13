package round_3.object;

import static round_3.utils.JDBCUtils.update;

public class Students{

    public static int insert(int SID, String name, String gender, int grade) {
        return update("INSERT INTO school.students(SID, name, gender, grade) VALUES (" + SID + ",'" + name + "','" + gender + "'," + grade + ")");
    }

    public static int delete(int SID) {
        return update("DELETE FROM school.students WHERE SID = " + SID);
    }

}
