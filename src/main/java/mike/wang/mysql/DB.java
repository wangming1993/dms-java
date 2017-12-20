package mike.wang.mysql;

import java.sql.Connection;
import java.sql.DriverManager;

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
}
