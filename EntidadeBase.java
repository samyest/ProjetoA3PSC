public abstract class EntidadeBase {
    private final int id;

    public EntidadeBase(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public abstract String detalhes();
}
