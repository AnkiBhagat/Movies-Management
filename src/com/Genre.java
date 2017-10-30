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

public class Genre extends HttpServlet {

    public Genre() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json"); 
		
        String language = request.getParameter("language");
		String genre = request.getParameter("genre");
		
		ServletConfig config = getServletConfig();
		String s=config.getServletContext().getInitParameter("MyDriver");
		List<Movies> genrelist=new ArrayList<Movies>();
		
		PrintWriter out = response.getWriter();
	
		System.out.println("gener: "+genre+" language: "+language);
		
		
		/*response.setContentType("text/html;charset=UTF-8");*/
       
		try {
			Statement st= null;
			Connection cnn =MyConnection.getConnection();
			String query;
			
			if(language.equals("novalue")){
				 query = "select distinct featured_image,movie_length,movie_release_date from movies join category on movies.id=category.movie_id where genre='"+genre+"' order by movie_length,movie_release_date";		
				}
			else{
				 query = "select distinct featured_image,movie_length,movie_release_date from movies join category on movies.id=category.movie_id where genre='"+genre+"' and language='"+language+"' order by movie_length,movie_release_date";		
				
			}
			//String query = "select distinct featured_image,movie_length,movie_release_date from movies join category on movies.id=category.movie_id where genre='"+genre+"' order by movie_length,movie_release_date";		
			
			System.out.println(query);
			st= cnn.createStatement();
			ResultSet rs = st.executeQuery(query);
            while(rs.next()){  
            	Movies m=new Movies();  
                m.setFeatured_image(rs.getString(1));
                genrelist.add(m);  
            } 
           /* JSONObject responseDetailsJson = new JSONObject();
            JSONArray jsonArray = new JSONArray();*/
            for(int i=0; i<genrelist.size(); i++)
            {
            response.getWriter().write(genrelist.get(i).getFeatured_image()+",");
       
            }
            
            cnn.close(); 
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		for(Movies movie:genrelist){
			System.out.println(movie.getFeatured_image());
		}
	}
	}


