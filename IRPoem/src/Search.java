

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.search.highlight.InvalidTokenOffsetsException;

import test.Indexer;
import test.Poem;
import test.Printer;
import test.Searcher;

/**
 * Servlet implementation class Search
 */
@WebServlet("/Search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Search() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Printer.cls();
		request.setCharacterEncoding("UTF-8"); 
		response.setCharacterEncoding("UTF-8");
//		new Indexer().index("index3");
		String querystr = request.getParameter("key");
		
		//querystr = "123";
		System.out.println("key="+querystr);
        try {
            new Searcher(Attr.attr.indexDir).search(querystr);
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidTokenOffsetsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		response.getWriter().append("<font color=\"red\">");
//		response.getWriter().append(querystr);
//		response.getWriter().append("</font>");
//        response.getWriter().append(new String(Printer.getOutput().getBytes("gbk"),"UTF-8"));
        Vector<Poem> poems = Printer.getPoems();
        int size = poems.size();
        System.out.println(size);
        for(int i=0;i<size;i++){
        	Poem pm = poems.get(i);
        	System.out.println(pm.getName());
            response.getWriter().append(" <div class=\"row\">\n" +
                    "    <div class=\"col s4 offset-s2\">\n" +
                    
//            		
                    "      <div class=\"card blue-grey darken-1\">\n" +
                    "        <div class=\"card-content white-text\">\n" +
                    "          <span class=\"card-title\">"+pm.getName()+"<p>"+pm.getAuthor()+" "+pm.getDestiny()+"</p></span>\n" +
                    "          <p id = \"short"+i+"\">"+pm.getContent().substring(0,10)+"</p>\n" +
                    "        </div>\n" +
                    "<p id = \"show"+i+"\" style=\"display:none;\">"+pm.getContent()+"</p>\n"+
                    "        <div class=\"card-action\">\n" +
                    "          <a class=\"showmore\" id=\"showmore"+i+"\" href=\"JAVASCRIPT:show("+i+");\">MORE</a>\n" +
                    "          <a id=\"showsim"+i+"\" href=\"JAVASCRIPT:showsim("+i+","+pm.getId()+");\">Get Similar Poems</a>\n" +
                    "<div id = \"sim"+i+"\" ></div>\n"+
                    "      </div>\n" +
                    "    </div>\n" +
                    "    </div>\n" );
                    
                    i+=1;
                    pm = poems.get(i);
                    response.getWriter().append(
 "    <div class=\"col s4 \">\n" +
 
//
"      <div class=\"card blue-grey darken-1\">\n" +
"        <div class=\"card-content white-text\">\n" +
"          <span class=\"card-title\">"+pm.getName()+"<p>"+pm.getAuthor()+" "+pm.getDestiny()+"</p></span>\n" +
"          <p id = \"short"+i+"\">"+pm.getContent().substring(0,10)+"</p>\n" +
"        </div>\n" +
"<p id = \"show"+i+"\" style=\"display:none;\">"+pm.getContent()+"</p>\n"+
"        <div class=\"card-action\">\n" +
"          <a class=\"showmore\" id=\"showmore"+i+"\" href=\"JAVASCRIPT:show("+i+");\">MORE</a>\n" +
"          <a id=\"showsim"+i+"\" href=\"JAVASCRIPT:showsim("+i+","+pm.getId()+");\">Get Similar Poems</a>\n" +
"<div id = \"sim"+i+"\" ></div>\n"+
"      </div>\n" +
"    </div>\n" +
"    </div>\n" +
                    
                    
                    
                    
                    
                    "  </div>\n");
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
