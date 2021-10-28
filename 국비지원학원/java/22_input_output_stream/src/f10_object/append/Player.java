package f10_object.append;

import java.io.Serializable;

public class Player implements Serializable{
	
	private int pNum;
	private String nick;
	private int level;
	
	// getter & setter & toString
	public int getpNum() {
		return pNum;
	}
	public void setpNum(int pNum) {
		this.pNum = pNum;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	@Override
	public String toString() {
		return "Player [pNum=" + pNum + ", nick=" + nick + ", level=" + level + "]";
	}
	
}
