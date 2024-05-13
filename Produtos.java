
public class Produtos {

	private long codBarra;
	private String nome;
	private int quantidade;
	private double valor;
	
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
		
		public void cadastrarProduto(long codBarra, String nome, int quantidade, double valor){
			setCodBarra(codBarra);
			setNome(nome);
			setQuantidade(quantidade);
			setValor(valor);
			
		}
		public void ListarProdutos(){
			System.out.println("Codigo de Barra: " + this.codBarra);
			System.out.println("Nome do Produto: " + this.nome);
			System.out.println("Quantidades: " + this.quantidade);
			System.out.println("Valor: " + this.valor);
		}
		
		
}
