package objetos;

public class Produtos {
	private long codBarra;
	private String nome;
	private int quantidade;
	private double valor;
	
	// Metodos Getrs e Setrs 
		public long getCodBarra() {
			return codBarra;
		}
		public void setCodBarra(long codBarra) {
			this.codBarra = codBarra;
		}
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public int getQuantidade() {
			return quantidade;
		}
		public void setQuantidade(int quantidade) {
			this.quantidade = quantidade;
		}
		public double getValor() {
			return valor;
		}	
		public void setValor(double valor) {
			this.valor = valor;
		}
}