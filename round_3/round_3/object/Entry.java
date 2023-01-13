package round_3.object;

import static round_3.utils.JDBCUtils.update;

public class Entry {
    public static int insert(int CID, int SID, String date) {
        return update("INSERT INTO school.entry(CID, SID, entry_time) VALUES (" + CID + "," + SID + ",'" + date + "');");
    }
    public static int delete(int CID, int SID, String date) {
        return  update("DELETE FROM school.entry WHERE CID = " + CID + " AND SID = " + SID + " AND entry_time = ");
    }
}
