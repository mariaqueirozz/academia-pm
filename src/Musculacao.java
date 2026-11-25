public class Musculacao extends Atividade {
    private int quantidadeAparelhos;

    public Musculacao(String nome, String horario, int duracaoMinutos,
                      int maxParticipantes, int quantidadeAparelhos) {
        super(nome, horario, duracaoMinutos, maxParticipantes);
        this.quantidadeAparelhos = quantidadeAparelhos;
    }

    @Override
    public boolean isIndividual() { return true; }

    public int getQuantidadeAparelhos() { return quantidadeAparelhos; }

    @Override
    public String toString() {
        return "[Musculação] " + super.toString() + " | aparelhos: " + quantidadeAparelhos;
    }
}