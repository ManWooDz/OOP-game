import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

public class tilesManager_peaceful {
    playpeaceful gp;
    public tiles[] tile;
    public int mapTileNum[][];

    public tilesManager_peaceful(playpeaceful gp){
        this.gp = gp;

        tile = new tiles[5];
        mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];
        System.out.println("worldCol: " + gp.maxWorldCol + ", worldRow: " + gp.maxWorldRow);
        // mapTileNum = new int[20][20];

        
        getTileImage();
        // loadMap("/map/peaceful_map.txt");
        loadMap("/map/peaceful_world.txt");
        
    }

    public void getTileImage(){
        try{
            tile[0] = new tiles();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/earth.png"));
            System.out.println("Tile 0 (earth) loaded: " + (tile[0].image != null));

            tile[1] = new tiles();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/wall.png"));
            tile[1].collision = true;
            System.out.println("Tile 1 (wall) loaded: " + (tile[1].image != null));

            tile[2] = new tiles();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/tree.png"));
            tile[2].collision = true;

            System.out.println("Tile 2 (tree) loaded: " + (tile[2].image != null));

            tile[3] = new tiles();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water.png"));
            System.out.println("Tile 3 (grass) loaded: " + (tile[3].image != null));

            tile[4] = new tiles();
            tile[4].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass.png"));
            System.out.println("Tile 4 (water) loaded: " + (tile[4].image != null));

            // System.out.println("Tile 0 (wall) loaded: " + (tile[0].image != null));
            // System.out.println("Tile 1 (water) loaded: " + (tile[1].image != null));
            // System.out.println("Tile 2 (earth) loaded: " + (tile[2].image != null));
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void loadMap(String filePatch){
        try{
            InputStream is = getClass().getResourceAsStream(filePatch);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            System.out.println("Map " + filePatch + " is loaded.");

            int col = 0;
            int row = 0;

            while(col < gp.maxWorldCol && row < gp.maxWorldRow){
                String line = br.readLine();

                while(col < gp.maxWorldCol){
                    String numbers[] = line.split(" ");

                    int num = Integer.parseInt(numbers[col]);

                    mapTileNum[col][row] = num;

                    col++;
                }
                if(col == gp.maxWorldCol){
                    col = 0;
                    row++;
                }
            }
            br.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void draw(Graphics2D g2){
        int worldCol = 0;
        int worldRow = 0;
        // int x = 0;
        // int y = 0;

        while(worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow){
            int tileNum = mapTileNum[worldCol][worldRow];

            int worldX = worldCol * gp.tileSize;
            int worldY = worldRow * gp.tileSize;
            int screenX = worldX - gp.player.worldX + gp.player.screenXtemp;
            int screenY = worldY - gp.player.worldY + gp.player.screenYtemp;

            if(worldX + gp.tileSize > gp.player.worldX - gp.player.screenXtemp && worldX - gp.tileSize < gp.player.worldX + gp.player.screenXtemp &&
                worldY + gp.tileSize > gp.player.worldY - gp.player.screenYtemp && worldY - gp.tileSize< gp.player.worldY + gp.player.screenYtemp){
                    // System.out.println("in while in if");
                    g2.drawImage(tile[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);
            }
            
            // g2.drawImage(tile[tileNum].image, x, y, 50, 50, null);
            worldCol++;
            // x += gp.tileSize;
            

            if(worldCol == gp.maxWorldCol){
                worldCol = 0;
                // x = 0;
                worldRow++;
                // y += gp.tileSize;
                
            }
        }
    }
}
