package main;



import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Cart;
import model.Product;
import DB.ProductDB;

/**
 * Servlet implementation class AddToCart
 */
@WebServlet("/Shoppingcart")
public class Shoppingcart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Shoppingcart() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	Cart cart =new Cart();
    	//List<Cart> carts = CartDB.getCarts();
    	String lineData = "<table class='table table-bordered table-striped'>";
    	lineData += "<thead>";
		lineData += "<tr>";
		lineData += "<th>";
		lineData += "Product Name";
		lineData += "</th>";
		lineData += "<th>";
		lineData += "Price";
		lineData += "</th>";
		lineData += "<th>";
		lineData += "Quantity";
		lineData += "</th>";
		lineData += "<th>";
		lineData += "Line Total";
		lineData += "</th>";
		lineData += "</tr>";
		lineData += "</thead>";
		List<Product> products =  ProductDB.getAllProducts();
	
		
		double total = 0;
		for(Product product : products)
		{
			
			lineData += "<tr>";
			lineData += "<td>";
			
			//lineData += cart.getProduct().getPname();
			lineData += product.getPname();
			lineData += "</td>";
			lineData += "<td>";
			//lineData += cart.getProduct().getPrice();
			lineData += product.getPrice();
			lineData += "</td>";
			lineData += "<td>";
			lineData += cart.getQuantity();
			lineData += "</td>";
			lineData += "<td>";
			//lineData += cart.getLineTotal();
			lineData += "</td>";
			lineData += "</tr>";
			//total += lineItem.getLineTotal();
			
		}
		lineData +="<tr>";
		lineData +="<td colspan='3'>" + "Total" + "</td>";
		lineData +="<td>" + total + "</td>";
		lineData +="</tr>";
		lineData +="</table>";
		request.setAttribute("lineData", lineData);
		
		
		long NumItems=ProductDB.getCount();
		HttpSession session = request.getSession();
		session.setAttribute("NumItems", NumItems);
		getServletContext().getRequestDispatcher("/ShoppingCart.jsp").forward(request, response);
    }
		
		
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}
		
		


}   
    
    
    