import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class keyHandler implements KeyListener{

    public boolean upPressed, downPressed, leftPressed, rightPressed;

    playpeaceful gp;
    public keyHandler(playpeaceful gp){
        this.gp = gp;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if(code == KeyEvent.VK_W){
            upPressed = true;
            // System.out.println("press w");
        }else if(code == KeyEvent.VK_S){
            downPressed = true;
            // System.out.println("press s");
        }else if(code == KeyEvent.VK_A){
            leftPressed = true;
            // System.out.println("press a");
        }else if(code == KeyEvent.VK_D){
            rightPressed = true;
            // System.out.println("press d");
        }else if(code == KeyEvent.VK_ESCAPE){
            System.out.println("Pressed ESC");
            if(gp.gameState == gp.playState){
                gp.gameState = gp.pauseState;
            }else if(gp.gameState == gp.pauseState){
                gp.gameState = gp.playState;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if(code == KeyEvent.VK_W){
            upPressed = false;
        }else if(code == KeyEvent.VK_S){
            downPressed = false;
        }else if(code == KeyEvent.VK_A){
            leftPressed = false;
        }else if(code == KeyEvent.VK_D){
            rightPressed = false;
        }
        
    }
    
}
