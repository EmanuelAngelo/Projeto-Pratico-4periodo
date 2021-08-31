package inicio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conector {
    static String url = "jdbc:mysql://localhost/projeto1.1" ;
    static String usuario = "root";
    static String senha = "";
    static Connection con;
    
    public static Connection getConexao() throws SQLException {//Conexão com o banco de dados//

        try{
            Class.forName("org.gjt.mm.mysql.Driver");
            if(con == null){
                con = DriverManager.getConnection(url,usuario,senha);
            }
            return con;
        }catch(ClassNotFoundException e){
            throw new SQLException(e.getMessage());
        }
    }
}