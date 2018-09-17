package pkgBaseballStats;

import java.util.Scanner;

public class Player {
	
	private int atBats;
	private int hits;
	private int doubles;
	private int triples;
	private int homeRuns;
	private int runs;
	private int walks;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter player's At Bats:");
		int atBats = sc.nextInt();
		System.out.print("Enter player's Hits:");
		int hits = sc.nextInt();
		System.out.print("Enter player's Doubles:");
		int doubles = sc.nextInt();
		System.out.print("Enter player's Triples:");
		int triples = sc.nextInt();
		System.out.print("Enter player's Home Runs:");
		int homeRuns = sc.nextInt();
		System.out.print("Enter player's Runs:");
		int runs = sc.nextInt();
		System.out.print("Enter player's Walks:");
		int walks = sc.nextInt();
		
		Player newPlayer = new Player(atBats, hits, doubles, triples,
				homeRuns, runs, walks);
		
		float battingAverage = newPlayer.battingAverage();
		float onBasePercentage = newPlayer.onBasePercentage();
		float sluggingPercentage = newPlayer.sluggingPercentage();
		float onBaseSluggingPercentage = newPlayer.onBaseSluggingPercentage();
		int totalBases = newPlayer.totalBases();
	}
	
	public Player(int atBats, int hits, int doubles, int triples,
			int homeRuns, int runs, int walks) {
		this.atBats = atBats;
		this.hits = hits;
		this.doubles = doubles;
		this.triples = triples;
		this.homeRuns = homeRuns;
		this.runs = runs;
		this.walks = walks;
	}
	
	public float battingAverage() {
		return ((float) hits / atBats);
	}
	
	public float onBasePercentage() {
		return ((float) ((hits + walks) / (atBats + walks)));
	}
	
	public float sluggingPercentage() {
		int singles = hits - (doubles + triples + homeRuns);
		return ((float) ((singles + doubles * 2 + triples * 3 + homeRuns * 4) / atBats));
	}
	
	public float onBaseSluggingPercentage() {
		float obp = (float) ((hits + walks) / (atBats + walks));
		int singles = hits - (doubles + triples + homeRuns);
		float slg = (float) ((singles + doubles * 2 + triples * 3 + homeRuns * 4) / atBats);
		return (obp + slg);
	}
	
	public int totalBases() {
		int singles = hits - (doubles + triples + homeRuns);
		return (singles + doubles * 2 + triples * 3 + homeRuns * 4);
	}
}
