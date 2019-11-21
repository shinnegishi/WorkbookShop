package servlet;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Usr;
import model.UsrLogic;;


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		int errorFlg=0;

		/*
		Enumeration<String> names = request.getParameterNames();
		while (names.hasMoreElements()) {
		    System.out.println(names.nextElement());
		}
        */

		String logout=request.getParameter("logout");

	    if(logout!=null) {
	          System.out.println(request.getParameter("logout") );

	          HttpSession session = request.getSession();
	          session.invalidate();
	          //response.sendRedirect("index.jsp");

	          request.setAttribute("errorMsg","ログアウトしました");
	          errorFlg++;

	          RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
	          dispatcher.forward(request, response);
	    }

        String login=request.getParameter("login");

		if(login!=null) {

    		String user_id = request.getParameter("user_id");
    		String password  = request.getParameter("password");

    		Usr usr=new Usr(user_id,password);

    		UsrLogic usrLogic = new UsrLogic();

    		if(usrLogic.findAUsr(usr)==null) {
    	          request.setAttribute("errorMsg","ユーザーIDもしくはパスワードが間違っています。");
    	          errorFlg++;
    		}else if(usrLogic.findAUsr(usr).size()==1) {
    	        HttpSession session=request.getSession();
    	        session.setAttribute("loginUsr", usrLogic.findAUsr(usr).get(0));
    		}else {
    	        request.setAttribute("errorMsg","ユーザーIDもしくはパスワードが間違っています。");
    	        errorFlg++;
    		}

    		if(errorFlg==0) {
    		    RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
    		    dispatcher.forward(request, response);
    		}
		}

		if(request.getParameter("login") !="" || errorFlg !=0){
		    System.out.println("BP1");
		    RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
            dispatcher.forward(request, response);

		}




        //RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
        //dispatcher.forward(request, response);




	}




    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        System.out.println("BP2");

        RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
        dispatcher.forward(request, response);

     }





}
