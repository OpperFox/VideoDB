//query.user_exists(DBConnection.getConnection(), "name");


package SQL;

import java.sql.*;

public class query {
    public static boolean user_exists(Connection conn, String name){
  
        try{
            
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM USUARIO WHERE NOMBRE = ?");
            statement.setString(1,name);

            ResultSet rs = statement.executeQuery();
            
            
            while(rs.next()){
                System.out.println(rs.getString(1) + " "+ rs.getString(2)+ " "+ rs.getString(3));
            }
            rs.close();
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
         
        return true;
        
    }
    
    
    public static boolean usermediaregistry_exists(Connection conn, int usuarioid){
  
        try{
            
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM usermediaregistry WHERE usuario_id = ?");
            statement.setInt(1,usuarioid);

            ResultSet rs = statement.executeQuery();
            
            
            while(rs.next()){
                System.out.println(rs.getString(1) + " "+ rs.getString(2)+ " "+ rs.getString(3)+ " " + rs.getString(3)+ " " + rs.getString(4)+ " " + rs.getString(5)+ " " + rs.getString(7)+ " " );
            }
            rs.close();
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
         
        return true;
        
    }
    
    
}
