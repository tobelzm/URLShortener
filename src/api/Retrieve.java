package api;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Retrieve
 */
@WebServlet("/Retrieve")
public class Retrieve extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Retrieve() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
 
    String urlId = request.getServletPath();
 
    String longUrl = null;
    if (urlId != null && !"".equals(urlId)) {
        try {
        longUrl = new Logic().getLongUrl(urlId);
        } catch (Exception e) {
        // handling exception here
        e.printStackTrace();
        }
    }
 
    if (longUrl == null) {
        // if long url not found, send to index.jsp
        System.out.println("long url not found, back to index.jsp");
        response.sendRedirect("index.jsp");
    } else {
        //if long url found, so redirect the browser
        System.out.println("redirecting to "+longUrl );
        response.sendRedirect("http://" + longUrl);
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
