package round_3;

import com.mysql.cj.jdbc.Driver;
import round_3.object.Classes;
import round_3.utils.JDBCUtils;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

class test {
    private static String driver = null;
    private static String url = null;
    private static String username = null;
    private static String password = null;

    private static Connection con = null;
    private static Statement st = null;
    private static ResultSet res = null;

    static {
        try {
            InputStream in = JDBCUtils.class.getClassLoader().getResourceAsStream("round_3/db.properties");
            Properties properties = new Properties();
            properties.load(in);

            driver = properties.getProperty("driver");
            url = properties.getProperty("url");
            username = properties.getProperty("username");
            password = properties.getProperty("password");

            //加载驱动
            Class.forName(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println(driver + "\n" + url + "\n" + username + "\n" + password);
        try {
            Connection con = DriverManager.getConnection(url,username,password);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
