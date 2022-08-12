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
import mmit.z2p.model.entity.Course;
import mmit.z2p.model.service.CourseService;
import mmit.z2p.model.service.LevelService;

@WebServlet(urlPatterns = {"/courses", "/add-course"})
public class CourseController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CourseService courseService;
    private LevelService lvlSerice;
    @Override
    public void init(ServletConfig config) throws ServletException {
    	super.init(config);
    	EntityManagerFactory emf_obj = (EntityManagerFactory) getServletContext().getAttribute("emf");
		if(emf_obj == null) {
			emf_obj = Persistence.createEntityManagerFactory("z2p");
			getServletContext().setAttribute("emf", emf_obj);
		}
		courseService = new CourseService(emf_obj.createEntityManager());
		lvlSerice = new LevelService(emf_obj.createEntityManager());
    }
    @Override
	public void destroy() {
		super.destroy();
		EntityManagerFactory emf_obj = (EntityManagerFactory) getServletContext().getAttribute("emf");
		if(emf_obj != null && emf_obj.isOpen())
			emf_obj.close();
	}
    public CourseController() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		var action = request.getServletPath();
		if("/courses".equals(action))
			goHomePage(request, response);
		else if("/add-course".equals(action))
			goAddPage(request, response);
	}

	
	private void goAddPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		var obj = new Course();
		var list = lvlSerice.findAll();
		request.setAttribute("title", "Course");
		request.setAttribute("course", obj);
		request.setAttribute("levels", list);
		getServletContext().getRequestDispatcher("/course-add.jsp").forward(request, response);
		
		
	}
	private void goHomePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		var list = courseService.findAll();
		request.setAttribute("title", "Course");
		request.setAttribute("courses", list);
		getServletContext().getRequestDispatcher("/course-home.jsp").forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)  {
		var courseId = request.getParameter("courseId");
	}

}
