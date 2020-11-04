package main.java.sample.model;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Logger;
import java.util.logging.Level;

public class ConnectorDB {

    public static ArrayList<String> get() throws Exception{
        try{
            Connection con = getConnection();
            PreparedStatement statement = con.prepareStatement("SELECT name,company FROM data");
            ResultSet result = statement.executeQuery();

            ArrayList<String> array = new ArrayList<String>();
            while ((result.next())){
                System.out.print("Name: ");
                System.out.print(result.getString("Name"));
                System.out.print(", Company: ");
                System.out.println(result.getString("Company"));
                System.out.println();
                //array.add(result.getString("Name"));
            }
            System.out.println("All records have been selected");
            return array;
        }catch(Exception e){
            System.out.println(e);
            return null;
        }
    }
    public static Connection getConnection() throws Exception{
        try{
            String driver = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://127.0.0.1:3306/Ingredient"; //server can be seen as local host followed by the name of the schema
            String username = "root"; //username goes here
            String password = "password"; //your password goes here
            Connection connect = DriverManager.getConnection(url, username, password);
            System.out.println("Connected!");
            return connect;
        }catch(Exception e){
            System.out.println(e);
        }
        return null;
    }


    /*************************************************************
     * Creates a table
     * @throws Exception
     **************************************************************/
    public static void createTable() throws Exception {
        try {
            Connection con = getConnection();
            PreparedStatement create = con.prepareStatement("CREATE TABLE IF NOT EXISTS ingredient(idI int NOT NULL AUTO_INCREMENT, idR int, idR name varchar(255), PRIMARY KEY(idI))");
            create.executeUpdate();
        }catch (Exception e) {
            System.out.println(e);
        }
        finally {
            System.out.println("Function complete!");
        }
    }

    /***********************************************************************8
     * Second try at connecting to MyServe
     *******************************************************************************/
    void createConnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Ingredient", "root", "password");

            System.out.println("Connected to Database");
        }catch (ClassNotFoundException e){
            Logger.getLogger(ConnectorDB.class.getName()).log(Level.SEVERE, null, e);
        }catch (SQLException e){
            Logger.getLogger(ConnectorDB.class.getName()).log(Level.SEVERE, null, e);
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        //ConnectorDB connection = new ConnectorDB();
        //connection.createConnection();
        //createTable();
        getConnection();
    }

}
