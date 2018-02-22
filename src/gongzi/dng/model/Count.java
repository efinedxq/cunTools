package gongzi.dng.model;

public class Count {
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
	private Double qianer;
	
	public Count() {
		// TODO Auto-generated constructor stub
	}
    
	public Count(Item item){
		super();
		this.yuangong = item.getYuangong();
		this.kehu = item.getKehu();
		this.kehuzijinzhanghao = item.getKehuzijinzhanghao();
		this.kaihujiang = item.getKaihujiang();
		this.kaihuriqi = item.getKaihuriqi();
		this.shuangbian = item.getShuangbian();
		this.youxiao = item.getYouxiao();
		this.qimoshizhi = item.getQimoshizhi();
		this.qimoguimo = item.getQimoguimo();
		this.wuxishu = item.getWuxishu();
		this.qianer =  0.0;
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

	public String getQianer() {
		return qianer+"";
	}

	public void setQianer(Double d) {
		this.qianer = d;
	}

	@Override
	public String toString() {
		return "Count [yuangong=" + yuangong + ", kehu=" + kehu + ", kehuzijinzhanghao=" + kehuzijinzhanghao
				+ ", kaihujiang=" + kaihujiang + ", kaihuriqi=" + kaihuriqi + ", shuangbian=" + shuangbian
				+ ", youxiao=" + youxiao + ", qimoshizhi=" + qimoshizhi + ", qimoguimo=" + qimoguimo + ", wuxishu="
				+ wuxishu + ", qianer=" + qianer + "]";
	}
    
}
