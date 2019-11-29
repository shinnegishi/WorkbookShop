package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Cart;
import model.CartLogic;
import model.PagenateLogic;
import model.Product;
import model.ProductLogic;

/**
 * Servlet implementation class Items
 */
@WebServlet("/Items")
public class Items extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Items() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    request.setCharacterEncoding("UTF-8");
	    
		// TODO Auto-generated method stub

	    /*
        Enumeration<String> names = request.getParameterNames();
        while (names.hasMoreElements()) {
            System.out.println(names.nextElement());
        }
        */

        HttpSession session=request.getSession();
        
        //現在のページ数
        Integer page = 1;
        //表示数
        Integer limit = 0;
        if(request.getParameterMap().containsKey("page")) {
            page =Integer.parseInt(request.getParameter("page"));
        }
        if(request.getParameterMap().containsKey("limit")) {
        	limit = Integer.parseInt(request.getParameter("limit"));
        }
        String add2Cart=request.getParameter("add2cart");
        //System.out.println("BP1");

        if(add2Cart!=null) {

            String p_id=request.getParameter("p_id");
            String p_name=request.getParameter("p_name");
            Integer price=Integer.parseInt(request.getParameter("price"));
            Integer count=Integer.parseInt(request.getParameter("count"));
            
            //HttpSession session=request.getSession();
            List<Cart> cartList=(List<Cart>)session.getAttribute("cartList");
            if(cartList==null) {
                cartList=new ArrayList<Cart>();
            }
            Cart cart=new Cart(p_id,p_name,price,count);
            System.out.println(cart);
            CartLogic cartLogic=new CartLogic();
            cartList=cartLogic.add2Cart(cart,cartList);
            System.out.println("name:"+cartList.get(0).getCount());
            session.setAttribute("cartList",cartList);

        }

        ProductLogic productLogic = new ProductLogic();
        Integer totalProducts = productLogic.countProducts();
        PagenateLogic pagerLogic = new PagenateLogic(page,totalProducts,limit);
        List<Product> productList=productLogic.findALLProducts(page,limit,pagerLogic);
        
        if(productList !=null){
              request.setAttribute("pagenate",pagerLogic.getPagenate());
              request.setAttribute("productList",productList);
        }

        RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/jsp/items.jsp");
        dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    request.setCharacterEncoding("UTF-8");
		doGet(request, response);

	}

}
