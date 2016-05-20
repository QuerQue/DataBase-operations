import java.sql.*;

public class ConnectionSQL
{
    public static Connection Connector()
    {
        try
        {
            Class.forName("java.sql.Driver");
            Connection  connection = DriverManager.getConnection("jdbc:sqlite:C:/Programowanie/TableViewIntoDatabase/db/DBtest.db");
            return connection;
        } catch (Exception e)
        {
            System.out.println(e); // na wypadek zlej sciezki
            System.out.println("Connection problem");
            return null;
        }
    }
}

