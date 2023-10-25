import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
    public static void main(String[] args) {
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        //Armar la conexión
        Connection connection = null;
        connection = DriverManager.getConnection("jdbc:h2:~/test:PASSWORD = sa; USER=sa");
        //The URL jdbc:h2:~/test means the database is stored in the user home directory in files starting with 'test'.
        //le asignamos un password y user sa
    }
}
