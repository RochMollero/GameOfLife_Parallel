import java.util.ArrayList;
import java.util.Random;

class Coordinate{
	int x;
	int y;
	
	public Coordinate(int i, int j) {
		this.x = i ; this.y = j ;
	}
}

public class Instance {
	
	/**
	 * 
	 * Represents an instance of a game of life
	 * The board has size (sizeX, sizeY) and loops as a torus.
	 * Cells have initial values stored in cells which is a simple array
	 * Instance has two method : read and write, which respectively read and
	 * write the instance to a .txt file
	 * (0,0) is in the upper-left corner
	 * cells[x][y] represents the (x,y) cell
	 */
	
	int sizeX ;
	int sizeY ;
	boolean[][] cells ;
	
	public Instance(int n) {
		this.sizeX = n ;
		this.sizeY = n ;
		this.cells = new boolean[sizeX][sizeY] ;
		for(int i=0 ; i< this.sizeX ; i++) {
			for(int j=0 ; j<this.sizeY ; j++) {
				cells[i][j] = false;
			}
		}
	}
	
	public Instance(int size_x, int size_y) {
		this.sizeX = size_x ;
		this.sizeY = size_y ;
		this.cells = new boolean[sizeX][sizeY] ;
		for(int i=0 ; i< this.sizeX ; i++) {
			for(int j=0 ; j<this.sizeY ; j++) {
				cells[i][j] = false;
			}
		}
	}
	
	public Instance(boolean[][] currentCells) {
		this.sizeX = currentCells.length ;
		this.sizeY = currentCells[0].length ;
		this.cells = currentCells ;
	}
	
	public Instance(int size_x, int size_y, ArrayList<Coordinate> a) {
		this.sizeX = size_x ;
		this.sizeY = size_y ;
		this.cells = new boolean[sizeX][sizeY] ;
		for(int i=0 ; i< this.sizeX ; i++) {
			for(int j=0 ; j<this.sizeY ; j++) {
				cells[i][j] = false;
			}
		}
		
		for(Coordinate c : a) {
			cells[c.x][c.y]= true ; 
		}
	}
	
	public void fillAtRandom(int numberOfLivingCells) {
		Random r = new Random();
		int currentNumberOfCells = 0 ;
		while(currentNumberOfCells < numberOfLivingCells) {
			int x = r.nextInt(this.sizeX);
			int y = r.nextInt(this.sizeY);
			if(!cells[x][y]) {
				cells[x][y] = true ;
				currentNumberOfCells++;
			}
		}
	}
	
	public String toString() {
		String s = "" ;
		for(int i=0 ; i< this.sizeX ; i++) {
			s += "|\n|";
			for(int j=0 ; j<this.sizeY ; j++) {
				if(cells[i][j]) {
					s += " x ";
				} else {
					s += "   ";
				}
			}
		}
		return s ;
	}
}
