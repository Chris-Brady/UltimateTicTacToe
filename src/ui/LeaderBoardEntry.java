package ui;

public class LeaderBoardEntry extends javax.swing.JPanel
{
    public LeaderBoardEntry()
    {
        initComponents();
    }
    
    LeaderBoardEntry(String key, int score, int loss, int draw)
    {
        initComponents();
        playerName.setText(key);
        winsLabel.setText(score+"");
        lossesLabel.setText(loss+"");
        drawsLabel.setText(draw+"");
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
