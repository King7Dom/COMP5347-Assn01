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
		request.setAttribute("productNum", productNum);
		
		// Find out the highest number of ratings for one particular score
		int maxNumOfRating = 0;
		int[] ratings = product.getRatings();
		for (int i = 0; i < ratings.length; i++) {
			if (ratings[i] > maxNumOfRating) {
				maxNumOfRating = ratings[i];
			}
		}
		request.setAttribute("maxNumOfRating", maxNumOfRating);
		// This is the style that progress bar should be in
		String[] progressBarStyles = {"progress-bar-danger", "progress-bar-danger progress-bar-striped", "progress-bar-warning", "progress-bar-success", "progress-bar-success progress-bar-striped"};
		request.setAttribute("progressBarStyles", progressBarStyles);
		
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
