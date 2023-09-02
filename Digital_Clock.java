import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

class Digital_clock extends JFrame {

    private JLabel timeLabel;
    private JLabel dateLabel;

    public Digital_clock() {
        setTitle("Digital Clock");
        setSize(500, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        // Criando o painel e as datss
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setLayout(new BorderLayout());

        // Criando o display de tempo
        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Arial", Font.PLAIN, 60));
        timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        timeLabel.setVerticalAlignment(SwingConstants.CENTER);
        timeLabel.setForeground(Color.RED);

        // Display da data
        dateLabel = new JLabel();
        dateLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        dateLabel.setHorizontalAlignment(SwingConstants.CENTER);
        dateLabel.setVerticalAlignment(SwingConstants.CENTER);
        dateLabel.setForeground(Color.WHITE);

        // Adicionando tempo e data
        panel.add(timeLabel, BorderLayout.CENTER);
        panel.add(dateLabel, BorderLayout.SOUTH);

        // Cor do painel
        panel.setBackground(Color.BLACK);

        // Adicionando o painel na moldura
        add(panel);

        // Cronometo para atualizar data e hora
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateTimeAndDate();
            }
        });
        timer.start();
    }

    private void updateTimeAndDate() {
        // Obtendo a hora formatada
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat timeFormatter = new SimpleDateFormat("HH:mm:ss");
        String time = timeFormatter.format(calendar.getTime());

        // Obtendo data formatada
        SimpleDateFormat dateFormatter = new SimpleDateFormat("EEE, MMM dd, yyyy");
        String date = dateFormatter.format(calendar.getTime());

        // Atualizar data e hora
        timeLabel.setText(time);
        dateLabel.setText(date);
    }

    public static void main(String[] args) {
        Digital_clock clock = new Digital_clock();
        clock.setVisible(true);
    }
}