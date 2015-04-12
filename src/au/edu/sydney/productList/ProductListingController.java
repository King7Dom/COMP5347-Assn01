package au.edu.sydney.productList;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;

import au.edu.sydney.productList.model.Product;

@WebServlet(value="/productListing")
public class ProductListingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
     * @see HttpServlet#HttpServlet()
     */
	public ProductListingController() {
		super();
	}
	
	/**
	 * Populate the product listing data
	 */
	public void init() {
		Product iPhone = new Product("Apple iPhone 6", "img/iPhone6.png", 109.95f, 3.5f, 2);
		Product GalaxyS6 = new Product("Samsung Galaxy S6", "img/GalaxyS6.jpg", 79.95f, 3.2f, 3);
		Product MotoX = new Product("Motorola Moto X", "img/MotoX.png", 79.95f, 0, 0);
		Product OneM9 = new Product("HTC One M9", "img/OneM9.jpg", 79.95f, 3.7f, 4);
		Product G3 = new Product("LG G3", "img/G3.jpg", 79.95f, 3.7f, 4);
		Product[] productList = {iPhone, GalaxyS6, MotoX, OneM9, G3};
		getServletContext().setAttribute("productList", productList);
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher view = request.getRequestDispatcher("/productListing.jsp");
		view.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
}
