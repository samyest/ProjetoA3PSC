import java.util.ArrayList;

public class Cadastro<T extends EntidadeBase> implements InterfaceOperacoes {
    private final ArrayList<T> lista;

    public Cadastro() {
        this.lista = new ArrayList<>();
    }

    public void adicionar(T obj) {
        lista.add(obj);
    }

    public T buscarPorIdInterno(int id) {
        return lista.stream().filter(obj -> obj.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void cadastrar() {
        System.out.println("Cadastro deve ser implementado na classe Main.");
    }

    @Override
    public void listar() {
        if (lista.isEmpty()) {
            System.out.println("Nenhum registro encontrado.");
            return;
        }
        lista.forEach(obj -> System.out.println(obj.detalhes()));
    }

    @Override
    public void buscarPorId(int id) {
        T obj = buscarPorIdInterno(id);
        if (obj != null) {
            System.out.println(obj.detalhes());
        } else {
            System.out.println("Objeto com ID " + id + " não encontrado.");
        }
    }

    int getQuantidade() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
