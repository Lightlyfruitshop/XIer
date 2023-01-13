package round_3.object;

import static round_3.utils.JDBCUtils.update;

public class Classes {
    public static int insert(int CID) {
        return update("INSERT INTO school.class(CID) VALUES (" + CID + ");");
    }
    public static int delete(int CID) {
        return update("DELETE FROM school.class WHERE CID = " + CID);
    }
}
