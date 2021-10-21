package java_practice_1019.guide;
public class MainBoardPlay {

	public static void main(String[] args) {
		//새 플레이어 생성 
		Player player = new Player();
		//player.play(); 함수 실행
		player.play(1);
		
		// 중급자 레벨의 aLevel 생성
		AdvancedLevel aLevel = new AdvancedLevel();
		// 플레이어 를 aLevel로 업그레이드
		player.upgradeLevel(aLevel);
		// player.play(); 함수실행
		player.play(2);
		
		SuperLevel sLevel = new SuperLevel();
		player.upgradeLevel(sLevel);
		player.play(2);
		
	}
}