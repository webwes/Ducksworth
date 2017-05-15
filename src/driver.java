


public class driver {

	public static void main(String[] args) {
		Game step = new Game();
		step.shuffle();
		
		boolean x = step.stillPlaying();
	while(x){
		
		step.phase1();
		step.DrawBoard();
		x = step.stillPlaying();
		}
	}
		/*System.out.println(bry.countCards());
		bry.shuffle();
		System.out.println(bry.toString());
		System.out.println(bry.countCards());
		*/
	}


