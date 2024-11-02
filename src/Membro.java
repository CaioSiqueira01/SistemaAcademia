public class Membro {
    private String nome;
    private int id;
    private boolean pagamentoEmDia;

    public Membro(String nome, int id, boolean pagamentoEmDia) {
        this.nome = nome;
        this.id = id;
        this.pagamentoEmDia = pagamentoEmDia;
    }

    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }

    public boolean isPagamentoEmDia() {
        return pagamentoEmDia;
    }

    public void setPagamentoEmDia(boolean pagamentoEmDia) {
        this.pagamentoEmDia = pagamentoEmDia;
    }
}
