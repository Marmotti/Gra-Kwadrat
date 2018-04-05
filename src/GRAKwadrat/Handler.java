package GRAKwadrat;

import java.awt.*;
import java.util.LinkedList;

/* Klasa zajmująca się wszystkimi obiektami w grze
będzie ona je updatować i renderować na ekranie.
 */
public class Handler {
    LinkedList<GameObject> object = new LinkedList<GameObject>();

    //Z każdym ticknięciem dla każdego obiektu wywołuje się jego update
    public void tick(){
        for (int i = 0; i < object.size(); i++){
            GameObject tempObject = object.get(i);
            tempObject.tick();
        }
    }
    //Z każdym ticknięciem dla każdego obiektu renderuje się on
    public void render(Graphics g) {
        for (int i = 0; i < object.size(); i++) {
            GameObject tempObject = object.get(i);
            tempObject.render(g);
        }

    }
    //Funkcje dodające/usuwające obiekty, ktorymi sterujemy
    public void addObject(GameObject object){
        this.object.add(object);
    }
    public void removeObject(GameObject object){
        this.object.remove(object);
    }
}
