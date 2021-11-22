package main;

public class StudentVO {
	private String name;
	private int koScore;
	private int mathScore;
	private int enScore;
	
	
	public StudentVO() {}


	public StudentVO(String name, int koScore, int mathScore, int enScore) {
		this.name = name;
		this.koScore = koScore;
		this.mathScore = mathScore;
		this.enScore = enScore;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getKoScore() {
		return koScore;
	}


	public void setKoScore(int koScore) {
		this.koScore = koScore;
	}


	public int getMathScore() {
		return mathScore;
	}


	public void setMathScore(int mathScore) {
		this.mathScore = mathScore;
	}


	public int getEnScore() {
		return enScore;
	}


	public void setEnScore(int enScore) {
		this.enScore = enScore;
	}


	@Override
	public String toString() {
		return "StudentVO [name=" + name + ", koScore=" + koScore + ", mathScore=" + mathScore + ", enScore=" + enScore
				+ "]";
	}
	
	
}
