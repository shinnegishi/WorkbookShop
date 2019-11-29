package model;
import java.util.List;
import java.util.ArrayList;

public class PagenateLogic {
	private Pagenate pagenate = new Pagenate();
	
	public PagenateLogic() {
		
	}
	
	public PagenateLogic(Integer currentPage, Integer productCount, Integer limit) {
		if(limit == 0) {
			this.pagenate.getDefaultLimitPerPage();
		}
		List<Integer> pagesRange =  this.extractPagenateRange(productCount, limit);
		this.setPagenate(new Pagenate(currentPage, limit, pagesRange));
	}
	
	/**
	 * ページのレンジを配列にして格納する
	 * @param maxcount
	 * @return
	 */
	public List<Integer> extractPagenateRange(Integer itemCount, Integer limit){
		List<Integer> intArr = new ArrayList<Integer>();
		if(limit == null || limit == 0) {
			limit = this.pagenate.getDefaultLimitPerPage();			
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
	 * @return the pagenate
	 */
	public Pagenate getPagenate() {
		return this.pagenate;
	}

	/**
	 * @param pagenate the pagenate to set
	 */
	public void setPagenate(Pagenate pagenate) {
		this.pagenate = pagenate;
	}


}
