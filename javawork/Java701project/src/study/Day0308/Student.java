package study.Day0308;

public class Student extends School {
	private String stuName;
	private String stdAddr;
	private int score;
	public Student() {
		super();
	}
	public Student(String schoolName, String schoolLoc, String stuName, String stdAddr, int score) {
		super(schoolName, schoolLoc);
		this.stuName = stuName;
		this.stdAddr = stdAddr;
		this.score = score;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public String getStdAddr() {
		return stdAddr;
	}
	public void setStdAddr(String stdAddr) {
		this.stdAddr = stdAddr;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "Student [stuName=" + stuName + ", stdAddr=" + stdAddr + ", \nscore=" + score + ", \ntoString()="
				+ super.toString() + "]";
	}
	
}
