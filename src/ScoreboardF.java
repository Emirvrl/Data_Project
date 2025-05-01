/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author EmirV
 */
import javax.swing.*;
import java.awt.*;

public class ScoreboardF extends JPanel {

    private Image backgroundImage;

    public ScoreboardF() {
        // Görseli yükle
        ImageIcon icon = new ImageIcon(getClass().getResource("/images/ScoreboardBack.png"));
        backgroundImage = icon.getImage();

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

// Label 4
        JLabel lblAll = new JLabel("All Scores:");
        lblAll.setBounds(100, 160, 400, 30);
        formPanel.add(lblAll);
        lblAll.setFont(new Font("Segoe UI", Font.BOLD, 15));

        
        add(formPanel);
        formPanel.setBounds(0, 125, 800, 400); // formPanel’in konumunu ve boyutunu ayarlıyoruz
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Arka plan görselini çiz
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }
}
