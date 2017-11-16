package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.Timer;
import ultimatetictactoe.UltimateTicTacToeClient;

public class GamePanel extends javax.swing.JPanel
{
    private final UltimateTicTacToeClient game;
    private final Menu menu;
    private final JButton[][] btns;
    private String boardState;
    private final String[] symbols;
    private final Timer t;
    
    private final int gid;    
    private final boolean isHost;
    private boolean turn;
    private boolean update;
    private final int delay = 512;
    
    public GamePanel(UltimateTicTacToeClient game, int gid, String hostName, Menu menu)
    {
        this.game = game;
        this.gid = gid;
        this.isHost = (hostName.equals(game.getUserName()));
        this.menu = menu;
        this.turn = false;
        this.update=true;
        this.boardState="";
        
        initComponents();
        btns=new JButton[3][3];
        btns[0][0] = jButton1;
        btns[0][1] = jButton2;
        btns[0][2] = jButton3;
        btns[1][0] = jButton4;
        btns[1][1] = jButton5;
        btns[1][2] = jButton6;
        btns[2][0] = jButton7;
        btns[2][1] = jButton8;
        btns[2][2] = jButton9;
        
        if(isHost)
            symbols = new String[]{"X","O"};
        else
            symbols = new String[]{"O","X"};
        
        t = new Timer(delay, taskPerformer);
        t.start();
    }
    
    ActionListener taskPerformer = (ActionEvent evt) -> 
    {
        update();
    };
    
    public void update()
    {
        if(update)
        {
            String state = UltimateTicTacToeClient.getProxy().getGameState(gid);
            switch(state)
            {
                case"-1":
                    break;
                case"0":
                    if(CloseButton.isEnabled())
                        CloseButton.setEnabled(false);
                    String newState = UltimateTicTacToeClient.getProxy().getBoard(gid);
                    if(!boardState.equals(newState))
                    {
                        boardState = newState;
                        gameTick();
                    }
                    break;
                case"1":
                case"2": 
                case"3":
                    gameOver(state);
                    break;
                case"ERROR-NOGAME":
                    break;
                default:
                    game.alertUser("Oops!\nSomething went wrong!");
            }
        }
    }
    
    private void gameTick()
    {
        switch(boardState)
        {
            case"ERROR-DB":
                game.alertUser("Oops!\nDatabase Error!");
                break;
            case"ERROR-NOMOVES":
                if(isHost)
                {
                    jTextArea1.append("Your turn "+symbols[0]+"\n");
                    turn = true;
                }
                else
                    jTextArea1.append(symbols[1]+"'s turn\n");
                break;
            default:
                String[]arr = boardState.split("\n");
                for(int i=0;i<arr.length;i++)
                {
                    String[]tmp = arr[i].split(",");
                    if(tmp[0].equals(game.getUserID()+""))
                        btns[Integer.parseInt(tmp[1])][Integer.parseInt(tmp[2])].setText(symbols[0]);
                    else
                        btns[Integer.parseInt(tmp[1])][Integer.parseInt(tmp[2])].setText(symbols[1]);
                    
                    if(i==arr.length-1)
                        if(!(Integer.parseInt(tmp[0])==game.getUserID()))
                        {
                            jTextArea1.append("Your turn "+symbols[0]+"\n");
                            turn = true;
                        }
                    else
                        jTextArea1.append(symbols[1]+"'s turn\n");
                }
        }
    }
    
    private void gameOver(String state)
    {
        update = false;
        if(state.equals("3"))
            game.alertUser("Draw!");
        else if(isHost&&state.equals("1")||!isHost&&state.equals("2"))
            game.alertUser("You Win!");
        else
            game.alertUser("You Lose!");
        destroy();
    }
    
    private void takeSquare(int  x, int y)
    {
        String available = UltimateTicTacToeClient.getProxy().checkSquare(x, y, gid);
        switch(available)
        {
            case "0":
                String result = UltimateTicTacToeClient.getProxy().takeSquare(x, y, gid, game.getUserID());
                switch(result)
                {
                    case"1":
                        turn = false;
                        String win = UltimateTicTacToeClient.getProxy().checkWin(gid);
                        switch(win)
                        {
                            case"ERROR-NOGAME":
                            case"ERROR-DB":
                            case"ERROR-RETRIEVE":
                                game.alertUser("Oops!\nDatabase Error!");
                                break;
                            default:
                                UltimateTicTacToeClient.getProxy().setGameState(gid,Integer.parseInt(win));
                        }
                        break;
                    case"0":
                        game.alertUser("Oops!\nProblem with move!");
                        break;
                    case"ERROR-DB":
                        game.alertUser("Oops!\nDatabase Error!");
                        break;
                    case"ERROR-TAKEN":
                        game.alertUser("Square is taken!");
                        break;
                    case"ERROR":
                        game.alertUser("Oops!\nVague Error!");
                        break;
                }
                break;
            case"1":
                game.alertUser("Square is taken!");
                break;
            default:
                game.alertUser("Oops!\nDatabase Error!");      
        }
    }
    
    private void destroy()
    {
        String s = gid+"";
        int i = menu.getPane().indexOfTab(s);
        if (i != -1) 
        {
            menu.getPane().remove(i);
            menu.getPane().setSelectedIndex(menu.getPane().indexOfTab("Games"));
        }
        t.stop();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        CloseButton = new javax.swing.JButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Board"));
        jPanel1.setPreferredSize(new java.awt.Dimension(288, 288));
        jPanel1.setLayout(new java.awt.GridLayout(3, 3, 1, 1));

        jButton1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);

        jButton2.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);

        jButton3.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);

        jButton4.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);

        jButton5.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5);

        jButton6.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6);

        jButton7.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7);

        jButton8.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton8);

        jButton9.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton9);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Output"));

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        CloseButton.setText("Close Game");
        CloseButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                CloseButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(CloseButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CloseButton)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void CloseButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_CloseButtonActionPerformed
    {//GEN-HEADEREND:event_CloseButtonActionPerformed
        try
        {
            String result = UltimateTicTacToeClient.getProxy().deleteGame(gid, game.getUserID());
            switch(result)
            {
                case "ERROR-GAMESTARTED":
                    game.alertUser("Game has already started!");
                    break;
                case "ERROR-DB":
                    game.alertUser("Oops!\nDatabase Error!");
                    break;
                default:
                    update = false;
                    destroy();
            }   
        }
        catch(Exception e)
        {
            game.alertUser("Oops!\n"+e.toString());
        }
    }//GEN-LAST:event_CloseButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton1ActionPerformed
    {//GEN-HEADEREND:event_jButton1ActionPerformed
        // TODO add your handling code here:00
        if(turn)
            takeSquare(0,0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton2ActionPerformed
    {//GEN-HEADEREND:event_jButton2ActionPerformed
        // TODO add your handling code here:01
        if(turn)
            takeSquare(0,1);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton3ActionPerformed
    {//GEN-HEADEREND:event_jButton3ActionPerformed
        // TODO add your handling code here:02
        if(turn)
            takeSquare(0,2);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton4ActionPerformed
    {//GEN-HEADEREND:event_jButton4ActionPerformed
        // TODO add your handling code here:10
        if(turn)
            takeSquare(1,0);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton5ActionPerformed
    {//GEN-HEADEREND:event_jButton5ActionPerformed
        // TODO add your handling code here:11
        if(turn)
            takeSquare(1,1);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton6ActionPerformed
    {//GEN-HEADEREND:event_jButton6ActionPerformed
        // TODO add your handling code here:12
        if(turn)
            takeSquare(1,2);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton7ActionPerformed
    {//GEN-HEADEREND:event_jButton7ActionPerformed
        // TODO add your handling code here:20
        if(turn)
            takeSquare(2,0);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton8ActionPerformed
    {//GEN-HEADEREND:event_jButton8ActionPerformed
        // TODO add your handling code here:21
        if(turn)
            takeSquare(2,1);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton9ActionPerformed
    {//GEN-HEADEREND:event_jButton9ActionPerformed
        // TODO add your handling code here:22
        if(turn)
            takeSquare(2,2);
    }//GEN-LAST:event_jButton9ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CloseButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
