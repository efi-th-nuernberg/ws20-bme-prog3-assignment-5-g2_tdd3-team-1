import org.junit.Test;
import static org.junit.Assert.*;

public class LifeTest {
    
    @Test
    public void createNewCell() {
        
        // Arrange: drei lebende Zellen
        Life l = new Life();
        l.setAlive(0, 0);
        l.setAlive(0, 1);
        l.setAlive(0, 2);

        // Act: Berechnung der Folgegeneration
        l = (Life) l.nextGeneration();

        // Assert: Rasterpunkt mit drei Nachbarn sollte jetzt leben
        assertTrue(l.isAlive(1, 1));
    }


    @Test
    public void destroyLonelyCell() {
      // Arrange: drei lebende Zellen
       Life l = new Life();
        l.setAlive(0, 0);
        l.setAlive(0, 1);
  

        // Act: Berechnung der Folgegeneration
        l = (Life) l.nextGeneration();

        // Assert: Rasterpunkt mit drei Nachbarn sollte jetzt leben
        assertFalse(l.isAlive(0, 0));
    }
    

    @Test
    public void keepAliveCell() {
       Life l = new Life();
        l.setAlive(0, 0);
        l.setAlive(0, 1);
        l.setAlive(0, 2);

        // Act: Berechnung der Folgegeneration
        l = (Life) l.nextGeneration();

        // Assert: Rasterpunkt mit drei Nachbarn sollte jetzt leben
        assertTrue(l.isAlive(0, 1));
    }


    @Test
    public void destroyCrowdedCell() {
       Life l = new Life();
        l.setAlive(1, 1);
        l.setAlive(0, 0);
        l.setAlive(0, 1);
        l.setAlive(0, 2);
        l.setAlive(1, 2);
        l.setAlive(2, 2);
        
        // Act: Berechnung der Folgegeneration
        l = (Life) l.nextGeneration();

        // Assert: Rasterpunkt mit drei Nachbarn sollte jetzt leben
        assertFalse(l.isAlive(1, 1));
    }


}