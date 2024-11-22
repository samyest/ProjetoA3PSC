public class Cliente extends EntidadeBase {
    private final String nome;
    private final String telefone;

    public Cliente(int id, String nome, String telefone) {
        super(id);
        this.nome = nome;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    @Override
    public String detalhes() {
        return "ID: " + getId() + " | Nome: " + nome + " | Telefone: " + telefone;
    }
}
