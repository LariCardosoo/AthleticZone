#PAGINA DE LOGIN/CRIAR CONTA

public class App {
    public static void main(String[] args) throws Exception {

        import javax.swing.*;
        import java.awt.*;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;
        import java.util.ArrayList;
        import java.util.List;
        
        public class TelaDeLoginComCriacaoDeConta extends JFrame {
            private JTextField campoUsuario;
            private JPasswordField campoSenha;
            private List<ContaUsuario> contas;
        
            public TelaDeLoginComCriacaoDeConta() {
                super("Tela de Login com Criação de Conta");
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setSize(300, 150);
        
                // Inicializa a lista de contas de usuário
                contas = new ArrayList<>();
                
                JPanel painel = new JPanel();
                painel.setLayout(new GridLayout(4, 2));
        
                JLabel labelUsuario = new JLabel("Usuário:");
                JLabel labelSenha = new JLabel("Senha:");
        
                campoUsuario = new JTextField(20);
                campoSenha = new JPasswordField(20);
        
                JButton botaoLogin = new JButton("Login");
                JButton botaoCriarConta = new JButton("Criar Conta");
        
                botaoLogin.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        fazerLogin();
                    }
                });
        
                botaoCriarConta.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        criarConta();
                    }
                });
        
                painel.add(labelUsuario);
                painel.add(campoUsuario);
                painel.add(labelSenha);
                painel.add(campoSenha);
                painel.add(botaoLogin);
                painel.add(botaoCriarConta);
        
                add(painel);
                pack();
                setLocationRelativeTo(null);
                setVisible(true);
            }
        
            private void fazerLogin() {
                String usuario = campoUsuario.getText();
                String senha = new String(campoSenha.getPassword());
        
                for (ContaUsuario conta : contas) {
                    if (conta.getUsuario().equals(usuario) && conta.getSenha().equals(senha)) {
                        JOptionPane.showMessageDialog(this, "Login bem-sucedido!");
                        return;
                    }
                }
        
                JOptionPane.showMessageDialog(this, "Login falhou. Tente novamente.", "Erro de Login", JOptionPane.ERROR_MESSAGE);
            }
        
            private void criarConta() {
                String novoUsuario = campoUsuario.getText();
                String novaSenha = new String(campoSenha.getPassword());
        
                // Verifique se o usuário já existe
                for (ContaUsuario conta : contas) {
                    if (conta.getUsuario().equals(novoUsuario)) {
                        JOptionPane.showMessageDialog(this, "Este usuário já existe. Escolha outro nome de usuário.", "Erro", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }
        
                // Crie uma nova conta de usuário e adicione à lista
                contas.add(new ContaUsuario(novoUsuario, novaSenha));
                JOptionPane.showMessageDialog(this, "Conta criada com sucesso!");
            }
        
            public static void main(String[] args) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new TelaDeLoginComCriacaoDeConta();
                    }
                });
            }
        }
        
        class ContaUsuario {
            private String usuario;
            private String senha;
        
            public ContaUsuario(String usuario, String senha) {
                this.usuario = usuario;
                this.senha = senha;
            }
        
            public String getUsuario() {
                return usuario;
            }
        
            public String getSenha() {
                return senha;
            }
        }
        }
    }
}
    }
}
