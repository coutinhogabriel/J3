package Model;

public class Elevador {
    // Atributos
    private String nome;
    private int andarAtual;

    // Construtor
    public Elevador(String nome) {
        this.nome = nome;
        this.andarAtual = 0; // Inicializa no térreo
    }

    // Métodos getters e setters
    public String getNome() {
        return nome;
    }

    public int getAndarAtual() {
        return andarAtual;
    }

    public void setAndarAtual(int andarAtual) {
        this.andarAtual = andarAtual;
    }

    // Método para mover o elevador para um determinado andar
    public void mover(int novoAndar) {
        validarAndar(novoAndar);
        this.andarAtual = novoAndar;
    }

    // Método para validar o andar
    private void validarAndar(int andar) {
        if (andar < -2 || andar > 6) {
            throw new IllegalArgumentException("Andar inválido. Escolha um andar entre -2 e 6.");
        }
    }
}
