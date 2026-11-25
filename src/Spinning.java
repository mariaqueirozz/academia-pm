import java.util.ArrayList;
import java.util.List;

public class Spinning extends Atividade implements ControladorPresenca {
    private int quantidadeBicicletas;
    private List<String> presentes = new ArrayList<>();

    public Spinning(String nome, String horario, int duracaoMinutos,
                    int maxParticipantes, int quantidadeBicicletas) {
        super(nome, horario, duracaoMinutos, maxParticipantes);
        this.quantidadeBicicletas = quantidadeBicicletas;
    }

    @Override
    public boolean isIndividual() { return false; }

    @Override
    public void registrarPresenca(String nomeParticipante) {
        if (presentes.size() >= quantidadeBicicletas) {
            System.out.println("Sem bicicletas disponíveis.");
            return;
        }
        presentes.add(nomeParticipante);
        System.out.println("Presença registrada no spinning: " + nomeParticipante);
    }

    @Override
    public String toString() {
        return "[Spinning] " + super.toString() + " | bicicletas: " + quantidadeBicicletas;
    }
}