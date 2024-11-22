import java.util.ArrayList;

public class Pedido extends EntidadeBase {
    private final Cliente cliente;
    private final ArrayList <ItemPedido> itens;
    private double total;

    public Pedido(int id, Cliente cliente) {
        super(id);
        this.cliente = cliente;
        this.itens = new ArrayList<>();
        this.total = 0;
    }

    public void adicionarItem(ItemPedido item) {
        itens.add(item);
        total += item.calcularSubtotal();
    }

    public double getTotal() {
        return total;
    }

    @Override
    public String detalhes() {
        StringBuilder detalhes = new StringBuilder();
        detalhes.append("Pedido ID: ").append(getId())
                .append(" | Cliente: ").append(cliente.getNome())
                .append(" | Total: R$").append(String.format("%.2f", total)).append("\nItens:\n");
        for (ItemPedido item : itens) {
            detalhes.append("  ").append(item.detalhes()).append("\n");
        }
        return detalhes.toString();
    }
}
