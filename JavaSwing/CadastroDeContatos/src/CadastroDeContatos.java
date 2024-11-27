import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class CadastroDeContatos {
    private JTextField txtNome;
    private JTextField txtTelefone;
    private JTextField txtEmail;
    private JButton btnAddCtt;
    private JList<String> listaContatos;
    private JButton btnRemoverCtt;
    private JPanel panelMain;
    private JLabel lblMensagem;



    DefaultListModel<String> modelo = new DefaultListModel<>();


    public CadastroDeContatos() {

        listaContatos.setModel(modelo); // vincula o modelo com a lista

        btnAddCtt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = txtNome.getText().trim();
                String telefone = txtTelefone.getText().trim();
                String email = txtEmail.getText().trim();


                if(nome.isEmpty() || telefone.isEmpty() || email.isEmpty()){
                    lblMensagem.setText("Todos os campos devem ser preenchidos");
                    return;
                }
                lblMensagem.setText(""); // reseta o label

                String contato = nome + ", " + telefone + ", " + email;

                modelo.addElement(contato); // com esse modelo aq não precisa usar loop para trabalhar com arrays ( e nem arrays )


                txtNome.setText("");
                txtTelefone.setText("");
                txtEmail.setText("");


            }
        });

        btnRemoverCtt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(modelo.getSize() > 0){ // checa se tem algo na lista
                    int ultimoElemento = modelo.getSize() - 1;  // se tiver, pega o último elemento
                    modelo.removeElementAt(ultimoElemento);   // remove o ultimo ( tem q ser removeElementAt pq esse usa o index, o outro espera um objeto
                } else {
                    lblMensagem.setText("Não há contatos para remover");
                }



            }
        });


    }













    public static void main(String[] args) {
        JFrame frame = new JFrame("Cadastro de Contatos");
        frame.setContentPane(new CadastroDeContatos().panelMain);
        frame.pack();
        frame.setVisible(true);

    }
}