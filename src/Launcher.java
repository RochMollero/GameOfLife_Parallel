
public class Launcher {

	/**
	 * @param args
	 */
	
	public static long test(Solver s) {
		System.out.println("Testing solver " + s);
		long globalScore = 0 ;
		System.out.println("|------------------->");
		System.out.print("|");
		for(int i=1 ; i < 20 ; i++) {
			System.out.print("*");
			for(int j=0 ; j < 100 ; j++) {
				int size = i*i ;
				Instance game = new Instance(size);
				game.fillAtRandom(size, 123456 * j );
				long startTime = System.nanoTime();
				s.solve(game, size);
				long endTime = System.nanoTime();
				globalScore += endTime - startTime ;
			}
		}
		System.out.println();
		System.out.println("Solver got a score of " + globalScore * 0.000001);
		return globalScore;
	}
	
	public static void main(String[] args) {
		Solver firstSolver = new SimpleSolver();
		System.out.println(test(firstSolver));
	}

}
