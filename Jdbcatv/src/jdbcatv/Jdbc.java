package jdbcatv;

import jdbcatv.dao.DaoSapato;
import jdbcatv.entidades.Sapato;
import jdbcatv.utilidades.Conexao;

public class Jdbc {
	public static void main(String[] args) {
		/*if (Conexao.conectar()!=null) {
			System.out.println("Conectado");
		}
		else {
			System.out.println("Erro ao conectar");
		}*/
		
		Sapato s1 = new Sapato("Moleca", "38","preto");
		DaoSapato ds = new DaoSapato();
		if(ds.salvar(s1)) {
			System.out.println("Sapato cadastrado com sucesso");
		}
	}
}	
			



