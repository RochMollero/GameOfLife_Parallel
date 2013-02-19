
public class SimpleSolver extends Solver {
	private boolean[][] first ;
	private boolean[][] second ;
	
	@Override
	public Instance solve(Instance game, int numberOfGenerations) {
		first = new boolean[game.cells.length][game.cells[0].length];
		second = new boolean[game.cells.length][game.cells[0].length];

		for(int i=0 ; i < game.cells.length ;i++) {
			for(int j=0 ; j < game.cells[0].length ; j++) {
				first[i][j] = game.cells[i][j];
				second[i][j] = game.cells[i][j];
			}
		}
		for(int i=0 ; i < numberOfGenerations ; i++) {
			if (i%2 == 0) {
				iterate(first, second);
			} else {
				iterate(second, first);
			}
		}
		if(numberOfGenerations % 2 == 0) {
			return new Instance(first);
		} else {
			return new Instance(second);
		}
	}
	
	protected void iterate(boolean[][] current, boolean[][] next_step) {
		for(int i = 0 ; i < current.length ; i++) {
			for(int j=0 ; j < current[0].length ; j++) {
				int alive = 0 ;
				for(int dx = -1 ; dx <= 1 ; dx ++) {
					for(int dy = -1 ; dy <= 1 ; dy++) {
						if (dx != 0 || dy != 0) {
							if (((i+dx) >= 0) && ((j+dy) >= 0) && (i+dx < current.length) && (j+dy < current[0].length)) {
								int realX = i+dx ;
								int realY = j+dy ;
								if (current[realX][realY])
										alive++ ;
							} 
						}
					}
				}

				if (current[i][j]) {
					if(alive > 3 || alive < 2)
						next_step[i][j] = false ;
				} else {
					if(alive == 3)
						next_step[i][j] = true ;
				}
			}
		}
	}

}
