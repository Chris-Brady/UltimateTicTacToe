package ui;
import java.util.ArrayList;

public class LeaderBoardEntry extends javax.swing.JPanel
{
    public LeaderBoardEntry()
    {
        initComponents();
    }
    
    public LeaderBoardEntry(ArrayList<String> s)
    {
        initComponents();
        gameID.setText(s.get(0));
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

        gameID = new javax.swing.JLabel();
        player1 = new javax.swing.JLabel();
        player2 = new javax.swing.JLabel();
        outcome = new javax.swing.JLabel();

        setLayout(new java.awt.GridLayout(1, 4));

        gameID.setText("Game ID");
        add(gameID);

        player1.setText("Player1");
        add(player1);

        player2.setText("Player2");
        add(player2);

        outcome.setText("Outcome");
        add(outcome);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel gameID;
    private javax.swing.JLabel outcome;
    private javax.swing.JLabel player1;
    private javax.swing.JLabel player2;
    // End of variables declaration//GEN-END:variables
}
