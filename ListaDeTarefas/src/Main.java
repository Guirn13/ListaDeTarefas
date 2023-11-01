import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.DefaultListModel;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Main extends JFrame implements ActionListener {
    private ArrayList<String> tarefas = new ArrayList<>();
    private DefaultListModel<String> tarefasListModel = new DefaultListModel<>();
    private JList<String> tarefasList;

    public static void main(String[] args) {
        Main app = new Main();
        app.createUI();
    }

    public void createUI() {
        JFrame jf = new JFrame("Lista de Tarefas");
        inserirIcon(jf);
        jf.setSize(410, 300);
        jf.setLocationRelativeTo(null);
        jf.setResizable(false);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        jf.add(panel);

        panel.setLayout(null);
        panel.setBackground(new Color(197, 197, 197));

        tarefasList = new JList<>(tarefasListModel);
        JScrollPane tarefasScrollPane = new JScrollPane(tarefasList);
        tarefasScrollPane.setBounds(50, 30, 300, 150);
        panel.add(tarefasScrollPane);

        JButton adicionarButton = new JButton("Adicionar Tarefa");
        adicionarButton.setBounds(50, 200, 150, 30);
        adicionarButton.addActionListener(this);
        panel.add(adicionarButton);
        adicionarButton.setBackground(new Color(87, 87, 87));
        adicionarButton.setForeground(new Color(255, 255, 255));

        JButton removerButton = new JButton("Remover Tarefa");
        removerButton.setBounds(200, 200, 150, 30);
        removerButton.addActionListener(this);
        panel.add(removerButton);
        removerButton.setBackground(new Color(87, 87, 87));
        removerButton.setForeground(new Color(255, 255, 255));

        jf.setVisible(true);
    }

    public void inserirIcon(JFrame frm) {
        try {
            frm.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/logo.png")));
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();

        if ("Adicionar Tarefa".equals(actionCommand)) {
            String novaTarefa = JOptionPane.showInputDialog("Digite a tarefa:");
            if (novaTarefa != null && !novaTarefa.isEmpty()) {
                tarefas.add(novaTarefa);
                tarefasListModel.addElement(novaTarefa);
            }
        } else if ("Remover Tarefa".equals(actionCommand)) {
            int selectedIndex = tarefasList.getSelectedIndex();
            if (selectedIndex != -1) {
                tarefas.remove(selectedIndex);
                tarefasListModel.remove(selectedIndex);
            }
        }
    }
}
