package conexao_login_aluno;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import inicio.Conector;

public class ConexaoAluno {
	public boolean teste;
	public ResultSet r;
	public String nome;
	public  static int idalunos;
public void logar (String n,String m ){
		
		String sql = "select * from alunos where matricula ='"+n+"' and data_nascimento ='"+m+"'";
		
		try {
			PreparedStatement ps =Conector.getConexao().prepareStatement(sql);
			
			r = ps.executeQuery();
			
			ps.execute();
			if (r.next()){
				
				nome = r.getString("nome");
				this.idalunos = r.getInt("idalunos");
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




	

