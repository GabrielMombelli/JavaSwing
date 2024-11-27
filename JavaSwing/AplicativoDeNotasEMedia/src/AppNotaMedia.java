import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AppNotaMedia {

    private JPanel panelPrincipal;
    private JTextField txtcampoNota;
    private JButton btnAdicionarNota;
    private JButton btnCalcularMedia;
    private JTextArea areaNotas;
    private JLabel lblResultado;

    private ArrayList<Double> notas = new ArrayList<>();

    public AppNotaMedia() {

        btnAdicionarNota.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String textoNota = txtcampoNota.getText();

                if (numeroValido(textoNota)) {
                    double nota = Double.parseDouble(textoNota);
                    notas.add(nota);
                    areaNotas.append("Nota: " + nota + "\n");
                    txtcampoNota.setText("");
                }
            }
        });

        btnCalcularMedia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                double soma = 0;
                for (double nota : notas) {
                    soma += nota;
                }

                double media = soma / notas.size();

                String status = (media >= 7.0) ? "Aprovado" : "Reprovado";

                lblResultado.setText(String.format("Média: %.2f    Status: %s", media, status));
            }
        });
    }


    private boolean numeroValido(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("Aplicativo de Notas");
        frame.setContentPane(new AppNotaMedia().panelPrincipal);
        frame.pack();
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}