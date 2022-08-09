package jdbcatv.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
			return false;
		}
		finally {
			Conexao.fechar();
		}
		return true;
	}

	@Override
	public boolean alterar(Sapato obj) {
		String sql = "update sapato set "+
                "marca = ?,"+
                "tamanho = ?,"+
                "cor = ? "+
                "where id = ?";
        Connection con = Conexao.conectar();
        try {
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, obj.getMarca());
            stm.setString(2, obj.getTamanho());
            stm.setString(3, obj.getCor());
            stm.setInt(4, obj.getId());
            stm.execute();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        finally {
            Conexao.fechar();
        }
        return true;
	}

	@Override
	public void excluir(int id) {
		String sql = "delete from sapato where id = " + id;
        Connection con = Conexao.conectar();
        try {
            PreparedStatement stm = con.prepareStatement(sql);
            stm.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        finally {
            Conexao.fechar();
        }
		
	}

	@Override
	public Sapato consultar(int id) {
		Sapato sapato = new Sapato();
        String sql = "select * from sapato where id= " + id;
        Connection con = Conexao.conectar();        
        try {
            PreparedStatement stm = con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                sapato.setId(rs.getInt("id"));
                sapato.setMarca(rs.getString("nome"));
                sapato.setTamanho(rs.getString("curso"));
                sapato.setCor(rs.getString("periodo"));
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        finally {
            Conexao.fechar();
        }
        return sapato;
		

		
	}

	@Override
	public List<Sapato> consultar() {
		List<Sapato> sapatos = new ArrayList<>();
        String sql = "select * from aluno";
        
        Connection con = Conexao.conectar();
        try {
            PreparedStatement stm = con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while(rs.next()) {
                Sapato sapato = new Sapato();
                sapato.setId(rs.getInt("id"));
                sapato.setMarca(rs.getString("nome"));
                sapato.setTamanho(rs.getString("curso"));
                sapato.setCor(rs.getString("periodo"));
                sapatos.add((Sapato) sapatos);
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        finally {
            Conexao.fechar();
        }
        return sapatos;
	
	}

}
