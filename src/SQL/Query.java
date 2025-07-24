//query.user_exists(DBConnection.getConnection(), "name");


package SQL;

import java.sql.*;

public class Query {
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
    
    public static boolean mediacontent_exists(Connection conn, int id_glob){
  
        try{
            
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM mediacontent WHERE id_glob = ?");
            statement.setInt(1,id_glob);

            ResultSet rs = statement.executeQuery();
            
            
            while(rs.next()){
                System.out.println(rs.getString(2)+ " "+ rs.getString(3) +" "+ rs.getString(4));
            }
            rs.close();
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
         
        return true;
        
    }
    public static boolean video_exists(Connection conn, int id_glob){
        try{
            
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM video WHERE id_glob = ?");
            statement.setInt(1,id_glob);

            ResultSet rs = statement.executeQuery();
            
            
            while(rs.next()){
                System.out.println(rs.getString(2)+ " "+ rs.getString(3));
            }
            rs.close();
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
         
        return true;
        
    }
    public static boolean VideoUrl_exists(Connection conn, int id_glob){
  
        try{
            
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM VideoURL WHERE video_id_glob = ?");
            statement.setInt(1,id_glob);

            ResultSet rs = statement.executeQuery();
            
            
            while(rs.next()){
                System.out.println(rs.getString(2)+ " "+ rs.getString(3));
            }
            rs.close();
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
         
        return true;
        
    }
    public static boolean uservideoinfo_exists(Connection conn, int id_glob){
  
        try{
            
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM uservideoinfo WHERE video_id_glob = ?");
            statement.setInt(1,id_glob);

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
    public static boolean uservideohistory_exists(Connection conn, int user_video_info_id){
  
        try{
            
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM uservideohistory WHERE user_video_info = ?");
            statement.setInt(1,user_video_info_id);

            ResultSet rs = statement.executeQuery();
            
            
            while(rs.next()){
                System.out.println(rs.getString(1)+ " "+ rs.getString(2)+ " "+ rs.getString(3));
            }
            rs.close();
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
         
        return true;
        
    }
    public static boolean series_exists(Connection conn, int id){
  
        try{
            
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM serie WHERE id = ?");
            statement.setInt(1,id);

            ResultSet rs = statement.executeQuery();
            
            
            while(rs.next()){
                System.out.println(rs.getString(1)+ " ");
            }
            rs.close();
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
         
        return true;
        
    }
    public static boolean playlist_exists(Connection conn, int id){
  
        try{
            
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM playlist WHERE id = ?");
            statement.setInt(1,id);

            ResultSet rs = statement.executeQuery();
            
            
            while(rs.next()){
                System.out.println(rs.getString(1));
            }
            rs.close();
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
         
        return true;
        
    }
    public static boolean saga_exists(Connection conn, int id){
  
        try{
            
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM saga WHERE id = ?");
            statement.setInt(1,id);

            ResultSet rs = statement.executeQuery();
            
            
            while(rs.next()){
                System.out.println(rs.getString(1)+ " ");
            }
            rs.close();
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
         
        return true;
        
    }
}