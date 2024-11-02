import java.util.ArrayList;
import java.util.List;

public class Aula {
    private String nome;
    private String instrutor;
    private int capacidadeMaxima;
    private List<Membro> membrosInscritos;

    public Aula(String nome, String instrutor, int capacidadeMaxima) {
        this.nome = nome;
        this.instrutor = instrutor;
        this.capacidadeMaxima = capacidadeMaxima;
        this.membrosInscritos = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getInstrutor() {
        return instrutor;
    }

    public int getCapacidadeMaxima() { 
        return capacidadeMaxima;
    }

    public List<Membro> getMembrosInscritos() {
        return membrosInscritos;
    }

    public boolean inscreverMembro(Membro membro) {
        if (membro.isPagamentoEmDia() && membrosInscritos.size() < capacidadeMaxima) {
            membrosInscritos.add(membro);
            return true;
        }
        return false;
    }
}

