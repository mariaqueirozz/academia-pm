import java.util.ArrayList;
import java.util.List;

public class Natacao extends Atividade implements Certificavel, ControladorPresenca {
    private double profundidadePiscina;
    private List<String> presentes = new ArrayList<>();

    public Natacao(String nome, String horario, int duracaoMinutos,
                   int maxParticipantes, double profundidadePiscina) {
        super(nome, horario, duracaoMinutos, maxParticipantes);
        this.profundidadePiscina = profundidadePiscina;
    }

    @Override
    public boolean isIndividual() { return false; }

    @Override
    public void emitirCertificado(String nomeParticipante) {
        System.out.println("Certificado de natação emitido para " + nomeParticipante + ".");
    }

    @Override
    public void registrarPresenca(String nomeParticipante) {
        if (presentes.size() >= getMaxParticipantes()) {
            System.out.println("Turma lotada.");
            return;
        }
        presentes.add(nomeParticipante);
        System.out.println("Presença registrada na natação: " + nomeParticipante);
    }

    @Override
    public String toString() {
        return "[Natação] " + super.toString() + " | profundidade: " + profundidadePiscina + " m";
    }
}