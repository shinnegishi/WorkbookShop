package servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ChkInputProc;
import model.Usr;
import model.UsrLogic;


/**
 * Servlet implementation class Items
 */
@WebServlet("/Regist")
public class Regist extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Regist() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		// TODO Auto-generated method stub
        request.setCharacterEncoding("UTF-8");

        String errorMsg="";
        Usr usr = new Usr();
        UsrLogic ul=new UsrLogic();

        ChkInputProc cil=new ChkInputProc();

        int status=0;


        Enumeration<String> names = request.getParameterNames();
        String buff="";
        while (names.hasMoreElements()) {
            buff=names.nextElement();
            System.out.println(buff);
            System.out.println(request.getParameter(buff));
        }


        HttpSession session=request.getSession();

        if(request.getParameter("clear")!=null) {
            session.removeAttribute("registUsr");
        }

        Usr registUsr = (Usr) session.getAttribute("registUsr");



        if(registUsr==null) {
            session.setAttribute("registUsr", usr);
	    }


        if(request.getParameter("regist0")!=null) {
            status=0;

                registUsr.setUser_id((registUsr.getUser_id()==null)? "":registUsr.getUser_id());

                registUsr.setPassword((registUsr.getPassword()==null)? "":registUsr.getPassword());
                registUsr.setL_name((registUsr.getL_name()==null)? "":registUsr.getL_name());
                registUsr.setF_name((registUsr.getF_name()==null)? "":registUsr.getF_name());
                registUsr.setL_name_kana((registUsr.getL_name_kana()==null)? "":registUsr.getL_name_kana());
                registUsr.setF_name_kana((registUsr.getF_name_kana()==null)? "":registUsr.getF_name_kana());
                registUsr.setPrefecture((registUsr.getPrefecture()==null)? "":registUsr.getPrefecture());
                registUsr.setCity((registUsr.getCity()==null)? "":registUsr.getCity());
                registUsr.setO_address((registUsr.getO_address()==null)? "":registUsr.getO_address());
                registUsr.setTel((registUsr.getTel()==null)? "":registUsr.getTel());
                registUsr.setEmail((registUsr.getEmail()==null)? "":registUsr.getEmail());

        }


        if(request.getParameter("regist1")!=null) {
            status=1;
        }

        if(request.getParameter("regist2")!=null) {
            status=2;
        }


        if(status==1) {
            try {
                //registUsr.setUser_id(ul.getNewID());
                registUsr.setPassword(cil.trimString(request.getParameter("password")));
                errorMsg+=cil.chkPassword(registUsr.getPassword());

                registUsr.setL_name(cil.trimString(request.getParameter("l_name")));
                errorMsg+=cil.chkL_name(registUsr.getL_name());

                registUsr.setF_name(cil.trimString(request.getParameter("f_name")));
                errorMsg+=cil.chkF_name(registUsr.getF_name());

                registUsr.setL_name_kana(cil.trimString(request.getParameter("l_name_kana")));
                errorMsg+=cil.chkL_name_kana(registUsr.getL_name_kana());

                registUsr.setF_name_kana(cil.trimString(request.getParameter("f_name_kana")));
                errorMsg+=cil.chkF_name_kana(registUsr.getF_name_kana());

                registUsr.setPrefecture(cil.trimString(request.getParameter("prefecture")));
                errorMsg+=cil.chkPrefecture(registUsr.getPrefecture());

                registUsr.setCity(cil.trimString(request.getParameter("city")));
                errorMsg+=cil.chkCity(registUsr.getCity());

                registUsr.setO_address(cil.trimString(request.getParameter("o_address")));
                errorMsg+=cil.chkO_address(registUsr.getO_address());

                registUsr.setTel(cil.trimString(request.getParameter("tel")));
                errorMsg+=cil.chkTel(registUsr.getTel());

                registUsr.setEmail(cil.trimString(request.getParameter("email")));
                errorMsg+=cil.chkEmail(registUsr.getEmail());


                if(errorMsg.length() == 0) {
                    status=1;
                }else {
                    status=0;
                }


            }catch(NullPointerException e) {
                e.printStackTrace();
            }
        }


        if(status==2) {
            try {
                registUsr.setUser_id(ul.getNewID());
                request.setAttribute("registUsr",registUsr);

                ul.insertUsr(registUsr);

                session.removeAttribute("registUsr");

            }catch(NullPointerException e) {
                e.printStackTrace();
            }
        }




        request.setAttribute("status",status);
        request.setAttribute("errorMsg",errorMsg);

            RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/jsp/regist.jsp");
            dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    request.setCharacterEncoding("UTF-8");
		doGet(request, response);

	}

}
