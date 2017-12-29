package mike.wang.mysql;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

public class DB {
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    
    public static Connection connect(DSN dsn) {
        System.out.println(dsn);
        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(
                    dsn.toString(),
                    dsn.getUser(),
                    dsn.getPassword()
            );
            
            return conn;
        } catch (Exception e) {
            // TODO(MikeWang): 区分不同的错误
            System.out.println(e);
        }
        
        return null;
    }
    
    public static String[] catalogs(DatabaseMetaData meta) {
        ArrayList<String> dbs = new ArrayList<String>();
        ResultSet rs = null;
        try {
            rs = meta.getCatalogs();
            while (rs.next()) {
                // 获取数据库名称
                dbs.add(rs.getString("TABLE_CAT"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        String []catalogs = new String[dbs.size()];
        
        return dbs.toArray(catalogs);
    }
}
