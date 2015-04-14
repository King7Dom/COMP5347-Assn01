package au.edu.sydney.productList;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import au.edu.sydney.productList.model.Product;

@WebServlet(value="/rateProduct")
public class ProductRatingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
     * @see HttpServlet#HttpServlet()
     */
	public ProductRatingController() {
		super();
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int rating = Integer.valueOf(request.getParameter("rating")).intValue();
		int productNum = Integer.valueOf(request.getParameter("productNum")).intValue();
		Product[] productList = (Product[]) getServletContext().getAttribute("productList");
		Product product = productList[productNum];
		// Update histogram
		product.getRatings()[rating - 1] += 1;
		// Update average rating
		float oldTotal = product.getAverageRating() * product.getNumberOfRatings();
		product.setNumberOfRatings(product.getNumberOfRatings() + 1);
		float newTotal = oldTotal + rating;
		product.setAverageRating(newTotal / product.getNumberOfRatings());
		
		HttpSession session = request.getSession();
		int[] userRating = (int[]) session.getAttribute("userRating");
		if (userRating == null) {
			System.out.println("New Rating");
			userRating = new int[5];
			session.setAttribute("userRating", userRating);
		}
		
		if (userRating[productNum] == 0) {
			userRating[productNum] = rating;
		} else {
			System.out.println("User shouldn't be able to rate a product more than once");
		}
		
		response.sendRedirect("productDetail?product="+Integer.valueOf(productNum).toString());
	}
}
