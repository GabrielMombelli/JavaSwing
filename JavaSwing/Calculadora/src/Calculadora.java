import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculadora {
    private JButton btnLimpar;
    private JButton btnMultiplicar;
    private JButton btnDividir;
    private JButton btnSubtrair;
    private JButton btn7;
    private JButton btn8;
    private JButton btn9;
    private JButton btnSomar;
    private JButton btn6;
    private JButton btn1;
    private JButton btn5;
    private JButton btn2;
    private JButton btn4;
    private JButton btn3;
    private JButton btnResultado;
    private JButton btn0;
    private JTextField txtNumTela;
    private JPanel panelMain;


    private CalcOperations calcOperations = new CalcOperations();


    public  void digita(String texto){
        if(txtNumTela.getText().equals("0")){
            txtNumTela.setText(texto);
        } else {
            txtNumTela.setText(txtNumTela.getText().concat(texto));
        }
    }



    public void limpa(){
        txtNumTela.setText("0.0");
    }



    public static class CalcOperations {


        public String operacao;
        public Double total;




        public void setOperacao(String operacao, double valor) {
            this.operacao = operacao;
            this.total = valor;
        }

        // chega qual operação é para realizar, e a executa
        public double realizaOperacao(double valor){
            if(operacao.equals("soma")){
                total+=valor;
            }else if(operacao.equals("subtrair")){
                total -= valor;
            }else if(operacao.equals("dividir")){
                total /= valor;
            }else if(operacao.equals("multiplicar")){
                total *= valor;
            }
            return total;
        }


        public Double getTotal(){
            return this.total;
        }


        public void zerar(){
            total = 0.0;
        }
    }

    public Calculadora(){

        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                digita("1");
            }
        });
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                digita("2");
            }
        });
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                digita("3");
            }
        });
        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                digita("4");
            }
        });
        btn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                digita("5");
            }
        });
        btn6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                digita("6");
            }
        });
        btn7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                digita("7");
            }
        });
        btn8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                digita("8");
            }
        });
        btn9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                digita("9");
            }
        });
        btn0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                digita("0");
            }
        });

        btnLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpa();
            }
        });

        btnSomar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double valorAtual = Double.parseDouble(txtNumTela.getText());
                calcOperations.setOperacao("soma", valorAtual);
                txtNumTela.setText("0");
            }
        });
        btnSubtrair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double valorAtual = Double.parseDouble(txtNumTela.getText());
                calcOperations.setOperacao("subtrair", valorAtual);
                // limpa a tela para o prox num
                txtNumTela.setText("0");
            }
        });

        btnMultiplicar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double valorAtual = Double.parseDouble(txtNumTela.getText());
                calcOperations.setOperacao("multiplicar", valorAtual);
                txtNumTela.setText("0");
            }
        });
        btnDividir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double valorAtual = Double.parseDouble(txtNumTela.getText());
                calcOperations.setOperacao("dividir", valorAtual);
                txtNumTela.setText("0");
            }
        });

        btnResultado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double valorAtual = Double.parseDouble(txtNumTela.getText());
                double resultado = calcOperations.realizaOperacao(valorAtual);

                txtNumTela.setText(Double.toString(resultado));

                calcOperations.zerar();
            }
        });


    }




    public static void main(String[] args) {
        JFrame frame = new JFrame("calculadora");
        frame.setContentPane(new Calculadora().panelMain);
        frame.pack();
        frame.setVisible(true);
    }
}