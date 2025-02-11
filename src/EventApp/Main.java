package EventApp;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        db db = new db();
        db.isConnection();
        db.createTable("event");
        db.addTable("event");
    }
}
