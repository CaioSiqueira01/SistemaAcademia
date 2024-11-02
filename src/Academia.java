import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Academia {
    private List<Membro> membros;
    private List<Aula> aulas;
    private List<RegistroFrequencia> registrosFrequencia;

    public Academia() {
        this.membros = new ArrayList<>();   
        this.aulas = new ArrayList<>();
        this.registrosFrequencia = new ArrayList<>();
    }

    public List<Aula> getAulas() {
        return aulas;
    }

    public void adicionarMembro(Membro membro) {
        membros.add(membro);
    }

    public void adicionarAula(Aula aula) {
        aulas.add(aula);
    }

    public boolean inscreverMembroEmAula(int idMembro, String nomeAula) {
        Membro membro = buscarMembroPorId(idMembro);
        Aula aula = buscarAulaPorNome(nomeAula);

        if (membro != null && aula != null) {
            return aula.inscreverMembro(membro);
        }
        return false;
    }

    public void registrarFrequencia(int idMembro, String nomeAula, Date data) {
        Membro membro = buscarMembroPorId(idMembro);
        Aula aula = buscarAulaPorNome(nomeAula);

        if (membro != null && aula != null && aula.getMembrosInscritos().contains(membro)) {
            registrosFrequencia.add(new RegistroFrequencia(aula, membro, data));
        }
    }

    public List<RegistroFrequencia> listarRegistrosFrequencia() {
        return registrosFrequencia;
    }

    private Membro buscarMembroPorId(int id) {
        for (Membro membro : membros) {
            if (membro.getId() == id) {
                return membro;
            }
        }
        return null;
    }

    private Aula buscarAulaPorNome(String nome) {
        for (Aula aula : aulas) {
            if (aula.getNome().equals(nome)) {
                return aula;
            }
        }
        return null;
    }
}
