import java.io.Serializable;
import java.util.Date;

public class GIFT_DATA_VO implements Serializable{
	private String GIFT_NO;
	private String GIFT_NAME;
	private Integer GIFT_REMAIN;
	private String GIFT_CONT;
    private	Byte[] GIFT_IMG;
    private	Integer GIFT_PT;
	private Date GIFT_LAUNCH_DATE;
	public GIFT_DATA_VO() {
		super();
	}
	public String getGIFT_NO() {
		return GIFT_NO;
	}
	public void setGIFT_NO(String gIFT_NO) {
		GIFT_NO = gIFT_NO;
	}
	public String getGIFT_NAME() {
		return GIFT_NAME;
	}
	public void setGIFT_NAME(String gIFT_NAME) {
		GIFT_NAME = gIFT_NAME;
	}
	public Integer getGIFT_REMAIN() {
		return GIFT_REMAIN;
	}
	public void setGIFT_REMAIN(Integer gIFT_REMAIN) {
		GIFT_REMAIN = gIFT_REMAIN;
	}
	public String getGIFT_CONT() {
		return GIFT_CONT;
	}
	public void setGIFT_CONT(String gIFT_CONT) {
		GIFT_CONT = gIFT_CONT;
	}
	public Byte[] getGIFT_IMG() {
		return GIFT_IMG;
	}
	public void setGIFT_IMG(Byte[] gIFT_IMG) {
		GIFT_IMG = gIFT_IMG;
	}
	public Integer getGIFT_PT() {
		return GIFT_PT;
	}
	public void setGIFT_PT(Integer gIFT_PT) {
		GIFT_PT = gIFT_PT;
	}
	public Date getGIFT_LAUNCH_DATE() {
		return GIFT_LAUNCH_DATE;
	}
	public void setGIFT_LAUNCH_DATE(Date gIFT_LAUNCH_DATE) {
		GIFT_LAUNCH_DATE = gIFT_LAUNCH_DATE;
	}
	
	
	
}
