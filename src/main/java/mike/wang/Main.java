package mike.wang;

import com.mysql.cj.core.result.Field;
import mike.wang.mysql.DB;
import mike.wang.mysql.DSN;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
        DSN dsn = new DSN();
        dsn.host = "127.0.0.1";
        dsn.port = 3306;
        dsn.dbName = "qun_dev";
        dsn.user = "root";
        dsn.password = "root";

        Connection conn = DB.connect(dsn);
        if (conn == null) {
            System.out.println("connect mysql failed");
            return;
        }
        
        DatabaseMetaData meta = null;
        try {
            meta = conn.getMetaData();
            String keywords = meta.getSQLKeywords();
            System.out.println(keywords);
    
            ResultSet rs = meta.getTables(null, null, null,null);
            while (rs.next()) {
                System.out.print(rs.getString("TABLE_CAT") + " ");
                System.out.print(rs.getString("TABLE_SCHEM") + " ");
                System.out.print(rs.getString("TABLE_NAME"));
                //System.out.print(rs.getString("COLUMN_NAME"));
                //System.out.print(rs.getString("GRANTOR"));
                //System.out.print(rs.getString("GRANTEE"));
                //System.out.print(rs.getString("PRIVILEGE"));
                //System.out.println(rs.getString("IS_GRANTABLE"));
                //System.out.println(rs.getString(3));
                System.out.println();
            }
    
        } catch (SQLException e) {
            System.out.println(e);
            return;
        }
        
    }
}
