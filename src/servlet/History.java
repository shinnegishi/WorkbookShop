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

import model.OrderMain;
import model.OrderMainLogic;
import model.Usr;


/**
 * Servlet implementation class Items
 */
@WebServlet("/History")
public class History extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public History() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");



        HttpSession session=request.getSession();
        Usr loginUsr = (Usr) session.getAttribute("loginUsr");

        if(loginUsr!=null) {
            OrderMainLogic orderMainLogic = new OrderMainLogic();
            List<OrderMain> orderMainList=orderMainLogic.findAllByUserId(loginUsr);

            if(orderMainList !=null){
                  request.setAttribute("orderMainList",orderMainList);
            }
        }



            RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/jsp/history.jsp");
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
