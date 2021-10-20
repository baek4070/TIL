package java_practice_1019.guide;

public class Player {

	private PlayerLevel level;
	
	Player (){
		getLevel();
	}
	
	public void getLevel() {
		BeginnerLevel bLevel = new BeginnerLevel();
		this.level = bLevel;
		this.level.showLevelMessage();
	}
	
	public void upgradeLevel(PlayerLevel level) {
		this.level = level;
		this.level.showLevelMessage();
	}
	
	public void play(int count) {
		this.level.go(count);
	}
}
