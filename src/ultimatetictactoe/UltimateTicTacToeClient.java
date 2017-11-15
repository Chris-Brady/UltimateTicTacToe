package ultimatetictactoe;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import ui.*;
import ultimatetttwsc.TTTWebService;
import ultimatetttwsc.TTTWebService_Service;

public class UltimateTicTacToeClient extends JFrame
{
    private static TTTWebService proxy;
    private int userID;
    private String userName;
    
    public UltimateTicTacToeClient()
    {
        this.setVisible(true);
        this.setAlwaysOnTop(true);
        this.setTitle("Ultimate TicTacToe");
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        try
        {
            TTTWebService_Service service = new TTTWebService_Service();
            proxy = service.getTTTWebServicePort();
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.exit(1);
        }
        
        updateCurrentScreen(new Login(this));
    }
    
    public void setUserID(int id)
    {
        this.userID = id;
    }
    
    public int getUserID()
    {
        return this.userID;
    } 
    
    public void updateCurrentScreen(JPanel p)
    {
        this.getContentPane().removeAll();
        this.getContentPane().add(p);
        this.pack();
    }
    
    public void alertUser(String s)
    {
        JOptionPane.showMessageDialog(this,s);
    }
    
    public static TTTWebService getProxy()
    {
        return proxy;
    }

    public void setUserName(String name)
    {
        this.userName = name;
    }
    
    public String getUserName()
    {
        return this.userName;
    }
}
