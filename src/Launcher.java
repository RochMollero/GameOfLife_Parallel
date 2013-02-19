
public class Launcher {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Instance firstGame = new Instance(10);
		firstGame.fillAtRandom(50);
		System.out.println(firstGame.toString());
		Solver firstSolver = new SimpleSolver();
		System.out.println("------------------------------------------");
		Instance finalState = firstSolver.solve(firstGame, 1);
		System.out.println(finalState.toString());
	}

}
