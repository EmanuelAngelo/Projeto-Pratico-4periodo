package conexao_login_professor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import inicio.Conector;

public class Conecta {
	public boolean teste;
	public ResultSet r;
	public String nome;
	public  static int idprof ;
public void salvar (String login,String senha ){
		
		String sql = "select * from professor where login ='"+login+"' and senha ='"+senha+"'";
		
		try {
			PreparedStatement ps =Conector.getConexao().prepareStatement(sql);
			
			r = ps.executeQuery();
			
			ps.execute();
			if (r.next()){
				
				nome = r.getString("nome_prof");
				this.idprof = r.getInt("idprofessor");
				teste =  true;
			}else{
				teste = false;
			}
					
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

}
}




	

