package Controller;

import Model.Elevador;

import javax.swing.*;
import javax.swing.text.DefaultCaret;
import java.util.ArrayList;
import java.util.List;

public class ElevadorControl {
    private List<Elevador> elevadores;
    private JTextArea txtAreaStatus;

    public ElevadorControl(JTextArea txtAreaStatus) {
        this.elevadores = new ArrayList<>();
        this.txtAreaStatus = txtAreaStatus;
        // Inicializa os elevadores
        inicializarElevadores();
    }

    public void inicializarElevadores() {
        elevadores.add(new Elevador("Elevador 1"));
        elevadores.add(new Elevador("Elevador 2"));
    }

    public void chamarElevador(int andarChamada, JTextArea txtAreaStatus) {
        validarAndar(andarChamada);

        Elevador elevadorMaisProximo = encontrarElevadorMaisProximo(andarChamada);
        int andarAtual = elevadorMaisProximo.getAndarAtual();

        // Adiciona mensagem ao JTextArea
        txtAreaStatus.append(String.format("Chamada para o Elevador %s do andar %d.\n", elevadorMaisProximo.getNome(), andarChamada));

        elevadorMaisProximo.mover(andarChamada);

        // Adiciona mensagem ao JTextArea
        txtAreaStatus.append(String.format("Elevador %s a caminho do andar %d.\n", elevadorMaisProximo.getNome(), andarChamada));

        // Atualiza a tabela de exibição após o movimento do elevador
        atualizarTabela();
    }

    private Elevador encontrarElevadorMaisProximo(int andarChamada) {
        Elevador elevadorMaisProximo = elevadores.get(0);
        int menorDistancia = Math.abs(andarChamada - elevadorMaisProximo.getAndarAtual());

        for (Elevador elevador : elevadores) {
            int distanciaAtual = Math.abs(andarChamada - elevador.getAndarAtual());
            if (distanciaAtual < menorDistancia) {
                menorDistancia = distanciaAtual;
                elevadorMaisProximo = elevador;
            }
        }

        return elevadorMaisProximo;
    }

    private void atualizarTabela() {
        // Atualiza a tabela de exibição com dados dos elevadores
        for (Elevador elevador : elevadores) {
            // Adiciona os dados de cada elevador como uma nova linha na tabela Swing
            txtAreaStatus.append(String.format("Elevador %s - Andar %d.\n", elevador.getNome(), elevador.getAndarAtual()));
        }
    }

    private void validarAndar(int andar) {
        if (andar < -2 || andar > 6) {
            throw new IllegalArgumentException("Andar inválido. Escolha um andar entre -2 e 6.");
        }
    }

    public int getAndarElevador(int i) {
        return elevadores.get(i).getAndarAtual();
    }
}
