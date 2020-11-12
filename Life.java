import java.util.Arrays;

public class Life implements ILife {


  int M = 5;
  int N = 5;
  private boolean[][] present = new boolean[M][N];

  public static void main(String[] args) {
    Life l = new Life(new String[] { "     ", "     ", " *** ", "     ", "     " });

    l = (Life) l.nextGeneration();

  }

  public Life() {
    nukeAll();
  }

  public Life(String[] setup) {
    this();
    for (int y = 0; y < setup.length; y++)
      for (int x = 0; x < setup[y].length(); x++)
        if (setup[y].charAt(x) != ' ')
          setAlive(x, y);
  }

  @Override
  public void nukeAll() {
    // TODO Auto-generated method stub
    present =new boolean[M][N];
  }

  @Override
  public void setAlive(int x, int y) {
    // TODO Auto-generated method stub
    present[x][y] = true;
  }

  @Override
  public void setDead(int x, int y) {
    // TODO Auto-generated method stub
    present[x][y] = false;
  }

  @Override
  public boolean isAlive(int x, int y) {
    // TODO Auto-generated method stub

    return present[x][y];
  }

  @Override
  public ILife nextGeneration() {

    int aliveNeighbours = 0;
    
   boolean[][] future = new boolean[M][N];
    // TODO Auto-generated method stub
    
    for (int x=0; x<M; x++){
      for (int y=0; y<N; y++){
        if (x-1 > 0 && y-1 > 0){
          if( present[x-1][y-1] ){
          aliveNeighbours++;
          }
        }
        if (y-1 > 0){
          if( present[x][y-1] ){
          aliveNeighbours++;
          }
        }
        if (x+1 < M && y-1 > 0){
          if( present[x+1][y-1] ){
          aliveNeighbours++;
          }
        }
        if (x+1 < M ){
          if( present[x+1][y] ){
          aliveNeighbours++;
          }
        }
        if (x+1 < M && y+1 < N){
          if( present[x+1][y+1] ){
          aliveNeighbours++;
          }
        }
        if (y+1 < N){
          if( present[x][y+1] ){
          aliveNeighbours++;
          }
        }
        if (x-1 > 0 && y+1 < N){
          if( present[x-1][y+1] ){
          aliveNeighbours++;
          }
        }
        if (x-1 > 0 ){
          if( present[x-1][y] ){
          aliveNeighbours++;
          }
        }
        

    if ((present[x][y]) && (aliveNeighbours > 3)) {
      future[x][y] = false;

    //Rule 1
    } else if ((!present[x][y]) && (aliveNeighbours >= 3)) {
      future[x][y] = true;
    // Rule 2
    } else if ((present[x][y]) && (aliveNeighbours < 2)) {
      future[x][y] = false;
    //Rule 3
    } else if ((present[x][y]) && (aliveNeighbours == 2 || aliveNeighbours == 3)) {
      future[x][y] = true;
    }
    }
  }
    present = future;
    return this;
  }
}