package gongzi.dng.model;

public class Item {
	private String yuangong;
	private String kehu;
	private String kehuzijinzhanghao;
	private String kaihujiang;
	private String kaihuriqi;
	private String shuangbian;
	private String youxiao;
	private String qimoshizhi;
	private String qimoguimo;
	private String wuxishu;

	public Item() {
	}

	public Item(String yuangong, String kehu, String kehuzijinzhanghao, String kaihujiang, String kaihuriqi,
			String shuangbian, String youxiao, String qimoshizhi, String qimoguimo, String wuxishu) {
		super();
		this.yuangong = yuangong;
		this.kehu = kehu;
		this.kehuzijinzhanghao = kehuzijinzhanghao;
		this.kaihujiang = kaihujiang;
		this.kaihuriqi = kaihuriqi;
		this.shuangbian = shuangbian;
		this.youxiao = youxiao;
		this.qimoshizhi = qimoshizhi;
		this.qimoguimo = qimoguimo;
		this.wuxishu = wuxishu;
	}

	public String getYuangong() {
		return yuangong;
	}

	public void setYuangong(String yuangong) {
		this.yuangong = yuangong;
	}

	public String getKehu() {
		return kehu;
	}

	public void setKehu(String kehu) {
		this.kehu = kehu;
	}

	public String getKehuzijinzhanghao() {
		return kehuzijinzhanghao;
	}

	public void setKehuzijinzhanghao(String kehuzijinzhanghao) {
		this.kehuzijinzhanghao = kehuzijinzhanghao;
	}

	public String getKaihujiang() {
		return kaihujiang;
	}

	public void setKaihujiang(String kaihujiang) {
		this.kaihujiang = kaihujiang;
	}

	public String getKaihuriqi() {
		return kaihuriqi;
	}

	public void setKaihuriqi(String kaihuriqi) {
		this.kaihuriqi = kaihuriqi;
	}

	public String getShuangbian() {
		return shuangbian;
	}

	public void setShuangbian(String shuangbian) {
		this.shuangbian = shuangbian;
	}

	public String getYouxiao() {
		return youxiao;
	}

	public void setYouxiao(String youxiao) {
		this.youxiao = youxiao;
	}

	public String getQimoshizhi() {
		return qimoshizhi;
	}

	public void setQimoshizhi(String qimoshizhi) {
		this.qimoshizhi = qimoshizhi;
	}

	public String getQimoguimo() {
		return qimoguimo;
	}

	public void setQimoguimo(String qimoguimo) {
		this.qimoguimo = qimoguimo;
	}

	public String getWuxishu() {
		return wuxishu;
	}

	public void setWuxishu(String wuxishu) {
		this.wuxishu = wuxishu;
	}

	@Override
	public String toString() {
		return "Item [yuangong=" + yuangong + ", kehu=" + kehu + ", kehuzijinzhanghao=" + kehuzijinzhanghao
				+ ", kaihujiang=" + kaihujiang + ", kaihuriqi=" + kaihuriqi + ", shuangbian=" + shuangbian
				+ ", youxiao=" + youxiao + ", qimoshizhi=" + qimoshizhi + ", qimoguimo=" + qimoguimo + ", wuxishu="
				+ wuxishu + "]";
	}
    
	
}
