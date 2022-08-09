package jdbcatv.entidades;

public class Sapato {
	private int id;
	private String marca;
	private String tamanho;
	private String cor;
	
	@Override
	public String toString() {
		return "Sapato [id=" + id + ", marca=" + marca + ", tamanho=" + tamanho + ", cor=" + cor + "]";
	}
	public Sapato(String marca, String tamanho, String cor) {
		super();
		this.marca = marca;
		this.tamanho = tamanho;
		this.cor = cor;
	}
	public Sapato() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getTamanho() {
		return tamanho;
	}
	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
		}
}	


	
	
	
	

