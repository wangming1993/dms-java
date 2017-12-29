package mike.wang.mysql;

public class DSN {
    public String host;
    public int port;
    public String dbName;
    
    public String getUser() {
        return user;
    }
    
    public String getPassword() {
        return password;
    }
    
    public String user;
    public String password;

    @Override
    public String toString() {
        return String.format("jdbc:mysql://%s:%d/%s?useSSL=false&nullNamePatternMatchesAll=true",
            this.host,
            this.port,
            this.dbName
        );
    }
}
