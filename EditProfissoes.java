editar profissões

public class App {
    public static void main(String[] args) throws Exception {
        import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ProgramaEdicaoExclusaoProfissional extends JFrame {
    private DefaultListModel<String> listaModel;
    private JList<String> listaProfissionais;
    private JButton botaoEditar;
    private JButton botaoExcluir;
    private JTextField campoNome;

    private List<String> profissionais;

    public ProgramaEdicaoExclusaoProfissional() {
        super("Edição/Exclusão de Profissionais");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        profissionais = new ArrayList<>();
        profissionais.add("Profissional A");
        profissionais.add("Profissional B");
        profissionais.add("Profissional C");

        listaModel = new DefaultListModel<>();
        for (String profissional : profissionais) {
            listaModel.addElement(profissional);
        }

        listaProfissionais = new JList<>(listaModel);
        botaoEditar = new JButton("Editar");
        botaoExcluir = new JButton("Excluir");
        campoNome = new JTextField(20);

        JPanel painelSuperior = new JPanel();
        painelSuperior.add(new JLabel("Profissionais:"));
        painelSuperior.add(new JScrollPane(listaProfissionais));
        painelSuperior.add(botaoEditar);
        painelSuperior.add(botaoExcluir);

        JPanel painelInferior = new JPanel();
        painelInferior.add(new JLabel("Novo Nome:"));
        painelInferior.add(campoNome);

        botaoEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editarProfissional();
            }
        });

        botaoExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                excluirProfissional();
            }
        });

        setLayout(new BorderLayout());
        add(painelSuperior, BorderLayout.CENTER);
        add(painelInferior, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void editarProfissional() {
        int indiceSelecionado = listaProfissionais.getSelectedIndex();
        if (indiceSelecionado != -1) {
            String novoNome = campoNome.getText();
            if (!novoNome.isEmpty()) {
                profissionais.set(indiceSelecionado, novoNome);
                listaModel.set(indiceSelecionado, novoNome);
                campoNome.setText("");
                JOptionPane.showMessageDialog(this, "Profissional editado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(this, "Digite um novo nome válido", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um profissional para editar", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void excluirProfissional() {
        int indiceSelecionado = listaProfissionais.getSelectedIndex();
        if (indiceSelecionado != -1) {
            String profissionalExcluido = profissionais.remove(indiceSelecionado);
            listaModel.remove(indiceSelecionado);
            campoNome.setText("");
            JOptionPane.showMessageDialog(this, "Profissional '" + profissionalExcluido + "' excluído com sucesso!");
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um profissional para excluir", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ProgramaEdicaoExclusaoProfissional();
            }
        });
    }
}