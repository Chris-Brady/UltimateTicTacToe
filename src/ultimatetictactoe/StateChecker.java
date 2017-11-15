/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ultimatetictactoe;

import static java.lang.Thread.sleep;
import java.util.ArrayList;
import ui.GamePanel;

/**
 *
 * @author chris
 */
public class StateChecker implements Runnable
{
    private boolean run;
    private final GamePanel g;
    
    public StateChecker(GamePanel g)
    {
        this.g = g;
        run=true;
    }
    
    public void halt()
    {
        run = false;
    }
    @Override
    public void run()
    {
        while(run)
        {
            g.update();
        }
    }  
}
