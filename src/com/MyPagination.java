package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyPagination
 */
public class MyPagination extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPagination() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json"); 
		
		String min = request.getParameter("min");
	    String max = request.getParameter("max");
	    
	    System.out.println("min "+min);
	    System.out.println("max "+max);
		
		ServletConfig config = getServletConfig();
		String s=config.getServletContext().getInitParameter("MyDriver");
		List<Movies> list=new ArrayList<Movies>();
		
		PrintWriter out = response.getWriter();
	
		try {
			Statement st= null;
			Connection cnn =MyConnection.getConnection();
			//String query = "SELECT *FROM (SELECT a.*, rownum rnum FROM (select featured_image from movies join category on movies.id=category.movie_id order by movie_length,movie_release_date) a WHERE rownum <="+ max +") b WHERE rnum >"+ min;		
			String query = "select distinct featured_image,movie_length,movie_release_date from movies join category on movies.id=category.movie_id";		
			
			System.out.println("query "+query);
			st= cnn.createStatement();
			ResultSet rs = st.executeQuery(query);
            while(rs.next()){  
            	Movies m=new Movies();  
                m.setFeatured_image(rs.getString(1));
                list.add(m);  
            } 
        response.setContentType("application/json");

            
        for(int i=0; i<list.size(); i++)
        {
        response.getWriter().write(list.get(i).getFeatured_image()+",");
   
        }
            cnn.close(); 
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		for(Movies movie:list){
			System.out.println(movie.getFeatured_image());
		}
	}

}
