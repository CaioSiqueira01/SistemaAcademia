import java.util.Date;

public class RegistroFrequencia {
    private Aula aula;
    private Membro membro;
    private Date data;

    public RegistroFrequencia(Aula aula, Membro membro, Date data) {
        this.aula = aula;
        this.membro = membro;
        this.data = data;
    }

    public Aula getAula() {
        return aula;
    }

    public Membro getMembro() {
        return membro;
    }

    public Date getData() {
        return data;
    }
}
