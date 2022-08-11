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
import mmit.z2p.model.service.BatchService;

@WebServlet(urlPatterns = {"/batches"})
public class BatchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BatchService batchService;
    
    @Override
    public void init(ServletConfig config) throws ServletException {
    	super.init(config);
    	EntityManagerFactory emf_obj = (EntityManagerFactory) getServletContext().getAttribute("emf");
		if(emf_obj == null) {
			emf_obj = Persistence.createEntityManagerFactory("z2p");
			getServletContext().setAttribute("emf", emf_obj);
		}
		batchService = new BatchService(emf_obj.createEntityManager());
    }
    @Override
	public void destroy() {
		super.destroy();
		EntityManagerFactory emf_obj = (EntityManagerFactory) getServletContext().getAttribute("emf");
		if(emf_obj != null && emf_obj.isOpen())
			emf_obj.close();
	}
    public BatchController() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		var action = request.getServletPath();
		if("/batches".equals(action))
			goHomePage(request, response);
	}

	
	private void goHomePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		var list = batchService.findAll();
		request.setAttribute("title", "Batch");
		request.setAttribute("batches", list);
		getServletContext().getRequestDispatcher("/batch-home.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)  {
		
	}

}
