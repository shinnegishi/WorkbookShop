package model;
import java.util.List;
import java.util.ArrayList;

public class PagerLogic {
	private Pager pager = new Pager();
	
	public PagerLogic() {
		
	}
	
	public PagerLogic(Integer currentPage, Integer productCount, Integer limit) {
		if(limit == 0) {
			this.pager.getDefaultLimitPerPage();
		}
		List<Integer> pagesRange =  this.extractPageRange(productCount, limit);
		this.setPager(new Pager(currentPage, limit, pagesRange));
	}
	
	/**
	 * ページのレンジを配列にして格納する
	 * @param maxcount
	 * @return
	 */
	public List<Integer> extractPageRange(Integer itemCount, Integer limit){
		List<Integer> intArr = new ArrayList<Integer>();
		if(limit == null || limit == 0) {
			limit = this.pager.getDefaultLimitPerPage();			
		}
		Integer pages = itemCount / limit;
		if(itemCount % limit > 0) {
			pages += 1;
		}
		for(int i = 0; i < pages; i++) {
			int index = i+1;
			intArr.add(index);
		}
		return intArr;
	}
	
	/**
	 * @return the pager
	 */
	public Pager getPager() {
		return this.pager;
	}

	/**
	 * @param pager the pager to set
	 */
	public void setPager(Pager pager) {
		this.pager = pager;
	}


}
