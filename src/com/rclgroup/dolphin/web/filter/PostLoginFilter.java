package com.rclgroup.dolphin.web.filter;

 

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.rclgroup.dolphin.web.utils.Utils;
 
/**
* @version 1.0
* @author NIIT
*/
public class PostLoginFilter implements Filter  {
	private String LOGIN_URL="/page/login";
	
	private static List<String> loginURls=new ArrayList<>();

	static {
		loginURls.add("/forgetPassword");
		 
		
	}
	/**
	 * @see javax.servlet.Filter#void ()
	 */
	public void destroy() {

	}

	/**
	 * @see javax.servlet.Filter#void (javax.servlet.ServletRequest,
	 *      javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws ServletException, IOException {
		HttpServletRequest hreq = null;
		 
		hreq = (HttpServletRequest) req;
		 
		//Locale.setDefault(Locale.ENGLISH); /* Get UAB from Session */
		/*if (!VAMPageConfigProperties.listOfPages.contains(req.getServletPath()) || req.getServletPath().indexOf(ch)) 
		{
			request.setAttribute("errorMessage", "UserDoesno exi");
			request.getRequestDispatcher("errorPage404.do").forward(request, response);
		}*/
		 String path =hreq.getPathInfo();
//		 boolean isNotLogin=path.indexOf("serv00444")==-1 || path.indexOf("serv00111")==-1;
		if(!loginURls.contains(path) ){
		if (Utils.getUserFromSession(hreq) == null) {
			req.setAttribute("logout", "true");
			req.getRequestDispatcher(LOGIN_URL).forward(req, resp);
			return ;
			
		}
		}
		chain.doFilter(req, resp);
	
		 

	}

	 
	/**
	 * Method init.
	 * 
	 * @param config
	 * @throws javax.servlet.ServletException
	 */
	public void init(FilterConfig config) throws ServletException {

	}
}

/*
* Modification History
*
* 2005-07: Modified for Tops 2009-11: Moified for EZL
*
*/
