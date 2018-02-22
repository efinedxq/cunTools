package gongzi.dng.model;

public class Salary {
    
	private String yuangong;
	private String kaihujiang;
	private String qianer;
	
	public Salary() {}

	public Salary(String yuangong, String kaihujiang, String qianer) {
		super();
		this.yuangong = yuangong;
		this.kaihujiang = kaihujiang;
		this.qianer = qianer;
	}

	public String getYuangong() {
		return yuangong;
	}

	public void setYuangong(String yuangong) {
		this.yuangong = yuangong;
	}

	public String getKaihujiang() {
		return kaihujiang;
	}

	public void setKaihujiang(Double kaihujiang) {
		this.kaihujiang = kaihujiang+"";
	}

	public String getQianer() {
		return qianer;
	}

	public void setQianer(Double qianer) {
		this.qianer = qianer+"";
	}

	@Override
	public String toString() {
		return "Salary [yuangong=" + yuangong + ", kaihujiang=" + kaihujiang + ", qianer=" + qianer + "]";
	}
    
}
