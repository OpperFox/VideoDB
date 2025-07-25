//query.user_exists(DBConnection.getConnection(), "name");  


package SQL;

import java.sql.*;

public class Query {

    private static String[] printResultSet(ResultSet rs, int col) throws SQLException {
    	int columnCount = col;
    	String[] x = new String[columnCount+1];  
    	try {    		
        
    		while (rs.next()) {
        	
    			for (int i = 1; i <= columnCount; i++) {
    				x[i] = (rs.getString(i) + " ");
    				System.out.println(rs.getString(i) + " ");
    			}
            
    			System.out.println();            
    		}
    		return x;
    	}catch(Exception e){
            e.printStackTrace();
            return x;
        }
    	
    }

    public static boolean user_exists(Connection conn, String name, String password){
        try{
            PreparedStatement statement = conn.prepareStatement(
                "SELECT * FROM USUARIO WHERE NOMBRE = ? AND password = ?"
            );
            statement.setString(1, name);
            statement.setString(2, password);

            ResultSet rs = statement.executeQuery();
            boolean existe = rs.next(); // Solo chequea si hay al menos un resultado

            if (existe) {
                // Opcional: imprimir contenido
                ResultSetMetaData meta = rs.getMetaData();
                int columnCount = meta.getColumnCount();
                for (int i = 1; i <= columnCount; i++) {
                    System.out.println(rs.getString(i) + " ");
                }
            }

            rs.close();
            return existe;

        } catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
 
    public static boolean user_registry(Connection conn, String name, String password){
        try{
            PreparedStatement statement = conn.prepareStatement(
                "INSERT INTO usuario (nombre, password) VALUES (?,?)"
            );
            statement.setString(1, name);
            statement.setString(2, password);

            statement.executeUpdate();
            
        } catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    

    public static boolean usermediaregistry_exists(Connection conn, String nombre, String rating, String status, String tipo, boolean favorito,Date fecha_comienzo, String reference_url, int usuario_id){
        try{
            PreparedStatement statement = conn.prepareStatement(
                "SELECT * FROM usermediaregistry WHERE nombre = ? AND rating = ? AND status = ? AND favorito = ? AND fecha_comienzo = ? AND tipo = ? AND reference_url = ? AND usuario_id = ?"
            );

            statement.setString(1, nombre);
            statement.setString(2, rating);
            statement.setString(3, status);
            statement.setString(4, tipo);
            statement.setBoolean(5, favorito);
            statement.setDate(6, fecha_comienzo);
            statement.setString(7, reference_url);
            statement.setInt(8, usuario_id);

            ResultSet rs = statement.executeQuery();
            ResultSetMetaData meta = rs.getMetaData();
    		int columnCount = meta.getColumnCount();
    		
            String[] y = printResultSet(rs, columnCount );
            rs.close();
        } catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public static boolean usermediaregistry_registry(Connection conn, String nombre, String rating, String status, String tipo, boolean favorito,Date fecha_comienzo, String reference_url, int usuario_id){
        try{
            PreparedStatement statement = conn.prepareStatement(
                "INSERT INTO USARMEDIAREGISTRY (nombre,rating, status, tipo, favorito, Fecha_comienzo, reference_url, usuario_id)"
                + "VALUES (?,?,?,?,?,?,?,?)"
            );

            statement.setString(1, nombre);
            statement.setString(2, rating);
            statement.setString(3, status);
            statement.setString(4, tipo);
            statement.setBoolean(5, favorito);
            statement.setDate(6, fecha_comienzo);
            statement.setString(7, reference_url);
            statement.setInt(8, usuario_id);

            statement.executeUpdate();
        } catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public static boolean mediacontent_exists(Connection conn, int id_glob, int id_loc, String alfa, String beta, String nombre, String tipo){
        try{
            PreparedStatement statement = conn.prepareStatement(
                "SELECT * FROM MediaContent WHERE id_glob = ? AND id_loc = ? AND alfa = ? AND beta = ? AND nombre = ? AND tipo = ?"
            );

            statement.setInt(1, id_glob);
            statement.setInt(2, id_loc);
            statement.setString(3, alfa);
            statement.setString(4, beta);
            statement.setString(5, nombre);
            statement.setString(6, tipo);

            ResultSet rs = statement.executeQuery();
            ResultSetMetaData meta = rs.getMetaData();
    		int columnCount = meta.getColumnCount();
    		
            String[] y = printResultSet(rs, columnCount );
            rs.close();
        } catch(Exception e){
            e.printStackTrace();
        }
        return true;
    }

    public static boolean video_exists(Connection conn, int id_glob, int id_loc, String nombre){
        try{
            PreparedStatement statement = conn.prepareStatement(
                "SELECT * FROM video WHERE id_glob = ? AND id_loc = ? AND nombre = ?"
            );

            statement.setInt(1, id_glob);
            statement.setInt(2, id_loc);
            statement.setString(3, nombre);

            ResultSet rs = statement.executeQuery();
            ResultSetMetaData meta = rs.getMetaData();
    		int columnCount = meta.getColumnCount();
    		
            String[] y = printResultSet(rs, columnCount );
            rs.close();
        } catch(Exception e){
            e.printStackTrace();
        }
        return true;
    }

    public static boolean VideoUrl_exists(Connection conn, int video_id_glob, int video_id_loc, String enlace){
        try{
            PreparedStatement statement = conn.prepareStatement(
                "SELECT * FROM VideoURL WHERE video_id_glob = ? AND video_id_loc = ? AND enlace = ?"
            );

            statement.setInt(1, video_id_glob);
            statement.setInt(2, video_id_loc);
            statement.setString(3, enlace);

            ResultSet rs = statement.executeQuery();
            ResultSetMetaData meta = rs.getMetaData();
    		int columnCount = meta.getColumnCount();
    		
            String[] y = printResultSet(rs, columnCount );
            rs.close();
        } catch(Exception e){
            e.printStackTrace();
        }
        return true;
    }

    public static boolean uservideoinfo_exists(Connection conn, boolean favorito, String rating, String status, int video_id_glob, int video_id_loc, int usuario_id){
        try{
            PreparedStatement statement = conn.prepareStatement(
                "SELECT * FROM uservideoinfo WHERE favorito = ? AND rating = ? AND status = ? AND video_id_glob = ? AND video_id_loc = ? AND usuario_id = ?"
            );

            statement.setBoolean(1, favorito);
            statement.setString(2, rating);
            statement.setString(3, status);
            statement.setInt(4, video_id_glob);
            statement.setInt(5, video_id_loc);
            statement.setInt(6, usuario_id);

            ResultSet rs = statement.executeQuery();
            ResultSetMetaData meta = rs.getMetaData();
    		int columnCount = meta.getColumnCount();
    		
            String[] y = printResultSet(rs, columnCount );
            rs.close();
        } catch(Exception e){
            e.printStackTrace();
        }
        return true;
    }

    public static boolean uservideohistory_exists(Connection conn, Date fecha, int user_video_info_id){
        try{
            PreparedStatement statement = conn.prepareStatement(
                "SELECT * FROM uservideohistory WHERE fecha = ? AND user_video_info_id = ?"
            );

            statement.setDate(1, fecha);
            statement.setInt(2, user_video_info_id);

            ResultSet rs = statement.executeQuery();
            ResultSetMetaData meta = rs.getMetaData();
    		int columnCount = meta.getColumnCount();
    		
            String[] y = printResultSet(rs, columnCount );
            rs.close();
        } catch(Exception e){
            e.printStackTrace();
        }
        return true;
    }
}

