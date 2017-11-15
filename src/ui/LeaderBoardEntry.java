package ui;
import java.util.ArrayList;

public class LeaderBoardEntry extends javax.swing.JPanel
{
    public LeaderBoardEntry()
    {
        initComponents();
    }
    
    LeaderBoardEntry(String key, int score, int loss, int draw)
    {
        initComponents();
        player1.setText(s.get(1));
        player2.setText(s.get(2));
        if(s.get(3).equals("3"))
            outcome.setText("Draw");
        else if(s.get(3).equals("0"))
            outcome.setText("N/A");
        else
            outcome.setText(s.get(Integer.parseInt(s.get(3))));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        playerName = new javax.swing.JLabel();
        winsLabel = new javax.swing.JLabel();
        lossesLabel = new javax.swing.JLabel();
        drawsLabel = new javax.swing.JLabel();

        setLayout(new java.awt.GridLayout(1, 4));

        playerName.setText("Player");
        add(playerName);

        winsLabel.setText("Wins");
        add(winsLabel);

        lossesLabel.setText("Losses");
        add(lossesLabel);

        drawsLabel.setText("Draws");
        add(drawsLabel);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel drawsLabel;
    private javax.swing.JLabel lossesLabel;
    private javax.swing.JLabel playerName;
    private javax.swing.JLabel winsLabel;
    // End of variables declaration//GEN-END:variables
}
