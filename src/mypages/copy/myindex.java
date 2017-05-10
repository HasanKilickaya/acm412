package mypages.copy;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connectto.datamodel;
import connectto.ourConnector;

/**
 * Servlet implementation class myindex
 */
@WebServlet("/myindex")
public class myindex extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public myindex() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		
		ourConnector o=new ourConnector();
		ArrayList<datamodel> mydata=o.getitems();
		PrintWriter out=response.getWriter();
		int articlenumber=0;
		String input=request.getParameter("ind");
		
		if (input==null)
		{
			articlenumber=0;
		}else
		{
			articlenumber=Integer.parseInt(input);
		}
		
		String context="<html><head><link rel=\"stylesheet\" type=\"text/css\" href=\"/nf.css\"></head>";
		context+= "<body>";
		context+="<div id=\"container\">";
			context+="=<div id=\"header\">";
			context+="header content here";
					context+="</div>";
	    
			context+="<div id=\"content\">";
					context+="main content here";
					context+="</div>";
	    
							context+="<div id=\"sidebar\">";
							context+="<ul>";
							for (datamodel d:mydata)
							{
								context+="<li>"+"<a href=\"http://localhost:8080/vizesonrasi2/myindex?ind="+mydata.indexOf(d)+"\">"+d.getTopic()+"</li>";
							}
							context+="</ul>";
							context+="</div>";
	    
							context+="<div id=\"footer\">";
							context+="footer content here";
							context+="</div>";
							context+="</div>";
		
		
		
		context+="</body></html>";
		out.print(context);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
