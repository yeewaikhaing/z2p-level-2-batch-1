package mmit.z2p.controller;

import java.io.IOException;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mmit.z2p.model.entity.Level;
import mmit.z2p.model.service.LevelService;

@WebServlet(urlPatterns = {"/levels", "/add-level", "/edit-level"})
public class LevelController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private LevelService service;
    
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		EntityManagerFactory emf_obj = (EntityManagerFactory) getServletContext().getAttribute("emf");
		if(emf_obj == null) {
			emf_obj = Persistence.createEntityManagerFactory("z2p");
			getServletContext().setAttribute("emf", emf_obj);
		}
		service = new LevelService(emf_obj.createEntityManager());
	}
	
	@Override
	public void destroy() {
		super.destroy();
		EntityManagerFactory emf_obj = (EntityManagerFactory) getServletContext().getAttribute("emf");
		if(emf_obj != null && emf_obj.isOpen())
			emf_obj.close();
	}
	
    public LevelController() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		var action = request.getServletPath();
		
		if("/levels".equals(action)) {
			goHomePage(request, response);
		}
		else if("/add-level".equals(action) || "/edit-level".equals(action))
			goAddPage(request, response);
		
	}

	
	private void goAddPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		var levelId = request.getParameter("id");
		
		var obj = (levelId == null) ? new Level() : service.findById(Integer.parseInt(levelId));
		
		request.setAttribute("title", "Level");
		request.setAttribute("level", obj);
		
		
		getServletContext().getRequestDispatcher("/level-add.jsp").forward(request, response);
		
	}


	private void goHomePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		var list = service.findAll();
		
		request.setAttribute("title", "Level");
		request.setAttribute("levels", list);
		getServletContext().getRequestDispatcher("/level-home.jsp").forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException  {
		
		var id = request.getParameter("levelId");
		
		//System.out.println("Id: " + id);
		var lvl = ("0".equals(id)) ? new Level() : service.findById(Integer.parseInt(id));
		
		lvl.setName(request.getParameter("name"));
		lvl.setDuration(Integer.parseInt(request.getParameter("duration")));
		lvl.setFees(Integer.parseInt(request.getParameter("fees")));
		
		service.save(lvl);
		
		response.sendRedirect(request.getContextPath().concat("/levels"));
	}

}
