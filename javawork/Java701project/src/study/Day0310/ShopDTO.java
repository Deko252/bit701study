package study.Day0310;

public class ShopDTO {
	private String sangpum;
	private int su;
	private int dan;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public ShopDTO() {
		
	}

	public ShopDTO(String sangpum, int su, int dan) {
		super();
		this.sangpum = sangpum;
		this.su = su;
		this.dan = dan;
	}



	public String getSangpum() {
		return sangpum;
	}

	public void setSangpum(String sangpum) {
		this.sangpum = sangpum;
	}

	public int getSu() {
		return su;
	}

	public void setSu(int su) {
		this.su = su;
	}

	public int getDan() {
		return dan;
	}

	public void setDan(int dan) {
		this.dan = dan;
	}
	@Override
	public String toString() {
		return "Ex07Shop [sangpum=" + sangpum + ", su=" + su + ", dan=" + dan + "]";
	}

}
