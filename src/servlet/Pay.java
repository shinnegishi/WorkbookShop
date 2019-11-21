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
import model.OrderDesc;
import model.OrderDescLogic;
import model.OrderMain;
import model.OrderMainLogic;
import model.Usr;



/**
 * Servlet implementation class Items
 */
@WebServlet("/Pay")
public class Pay extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Pay() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    request.setCharacterEncoding("UTF-8");

	    /*
        Enumeration<String> names = request.getParameterNames();
        while (names.hasMoreElements()) {
            System.out.println(names.nextElement());
        }
        */

        HttpSession session=request.getSession();
        Usr loginUsr = (Usr) session.getAttribute("loginUsr");
        List<Cart> cartList=(List<Cart>)session.getAttribute("cartList");
        boolean isOrdered=false;

        if(cartList==null) {
            cartList=new ArrayList<Cart>();
        }

        String rem2Cart=request.getParameter("rem2cart");
        String order=request.getParameter("order");
        System.out.println("BP1");

        if(rem2Cart!=null) {

            String p_id=request.getParameter("p_id");
            String p_name=request.getParameter("p_name");
            Integer price=Integer.parseInt(request.getParameter("price"));
            Integer count=Integer.parseInt(request.getParameter("count"));


            Cart cart=new Cart(p_id,p_name,price,count);
            System.out.println(cart);
            CartLogic cartLogic=new CartLogic();
            cartList=cartLogic.rem2Cart(cart,cartList);
            //System.out.println("name:"+cartList.get(0).getCount());
            session.setAttribute("cartList",cartList);

        }


        if(order!=null && !cartList.isEmpty() && loginUsr !=null) {

            OrderMain orderMain = new OrderMain(loginUsr.getUser_id());
            OrderMainLogic orderMainLogic = new OrderMainLogic();
            orderMain=orderMainLogic.insert(orderMain);
            List<OrderDesc> orderDescList=new ArrayList<OrderDesc>();

            for(Cart aCart:cartList) {
                    OrderDesc orderDesc=new OrderDesc(orderMain.getPo_id());
                    orderDesc.setP_id(aCart.getP_id());
                    orderDesc.setQuantity(aCart.getCount());
                    orderDesc.setHist_p_name(aCart.getP_name());
                    orderDesc.setHist_price(aCart.getPrice());
                    orderDescList.add(orderDesc);
            }

            OrderDescLogic orderDescLogic=new OrderDescLogic();
            orderDescLogic.insert(orderDescList);
            session.removeAttribute("cartList");
            isOrdered=true;

            request.setAttribute("po_id",orderMain.getPo_id());
        }


        request.setAttribute("isOrdered",isOrdered);
        RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/jsp/pay.jsp");
        dispatcher.forward(request, response);


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
