import java.util.*;

public class 1A {
	public static void main(String[] args) {
		while (true) {
			ArrayList<Integer> at = new ArrayList<Integer>();
			ArrayList<Integer> df = new ArrayList<Integer>();
			int A;
			int D;

			Scanner S1 = new Scanner(System.in); 
            A = S1.nextInt();
            D = S1.nextInt(); 

			if (A == 0 && D == 0) {
				break;
			}
			if (A > 0 && D < 2 ) {
				System.out.print("N");
				System.out.print("\n");
				continue;
			}

			int distA;
			Scanner S3 = new Scanner(System.in); 
            for (int i = 0; i < A; i++) {
			    distA = S3.nextInt();
                at.add(distA);
            }
            
            int distD;
			Scanner S4 = new Scanner(System.in); 
			for (int i = 0; i < D; i++) {
				distD = S4.nextInt();
				df.add(distD);
			}

			match M = new match(at,df);

			if (M.checkOffside()) {
				System.out.print("Y");
				System.out.print("\n");
			}
			else {
				System.out.print("N");
				System.out.print("\n");
			}
		}

	}

}

class match {
	ArrayList<attacker> attackers;
	ArrayList<defender> defenders;

	public match(ArrayList<Integer> Attackers, ArrayList<Integer> Defenders) {
		Collections.sort(Attackers);
		Collections.sort(Defenders);

        attackers = new ArrayList<attacker>();
        defenders = new ArrayList<defender>();

		for (int i = 0; i < Attackers.size() ; i++) {
			attacker aux = new attacker(Attackers.get(i));
			attackers.add(aux);
		}
		for (int i = 0; i < Defenders.size() ; i++) {
			defender aux = new defender(Defenders.get(i));
			defenders.add(aux);
		}
	}

	public boolean checkOffside() {
		if (defenders.get(1).getDist() <= attackers.get(0).getDist()) {
			return false;
		}
		else if (defenders.get(0).getDist() <= attackers.get(0).getDist() && defenders.get(1).getDist() <= attackers.get(0).getDist()) {
			return false;
		}
		else {
			return true;
		}
	}
}
    
class attacker {
	int dist;
	public attacker(Integer n) {
		dist = n;
	}
	public int getDist() {
		return dist;
	}
}
    
class defender {
	int dist;
	public defender(Integer n) {
		dist = n;
	}
	public int getDist() {
		return dist;
	}
}

/*
2 3
500 700
700 500 500
2 2
200 400
200 1000
3 4
530 510 490
480 470 50 310
0 0
*/
