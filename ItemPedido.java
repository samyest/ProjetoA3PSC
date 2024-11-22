public class ItemPedido {
    private final Produto produto;
    private final int quantidade;

    public ItemPedido(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public double calcularSubtotal() {
        return produto.getPreco() * quantidade;
    }

    public String detalhes() {
        return "Produto: " + produto.getNome() + " | Quantidade: " + quantidade + " | Subtotal: R$" + String.format("%.2f", calcularSubtotal());
    }
}
