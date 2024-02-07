package View;

import Controller.ElevadorControl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JanelaPrincipal extends JFrame {
    private ElevadorControl elevadorControl;
    private JButton[] andaresButtons;
    private JLabel[] elevadoresLabels;
    private JTextField txtAndarChamada;
    private JTextArea txtAreaStatus;

    public JanelaPrincipal() {
        elevadorControl = new ElevadorControl(null);

        // Configurações gerais da janela
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centraliza a janela na tela

        // Adiciona o campo de texto para informar o andar de chamada no painel norte
        JPanel panelAndarChamada = new JPanel(new FlowLayout());
        txtAndarChamada = new JTextField(5);
        JButton btnChamarElevador = new JButton("Chamar Elevador");
        btnChamarElevador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chamarElevador();
            }
        });
        panelAndarChamada.add(new JLabel("Andar de Chamada: "));
        panelAndarChamada.add(txtAndarChamada);
        panelAndarChamada.add(btnChamarElevador);

        // Adiciona os botões dos andares no painel norte
        JPanel panelAndares = new JPanel(new FlowLayout());
        andaresButtons = new JButton[9];

        for (int i = -2; i <= 6; i++) {
            andaresButtons[i + 2] = new JButton(String.valueOf(i));
            andaresButtons[i + 2].setPreferredSize(new Dimension(50, 30));
            int andar = i;
            andaresButtons[i + 2].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    chamarElevador(andar);
                }
            });
            panelAndares.add(andaresButtons[i + 2]);
        }

        // Adiciona os rótulos dos elevadores no painel oeste
        JPanel panelElevadores = new JPanel(new GridLayout(2, 1));
        elevadoresLabels = new JLabel[2];

        for (int i = 0; i < 2; i++) {
            elevadoresLabels[i] = new JLabel("Elevador " + (i + 1));
            elevadoresLabels[i].setHorizontalAlignment(SwingConstants.CENTER);
            panelElevadores.add(elevadoresLabels[i]);
        }

        // Adiciona a área de texto para exibir o status dos elevadores
        txtAreaStatus = new JTextArea(10, 20);
        txtAreaStatus.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(txtAreaStatus);

        // Adiciona os painéis ao layout principal
        add(panelAndarChamada, BorderLayout.NORTH);
        add(panelAndares, BorderLayout.CENTER);
        add(panelElevadores, BorderLayout.WEST);
        add(scrollPane, BorderLayout.SOUTH);

        // Configurações gerais da janela
        pack(); // Ajusta o tamanho da janela automaticamente
    }

    private void chamarElevador(int andarChamada) {
        elevadorControl.chamarElevador(andarChamada, txtAreaStatus);
        atualizarRepresentacaoVisual();
    }

    private void chamarElevador() {
        try {
            int andarChamada = Integer.parseInt(txtAndarChamada.getText());
            chamarElevador(andarChamada);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Informe um número válido para o andar.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void atualizarRepresentacaoVisual() {
        // Atualiza a representação visual dos elevadores
        for (int i = 0; i < 2; i++) {
            elevadoresLabels[i].setText("Elevador " + (i + 1) + " - Andar " + elevadorControl.getAndarElevador(i));
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new JanelaPrincipal().setVisible(true);
            }
        });
    }
}
