package au.edu.sydney.productList;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import au.edu.sydney.productList.model.Product;

@WebServlet(value="/productDetail")
public class ProductDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
     * @see HttpServlet#HttpServlet()
     */
	public ProductDetailController() {
		super();
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Get the product from request object
		int productNum = Integer.valueOf(request.getParameter("product")).intValue();
		Product[] productList = (Product[]) getServletContext().getAttribute("productList");
		Product product = productList[productNum];
		request.setAttribute("product", product);
		RequestDispatcher view = request.getRequestDispatcher("/productDetail.jsp");
		view.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
}
