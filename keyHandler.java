import java.awt.RenderingHints.Key;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class keyHandler implements KeyListener{

    public boolean upPressed, downPressed, leftPressed, rightPressed, enterPressed;

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
        //store KeyCode
        int code = e.getKeyCode();

        //PlayState
        if(gp.gameState == gp.playState){
            playState(code);
        }else if(gp.gameState == gp.pauseState){
            //PauseState
            pauseState(code);
        }else if(gp.gameState == gp.dialogState){
            //DialogState
            dialogState(code);
        }else if(gp.gameState == gp.gameOverState){
            gameOverState(code);
        }else if(gp.gameState == gp.finishedState){
            finishedState(code);
        }
    }

    public void playState(int code){
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
            gp.gameState = gp.pauseState;
        }else if(code == KeyEvent.VK_UP){
            upPressed = true;
            // System.out.println("press w");
        }else if(code == KeyEvent.VK_DOWN){
            downPressed = true;
            // System.out.println("press s");
        }else if(code == KeyEvent.VK_LEFT){
            leftPressed = true;
            // System.out.println("press a");
        }else if(code == KeyEvent.VK_RIGHT){
            rightPressed = true;
            // System.out.println("press d");
        }
    }
    public void pauseState(int code){
        if(code == KeyEvent.VK_ESCAPE){
            gp.gameState = gp.playState;
        }
        if(code == KeyEvent.VK_ENTER){
            enterPressed = true;
        }

        int maxCommandNum = 0;
        switch(gp.UI.subState){
            case 0:
                //Options page
                maxCommandNum = 2;
            case 1:
                //Confirm exit page
                maxCommandNum = 1;
        }

        if(code == KeyEvent.VK_W){
            gp.UI.commandNum--;
            if(gp.UI.commandNum < 0){
                gp.UI.commandNum = maxCommandNum;
            }
        }
        if(code == KeyEvent.VK_S){
            gp.UI.commandNum++;
            if(gp.UI.commandNum > maxCommandNum){
                gp.UI.commandNum = 0;
            }
        }else if(code == KeyEvent.VK_UP){
            gp.UI.commandNum--;
            if(gp.UI.commandNum < 0){
                gp.UI.commandNum = maxCommandNum;
            }
        }else if(code == KeyEvent.VK_DOWN){
            gp.UI.commandNum++;
            if(gp.UI.commandNum > maxCommandNum){
                gp.UI.commandNum = 0;
            }
        }
    }

    public void dialogState(int code){
        if(code == KeyEvent.VK_ENTER){
            gp.gameState = gp.playState;
        }
    }

    public void gameOverState(int code){
        if(code == KeyEvent.VK_W){
            gp.UI.commandNum--;
            if(gp.UI.commandNum < 0){
                gp.UI.commandNum = 1;
            }
        }
        if(code == KeyEvent.VK_S){
            gp.UI.commandNum++;
            if(gp.UI.commandNum > 1){
                gp.UI.commandNum = 0;
            }
        }
        if(code == KeyEvent.VK_UP){
            gp.UI.commandNum--;
            if(gp.UI.commandNum < 0){
                gp.UI.commandNum = 1;
            }
        }
        if(code == KeyEvent.VK_DOWN){
            gp.UI.commandNum++;
            if(gp.UI.commandNum > 1){
                gp.UI.commandNum = 0;
            }
        }
        if(code == KeyEvent.VK_ENTER){
            if(gp.UI.commandNum == 0){
                gp.gameState = gp.playState;
                gp.restart();
            }else if(gp.UI.commandNum == 1){
                gp.exitTheGame();
            }
        }
    }
    public void finishedState(int code){
        if(code == KeyEvent.VK_W){
            gp.UI.commandNum--;
            if(gp.UI.commandNum < 0){
                gp.UI.commandNum = 1;
            }
        }
        if(code == KeyEvent.VK_S){
            gp.UI.commandNum++;
            if(gp.UI.commandNum > 1){
                gp.UI.commandNum = 0;
            }
        }
        if(code == KeyEvent.VK_UP){
            gp.UI.commandNum--;
            if(gp.UI.commandNum < 0){
                gp.UI.commandNum = 1;
            }
        }
        if(code == KeyEvent.VK_DOWN){
            gp.UI.commandNum++;
            if(gp.UI.commandNum > 1){
                gp.UI.commandNum = 0;
            }
        }
        if(code == KeyEvent.VK_ENTER){
            if(gp.UI.commandNum == 0){
                gp.gameState = gp.playState;
                gp.restart();
            }else if(gp.UI.commandNum == 1){
                gp.exitTheGame();
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
        }else if(code == KeyEvent.VK_ENTER){
            enterPressed = false;
        }else if(code == KeyEvent.VK_UP){
            upPressed = false;
            // System.out.println("press w");
        }else if(code == KeyEvent.VK_DOWN){
            downPressed = false;
            // System.out.println("press s");
        }else if(code == KeyEvent.VK_LEFT){
            leftPressed = false;
            // System.out.println("press a");
        }else if(code == KeyEvent.VK_RIGHT){
            rightPressed = false;
            // System.out.println("press d");
        }
        
    }
    
}
