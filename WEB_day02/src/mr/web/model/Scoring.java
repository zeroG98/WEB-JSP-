package mr.web.model;

public class Scoring {
	private int total;
	
	public Scoring(int kor, int math, int eng) {
		this.total = kor + math + eng;
	}
	
	public String avg() {
		double avg = total/3.0;
		String strAvg = String.format("%.2f", avg);
		
		return strAvg;
	}
	
	public int getTotal() {
		return total;
	}
}
