import java.awt.Rectangle;

public class EventHandler {
    playpeaceful gp;
    EventRect eventRect[][];

    int previousEventX, previousEventY;
    boolean canTouchEvent = true;

    public EventHandler(playpeaceful gp){
        this.gp = gp;

        eventRect = new EventRect[gp.maxWorldCol][gp.maxWorldRow];

        int col = 0;
        int row = 0;
        while(col < gp.maxWorldCol && row < gp.maxWorldRow){
            eventRect[col][row] = new EventRect();
            eventRect[col][row].x = 23;
            eventRect[col][row].y = 23;
            eventRect[col][row].width = 2;
            eventRect[col][row].height = 2;
            eventRect[col][row].eventRectDefaultX = eventRect[col][row].x;
            eventRect[col][row].eventRectDefaultY = eventRect[col][row].y;

            col++;
            if(col == gp.maxWorldCol){
                col = 0;
                row++;
            }
        }

        
    }

    public void checkEvent(){
        //check if player is more than 1 tile away from thorns
        int xDistance = Math.abs(gp.player.worldX - previousEventX);
        int yDistance = Math.abs(gp.player.worldY - previousEventY);
        int distance = Math.max(xDistance, yDistance);
        if(distance > gp.tileSize){
            canTouchEvent = true;
        }

        if(canTouchEvent == true){
            //thorns
            if(hit(22,14,"any") == true){
                damagePit(gp.dialogState);
            }else if(hit(28,16,"any") == true){
                damagePit(gp.dialogState);
            }else if(hit(26,30,"any") == true){
                damagePit(gp.dialogState);
            }else if(hit(21,42,"any") == true){
                damagePit(gp.dialogState);
            }


            //finished
            if(hit(42,43,"any") == true){
                finishPit(gp.finishedState);
            }
        }

    }
    
    public boolean hit(int eventCol, int eventRow, String reqDirection){
        boolean hit = false;

        gp.player.solidArea.x = gp.player.worldX + gp.player.solidArea.x;
        gp.player.solidArea.y = gp.player.worldY + gp.player.solidArea.y;
        eventRect[eventCol][eventRow].x = eventCol*gp.tileSize + eventRect[eventCol][eventRow].x;
        eventRect[eventCol][eventRow].y = eventRow*gp.tileSize + eventRect[eventCol][eventRow].y;

        if(gp.player.solidArea.intersects(eventRect[eventCol][eventRow]) && eventRect[eventCol][eventRow].eventDone == false){
            if(gp.player.direction.contentEquals(reqDirection) || reqDirection.contentEquals("any")){
                hit = true;

                previousEventX = gp.player.worldX;
                previousEventY = gp.player.worldY;
            }
        }

        gp.player.solidArea.x = gp.player.solidAreaDefaultX; 
        gp.player.solidArea.y = gp.player.solidAreaDefaultY;
        eventRect[eventCol][eventRow].x = eventRect[eventCol][eventRow].eventRectDefaultX;
        eventRect[eventCol][eventRow].y = eventRect[eventCol][eventRow].eventRectDefaultY;

        return hit;
    }

    public void damagePit(int gameState){
        gp.gameState = gameState;
        gp.UI.currentDialog = "You have stepped into thorns!";
        gp.player.life -= 1;

        canTouchEvent = false;
    }
    public void finishPit(int gameState){
        gp.gameState = gameState;
    }
}
