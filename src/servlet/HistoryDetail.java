package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.OrderDesc;
import model.OrderDescLogic;
import model.OrderMain;
import model.OrderMainLogic;
import model.Usr;



/**
 * Servlet implementation class Items
 */
@WebServlet("/HistoryDetail")
public class HistoryDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public HistoryDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        boolean toRedirect=false;

        HttpSession session=request.getSession();
        Usr loginUsr = (Usr) session.getAttribute("loginUsr");
        Integer po_id=0;
        String strPo_id=request.getParameter("po_id");
        try {
        po_id=Integer.parseInt(strPo_id);
        }catch(Exception e) {
            //
        }



        if(loginUsr!=null && po_id!=0) {
            OrderMainLogic orderMainLogic = new OrderMainLogic();
            List<OrderMain> orderMainList=orderMainLogic.selectByPoId(po_id);


            OrderDescLogic orderDescLogic = new OrderDescLogic();
            List<OrderDesc> orderDescList=orderDescLogic.selectByPo_id(po_id);


            if(orderDescList==null || orderMainList==null) {
                toRedirect=true;
            }else {

                Integer total=0;
                for(OrderDesc orderDesc:orderDescList) {
                    total=total+orderDesc.getQuantity()*orderDesc.getHist_price();
                }


                request.setAttribute("orderMainList",orderMainList);
                request.setAttribute("orderDescList",orderDescList);
                request.setAttribute("total",total);

                //本当はログインユーザーのものかのチェックが必要
            }

            request.setAttribute("toRedirect",toRedirect);
            RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/jsp/history-detail.jsp");
            dispatcher.forward(request, response);



        }else {

            RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/jsp/history-detail-redirect.jsp");
            dispatcher.forward(request, response);
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
