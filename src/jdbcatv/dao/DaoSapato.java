package jdbcatv.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import jdbcatv.entidades.Sapato;
import jdbcatv.interfaces.ICrud;
import jdbcatv.utilidades.Conexao;

public class DaoSapato  implements ICrud<Sapato>{

	@Override
	public boolean salvar(Sapato obj) {
		String sql = "insert into sapato (marca, tamanho, cor)values(?,?,?)";
		Connection con = Conexao.conectar();
		try {
			PreparedStatement stm =con.prepareStatement(sql);
			stm.setString(1, obj.getMarca());
			stm.setString(2, obj.getTamanho());
			stm.setString(3, obj.getCor());
			stm.execute();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
	
		}
		return true;
	}

	@Override
	public boolean alterar(Sapato obj) {
		return false;
	}

	@Override
	public void excluir(int id) {
		
	}

	@Override
	public Sapato consultar(int id) {

		return null;
	}

	@Override
	public List<Sapato> consultar() {
	
		return null;
	}

}
