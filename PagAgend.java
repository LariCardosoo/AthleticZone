public class App {
    public static void main(String[] args) throws Exception {
        import javax.swing.*;
        import java.awt.*;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;
        import java.text.SimpleDateFormat;
        import java.util.ArrayList;
        import java.util.Date;
        import java.util.List;
        
        public class ProgramaDeAgendamentoComProfissional extends JFrame {
            private List<Agendamento> agendamentos;
            private DefaultListModel<String> listaModel;
            private JList<String> listaAgendamentos;
            private JButton botaoAgendar;
            private JTextField campoNome;
            private JComboBox<String> comboHorario;
            private JComboBox<String> comboProfissional;
        
            public ProgramaDeAgendamentoComProfissional() {
                super("Programa de Agendamento com Profissionais");
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setSize(400, 300);
                setLayout(new BorderLayout());
        
                agendamentos = new ArrayList<>();
                listaModel = new DefaultListModel<>();
                listaAgendamentos = new JList<>(listaModel);
                botaoAgendar = new JButton("Agendar");
                campoNome = new JTextField(20);
                comboHorario = new JComboBox<>(new String[]{"09:00", "10:00", "11:00", "14:00", "15:00", "16:00"});
                comboProfissional = new JComboBox<>(new String[]{"Profissional A", "Profissional B"});
        
                JPanel painelSuperior = new JPanel();
                painelSuperior.add(new JLabel("Nome: "));
                painelSuperior.add(campoNome);
                painelSuperior.add(new JLabel("Horário: "));
                painelSuperior.add(comboHorario);
                painelSuperior.add(new JLabel("Profissional: "));
                painelSuperior.add(comboProfissional);
                painelSuperior.add(botaoAgendar);
        
                add(painelSuperior, BorderLayout.NORTH);
                add(new JScrollPane(listaAgendamentos), BorderLayout.CENTER);
        
                botaoAgendar.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        agendarHorario();
                    }
                });
        
                setVisible(true);
            }
        
            private void agendarHorario() {
                String nome = campoNome.getText();
                String horarioSelecionado = (String) comboHorario.getSelectedItem();
                String profissionalSelecionado = (String) comboProfissional.getSelectedItem();
                Date horario = parseHorario(horarioSelecionado);
        
                if (horario == null) {
                    JOptionPane.showMessageDialog(this, "Horário inválido", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }
        
                if (horarioEstaDisponivel(horario, profissionalSelecionado)) {
                    Agendamento agendamento = new Agendamento(nome, horario, profissionalSelecionado);
                    agendamentos.add(agendamento);
                    listaModel.addElement(agendamento.toString());
                    JOptionPane.showMessageDialog(this, "Agendamento realizado com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(this, "Horário já está agendado para o profissional " + profissionalSelecionado, "Erro", JOptionPane.ERROR_MESSAGE);
                }
        
                campoNome.setText("");
            }
        
            private Date parseHorario(String horario) {
                try {
                    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
                    return sdf.parse(horario);
                } catch (Exception e) {
                    return null;
                }
            }
        
            private boolean horarioEstaDisponivel(Date horario, String profissional) {
                for (Agendamento agendamento : agendamentos) {
                    if (agendamento.getHorario().equals(horario) && agendamento.getProfissional().equals(profissional)) {
                        return false;
                    }
                }
                return true;
            }
        
            public static void main(String[] args) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new ProgramaDeAgendamentoComProfissional();
                    }
                });
            }
        }
        
        class Agendamento {
            private String nome;
            private Date horario;
            private String profissional;
        
            public Agendamento(String nome, Date horario, String profissional) {
                this.nome = nome;
                this.horario = horario;
                this.profissional = profissional;
            }
        
            public String getNome() {
                return nome;
            }
        
            public Date getHorario() {
                return horario;
            }
        
            public String getProfissional() {
                return profissional;
            }
        
            @Override
            public String toString() {
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
                return nome + " - " + sdf.format(horario) + " - " + profissional;
            }
        }
      