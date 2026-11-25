public abstract class Atividade {
    private String nome;
    private String horario;
    private int duracaoMinutos;
    private int maxParticipantes;
    private StatusAtividade status;

    public Atividade(String nome, String horario, int duracaoMinutos, int maxParticipantes) {
        this.nome = nome;
        this.horario = horario;
        this.duracaoMinutos = duracaoMinutos;
        this.maxParticipantes = maxParticipantes;
        this.status = StatusAtividade.ATIVA;
    }

    public abstract boolean isIndividual();

    public String getNome() { return nome; }
    public String getHorario() { return horario; }
    public int getDuracaoMinutos() { return duracaoMinutos; }
    public int getMaxParticipantes() { return maxParticipantes; }
    public StatusAtividade getStatus() { return status; }
    public void setStatus(StatusAtividade status) { this.status = status; }

    @Override
    public String toString() {
        return nome + " | " + horario + " | " + duracaoMinutos + " min | máx. "
                + maxParticipantes + " | " + status;
    }
}