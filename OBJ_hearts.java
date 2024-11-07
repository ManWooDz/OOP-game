import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_hearts extends SuperObect {

    playpeaceful gp;

    public OBJ_hearts(playpeaceful gp){
        this.gp = gp;

        name = "Heart";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/heart_blank.png"));
            image2 = ImageIO.read(getClass().getResourceAsStream("/objects/heart_full.png"));
            image = uTool.scaleImage(image, gp.tileSize, gp.tileSize);
            image2 = uTool.scaleImage(image2, gp.tileSize, gp.tileSize);

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
