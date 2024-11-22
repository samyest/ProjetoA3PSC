import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final Cadastro<Cliente> clientes = new Cadastro<>();
    private static final Cadastro<Produto> produtos = new Cadastro<>();
    private static final Cadastro<Pedido> pedidos = new Cadastro<>();

    public static void main(String[] args) {
        while (true) {
            mostrarMenu();
            int opcao = lerInteiro("Escolha uma opção: ");
            sc.nextLine(); // Limpa a nova linha após a entrada de um número
            if (opcao == 0) {
                System.out.println("Saindo... Obrigado por usar o sistema!");
                break;
            }
            executarOpcao(opcao);
        }
    }

    private static void mostrarMenu() {
        System.out.println("\n===== Sistema de Delivery =====");
        System.out.println("1. Cadastrar Cliente");
        System.out.println("2. Cadastrar Produto");
        System.out.println("3. Fazer Pedido");
        System.out.println("4. Listar Pedidos");
        System.out.println("0. Sair");
    }

    private static void executarOpcao(int opcao) {
        switch (opcao) {
            case 1 -> cadastrarCliente();
            case 2 -> cadastrarProduto();
            case 3 -> fazerPedido();
            case 4 -> pedidos.listar();
            default -> System.out.println("Opção inválida. Tente novamente.");
        }
    }

    private static void cadastrarCliente() {
        String nome = lerTexto("Nome do Cliente: ");
        String telefone = lerTexto("Telefone: ");
        int id = clientes.getQuantidade() + 1; // Método auxiliar para obter o tamanho da lista
        clientes.adicionar(new Cliente(id, nome, telefone));
        System.out.println("Cliente cadastrado com sucesso!");
    }

    private static void cadastrarProduto() {
        String nome = lerTexto("Nome do Produto: ");
        double preco = lerDouble("Preço: ");
        int id = produtos.getQuantidade() + 1; // Gera o ID com base no tamanho da lista
        produtos.adicionar(new Produto(id, nome, preco));
        System.out.println("Produto cadastrado com sucesso!");
    }

    private static void fazerPedido() {
        int idCliente = lerInteiro("ID do Cliente: ");
        sc.nextLine(); // Limpa a nova linha após a entrada
        Cliente cliente = clientes.buscarPorIdInterno(idCliente);
        if (cliente == null) {
            System.out.println("Cliente não encontrado.");
            return;
        }

        Pedido pedido = new Pedido(pedidos.getQuantidade() + 1, cliente);
        while (true) {
            int idProduto = lerInteiro("ID do Produto (0 para finalizar): ");
            sc.nextLine(); // Limpa a nova linha após a entrada
            if (idProduto == 0) break;

            Produto produto = produtos.buscarPorIdInterno(idProduto);
            if (produto == null) {
                System.out.println("Produto não encontrado.");
                continue;
            }

            int quantidade = lerInteiro("Quantidade: ");
            sc.nextLine(); // Limpa a nova linha após a entrada
            if (quantidade <= 0) {
                System.out.println("Quantidade inválida.");
                continue;
            }

            pedido.adicionarItem(new ItemPedido(produto, quantidade));
        }
        pedidos.adicionar(pedido);
        System.out.println("Pedido registrado com sucesso!");
    }

    private static String lerTexto(String mensagem) {
        System.out.print(mensagem);
        return sc.nextLine().trim();
    }

    private static int lerInteiro(String mensagem) {
        System.out.print(mensagem);
        while (!sc.hasNextInt()) {
            System.out.print("Entrada inválida. " + mensagem);
            sc.next();
        }
        return sc.nextInt();
    }

    private static double lerDouble(String mensagem) {
        System.out.print(mensagem);
        while (!sc.hasNextDouble()) {
            System.out.print("Entrada inválida. " + mensagem);
            sc.next();
        }
        return sc.nextDouble();
    }
}
