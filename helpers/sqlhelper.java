package helpers;
import java.sql.*;

//in this class im creating diffrent methodes to interact with my db 
public class sqlhelper {

    private static Connection connection;
    public static Connection getConnection() throws SQLException
    {
       connection = DriverManager.getConnection(sqlinfo.URL,sqlinfo.USERNAME,sqlinfo.PASSWORD );
       if (connection != null) {
           System.out.println("succesful connection ") ; 
           
       }
       else {
           System.out.println("failed to connect ");
       }
       return connection;
    }

    public static void closeConnection( Connection con ) throws SQLException
   {
      if ( con != null )
      {
         con.close();
      }
   }

   public static void closePrepaerdStatement( PreparedStatement stmt ) throws SQLException
   {
      if ( stmt != null )
      {
         stmt.close();
      }
   }

   public static void closeResultSet( ResultSet rs ) throws SQLException
   {
      if ( rs != null )
      {
         rs.close();
      }
   }
 
    
}
