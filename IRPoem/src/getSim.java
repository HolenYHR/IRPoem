

import java.io.IOException;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.getPoem;
import test.Poem;

/**
 * Servlet implementation class getSim
 */
@WebServlet("/getSim")
public class getSim extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getSim() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8"); 
		response.setCharacterEncoding("UTF-8");
		String querystr = request.getParameter("id");
		String res = getPoem.getList(Integer.parseInt(querystr));
		System.out.println("***********"+res);
		Scanner sin = new Scanner(res);
		while(sin.hasNext()){
			int id = sin.nextInt();
			Poem tp = getPoem.get(id);
			System.out.println(tp.getName());
			response.getWriter().append("<div>"
					+ "<a href=\"JAVASCRIPT:getPoem("+tp.getId()+")\">"+tp.getName()+"</a>"
							+ "<br/>"
					+ "</div>");
		}
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
