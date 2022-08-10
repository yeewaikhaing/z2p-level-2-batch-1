package mmit.z2p.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/levels"})
public class LevelController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LevelController() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		var action = request.getServletPath();
		var title = "";
		var page = "/index.jsp";
		if("/levels".equals(action)) {
			title = "Level";
			page = "/level-home.jsp";
		}
		
		request.setAttribute("title", title);
		getServletContext().getRequestDispatcher(page).forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)  {
		
	}

}
