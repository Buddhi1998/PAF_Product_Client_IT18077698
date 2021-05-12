package com;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.product;

/**
 * Servlet implementation class productAPI
 */
@WebServlet("/productAPI")
public class productAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
	product productObj = new product();
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public productAPI() {
        super();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		
				String output =  productObj.insertproduct(request.getParameter("id"),
				 request.getParameter("name"), 
				request.getParameter("amount"), 
				request.getParameter("des"));
		
		         System.out.println(output);
		        response.getWriter().write(output);
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
		Map paras = getParasMap(request); 
		 String output =productObj.updateproduct( paras.get("id").toString(), 
		 paras.get("name").toString(), 
		 paras.get("amount").toString(), 
		 paras.get("des").toString()
		
				 ); 
		 
		response.getWriter().write(output); 
		} 

	
	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Map paras = getParasMap(request); 
		 
		String output = productObj.deleteproduct(paras.get("id").toString()); 
		response.getWriter().write(output);
	}
	
	
	
	private Map getParasMap(HttpServletRequest request) {
		
		
		Map<String, String> map = new HashMap<String, String>(); 
		try
		 { 
		 Scanner scanner = new Scanner(request.getInputStream(), "UTF-8"); 
		 String queryString = scanner.hasNext() ? 
		 scanner.useDelimiter("\\A").next() : ""; 
		 scanner.close(); 
		 String[] params = queryString.split("&"); 
		 for (String param : params) 
		 { 
		String[] p = param.split("=");
		 map.put(p[0], p[1]); 
		 } 
		 } 
		catch (Exception e) 
		 { 
		 } 
		return map; 
	}


}