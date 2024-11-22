public class Produto extends EntidadeBase {
    private final String nome;
    private final double preco;

    public Produto(int id, String nome, double preco) {
        super(id);
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    @Override
    public String detalhes() {
        return "ID: " + getId() + " | Nome: " + nome + " | Preço: R$" + String.format("%.2f", preco);
    }
}
