package model;

import java.util.List;

import dao.ProductDAO;

public class ProductLogic{
	private PagerLogic pagerLogic;
	 
    public List<Product> findALLProducts(Integer page, Integer limit, PagerLogic pLogic){
        ProductDAO daoProduct = new ProductDAO();
         //ページ表示数が0の場合は設定されていないので初期の値を設定する
        if(limit == 0) {
        	limit = pLogic.getPager().getDefaultLimitPerPage();
        }
        List<Product> productList = daoProduct.findAllProducts(pLogic.getPager().getOffset(), limit);
        return productList;
    }
    
    /**
     * テーブル「prroduct」の中のレコード件数を取得
     * @return
     */
    public Integer countProducts() {
    	ProductDAO daoProduct = new ProductDAO();
    	return daoProduct.countProducts();
    }
    
}
