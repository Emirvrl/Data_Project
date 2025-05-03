
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ScoreboardF extends JPanel {

    private Image backgroundImage;
    BinarySearchTree bst;

    public ScoreboardF() {
        // Görseli yükle
        ImageIcon icon = new ImageIcon(getClass().getResource("/images/ScoreboardBack.png"));
        backgroundImage = icon.getImage();
        bst = new BinarySearchTree();
        // Layout ayarla
        setLayout(null);
        JLabel titleLabel = new JLabel("SCOREBOARD");
        titleLabel.setFont(new Font("DialogInput", Font.BOLD, 38));
        titleLabel.setForeground(Color.BLACK);
        titleLabel.setBounds(245, 115, 400, 60); // x, y, genişlik, yükseklik
        add(titleLabel);

        // Layout'u dikey şekilde ayarlıyoruz
        setOpaque(false);

        add(Box.createVerticalStrut(50)); // Üst boşluk

        add(Box.createVerticalStrut(30)); // Başlık altı boşluk

        JPanel formPanel = new JPanel();
        formPanel.setLayout(null); // Layout yöneticisi yok, konumları manuel ayarlayacağız
        formPanel.setOpaque(false); // Arka planı saydam yap (isteğe bağlı)

        // Label 1
        JLabel lblUser = new JLabel("Username: ");
        lblUser.setBounds(100, 40, 300, 30); // x=100, y=50, genişlik=300, yükseklik=30
        formPanel.add(lblUser);
        lblUser.setFont(new Font("Segoe UI", Font.BOLD, 15));

        // Label 2
        JLabel lblBest = new JLabel("Best Score: ");
        lblBest.setBounds(100, 80, 300, 30);
        formPanel.add(lblBest);
        lblBest.setFont(new Font("Segoe UI", Font.BOLD, 15));

        // Label 3
        JLabel lblWorst = new JLabel("Worst Score: ");
        lblWorst.setBounds(100, 120, 300, 30);
        formPanel.add(lblWorst);
        lblWorst.setFont(new Font("Segoe UI", Font.BOLD, 15));

        // TextArea 4
        String allScores = "";
        JTextArea txtAllScores = new JTextArea("All Scores:\n" + allScores);
        txtAllScores.setBounds(100, 160, 575, 200);
        txtAllScores.setFont(new Font("Segoe UI", Font.BOLD, 15));
        txtAllScores.setEditable(false);
        txtAllScores.setFocusable(false);
        txtAllScores.setLineWrap(true);
        txtAllScores.setWrapStyleWord(true);

// Şeffaflık için gerekli olanlar:
        txtAllScores.setOpaque(false);
        txtAllScores.setBackground(new Color(0, 0, 0, 0));  // RGB + alfa = 0
        txtAllScores.setBorder(null);

        formPanel.add(txtAllScores);

        add(formPanel);
        formPanel.setBounds(0, 125, 800, 400);

 JButton btnMenu = new JButton("Menu");
btnMenu.setFont(new Font("Segoe UI", Font.BOLD, 15));
btnMenu.setBounds(600, 720, 100, 40); // Daha büyük boyut ve uygun konum
btnMenu.setForeground(Color.BLACK);

btnMenu.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // Mesaj kutusunu göster
        JOptionPane.showMessageDialog(ScoreboardF.this, "Returning to Menu...");
        
        // İçinde bulunduğun pencereyi bul (örneğin bu sınıf bir JPanel ise)
        Window window = SwingUtilities.getWindowAncestor(btnMenu);
        if (window instanceof JFrame) {
            window.dispose(); // Pencereyi kapat
        }

        // Yeni MenuF penceresini başlat
        MenuF menuFrame = new MenuF(); // MenuF, JFrame olmalı
        menuFrame.setVisible(true);
    }
});

this.add(btnMenu); // JPanel veya container içindeysen this'e eklenir

//        formPanel.add(btnMenu);
        // Kullanıcı adı al
        String usernameFilter = JOptionPane.showInputDialog(this, "Username:");
        try (BufferedReader br = new BufferedReader(new FileReader("score.txt"))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String username = parts[0].trim();
                    String level = parts[1].trim();
                    int score = Integer.parseInt(parts[2].trim());

                    if (username.equals(usernameFilter)) {
                        bst.insert(score, username, level);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        allScores = bst.inorder();

        lblUser.setText("Username: " + usernameFilter);
        lblBest.setText("Best Score: " + bst.max());
        lblWorst.setText("Worst Score: " + bst.min());
        txtAllScores.setText("All Scores: " + allScores);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Arka plan görselini çiz
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }

}
