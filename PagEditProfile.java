public class App {
    public static void main(String[] args) throws Exception {
        import javax.swing.*;
        import java.awt.*;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;
        
        public class ProgramaEdicaoPerfil extends JFrame {
            private JTextField campoNome;
            private JTextField campoEmail;
            private JTextArea campoDescricao;
        
            public ProgramaEdicaoPerfil() {
                super("Edição de Perfil");
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setSize(400, 300);
        
                JPanel painel = new JPanel();
                painel.setLayout(new GridLayout(4, 2));
        
                JLabel labelNome = new JLabel("Nome:");
                JLabel labelEmail = new JLabel("Email:");
                JLabel labelDescricao = new JLabel("Telefone:");
        
                campoNome = new JTextField(20);
                campoEmail = new JTextField(20);
                campoDescricao = new JTextArea(4, 20);
        
                JButton botaoSalvar = new JButton("Salvar");
        
                botaoSalvar.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        salvarPerfil();
                    }
                });
        
                painel.add(labelNome);
                painel.add(campoNome);
                painel.add(labelEmail);
                painel.add(campoEmail);
                painel.add(labelTelefone);
                painel.add(new JScrollPane(campoTelefone));
                painel.add(new JLabel());
                painel.add(botaoSalvar);
        
                add(painel);
                setLocationRelativeTo(null);
                setVisible(true);
            }
        
            private void salvarPerfil() {
                String nome = campoNome.getText();
                String email = campoEmail.getText();
                String descricao = campoTelefone.getText();
        
        
                JOptionPane.showMessageDialog(this, "Perfil salvo com sucesso!");
            }
        
            public static void main(String[] args) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new ProgramaEdicaoPerfil();
                    }
                });
            }
        }