package EventApp;
import java.sql.*;



public class db {

    private final String host = "localhost";
    private final String port = "5432";
    private final String dbName = "hehe";
    private final String login = "postgres";
    private final String password = "12345";

    private Connection dbCon; //подкл к бд

    private Connection getDbConnection() {

        //адрес нашей бд
        String str = "jdbc:postgresql://" + host + ":" + port + "/" + dbName;
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Соединение установлено");
        } catch (ClassNotFoundException e) {
            System.out.println("Соединение не установлено");
        }
        try {
            dbCon = DriverManager.getConnection(str, login, password);
        } catch (SQLException e) {
            System.out.println("Неверный логин и пароль");
        }
        return dbCon;
    }

    public void isConnection() throws SQLException, ClassNotFoundException {
        dbCon = getDbConnection();
        System.out.println(dbCon.isValid(1000));
    }

    public void createTable(String tableName) {
        String sql = "CREATE TABLE IF NOT EXISTS " + tableName +
                " (id INT PRIMARY KEY, title VARCHAR(20), text VARCHAR(50), date date)";
        try {
            Statement statement = getDbConnection().createStatement();
            statement.executeUpdate(sql);
            System.out.println("Таблица создалась");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addTable(String table) {
        try {
            Statement statement = getDbConnection().createStatement();
            int rows = statement.executeUpdate("INSERT INTO " + table + "(id, title, text, date) "
                    + "VALUES (5, 'Колледж', 'Я не иду завтра в колледж', '11.02.25');");
            System.out.printf("Добавлено %d строк ", rows);
        } catch (SQLException e) {
            System.out.println("Не удалось добавить");
        }

    }

    public void updateTable(String table) {
        try {
            Statement statement = getDbConnection().createStatement();
            int update = statement.executeUpdate("UPDATE " + table + " SET name = 'Рокешник' WHERE name = 'Рок' ");
            System.out.printf("Добавлено %d строк ", update);
        } catch (SQLException e) {
            System.out.println("Не удалось обновить");
        }
    }

    public void deleteTable(String table) {
        try {
            Statement statement = getDbConnection().createStatement();
            int delete = statement.executeUpdate("DELETE FROM " + table + " WHERE id = 1");
            System.out.printf("Добавлено %d строк ", delete);
        } catch (SQLException e) {
            System.out.println("Не удалось удалить");
        }
    }
}

