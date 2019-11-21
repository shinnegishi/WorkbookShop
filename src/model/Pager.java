package model;
import java.util.List;

public class Pager implements PagerConfig{
	private List<Integer> pageRange;
	private int currentPage;
	private int offset;
	private int limit;
	
	public Pager() {
		
	}
	
	/**
	 * 
	 * @param itemsCount
	 * @param currentPage
	 * @param pageRange
	 */
	public Pager( Integer currentPage, int limit, List<Integer> pageRange) {
		//最初のページだった場合は0をオフセット値に
		if(currentPage == 1) {
			this.setOffset(0);
		}else {
			this.setOffset((currentPage-1)*limit);
		}
		this.setCurrentPage(currentPage);
		this.setPageRange(pageRange);
		if(limit ==  0) {
			limit = PagerConfig.LIMIT_PER_PAGE;
		}
		this.setLimit(limit);
	}

	/**
	 * @return the pageRange
	 */
	public List<Integer> getPageRange() {
		return pageRange;
	}
	/**
	 * @param pageRange the pageRange to set
	 */
	public void setPageRange(List<Integer> pageRange) {
		this.pageRange = pageRange;
	}
	/**
	 * @return the currentPage
	 */
	public int getCurrentPage() {
		return currentPage;
	}
	/**
	 * @param currentPage the currentPage to set
	 */
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
	/**
	 * ページごとの表示数を取得
	 * @return
	 */
	public Integer getDefaultLimitPerPage() {
		return PagerConfig.LIMIT_PER_PAGE;
	}

	/**
	 * @return the limit
	 */
	public int getLimit() {
		return limit;
	}

	/**
	 * @param limit the limit to set
	 */
	public void setLimit(int limit) {
		this.limit = limit;
	}

	/**
	 * @return the offset
	 */
	public int getOffset() {
		return offset;
	}

	/**
	 * @param offset the offset to set
	 */
	public void setOffset(int offset) {
		this.offset = offset;
	}
	
	

}
