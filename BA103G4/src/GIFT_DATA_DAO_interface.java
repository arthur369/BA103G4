import java.util.List;



public interface GIFT_DATA_DAO_interface {
	 public void insert(GIFT_DATA_VO gift_data_VO);
     public void update(GIFT_DATA_VO gift_data_VO);
     public void delete(String GIFT_NO);
     public GIFT_DATA_VO findByPrimaryKey(String GIFT_NO);
     public List<GIFT_DATA_VO> getAll();
}
