
public class SimpleSolver extends Solver {
	private boolean[][] first ;
	private boolean[][] second ;
	
	@Override
	public Instance solve(Instance game, int numberOfGenerations) {
		first = game.cells ;
		second = game.cells ;
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
		next_step = current.clone() ;
		for(int i = 0 ; i < current.length ; i++) {
			for(int j=0 ; j < current[0].length ; j++) {
				int alive = 0 ;
				for(int dx = -1 ; dx < 2 ; dx ++) {
					for(int dy = -1 ; dy < 2 ; dy++) {
						if (dx != 0 || dy!= 0) {
							int realX = (i+dx + current.length) % current.length ;
							int realY = (j+dy + current[0].length) % current[0].length ;
							if (current[realX][realY]) {
								alive++ ;
							}
						}
					}
				}
				
				if (current[i][j]) {
					if(alive != 3)
						next_step[i][j] = false ;
				} else {
					if(alive == 3)
						next_step[i][j] = true ;
				}
			}
		}
	}

}
