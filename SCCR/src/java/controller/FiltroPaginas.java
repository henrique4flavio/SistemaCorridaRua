
package controller;


import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/*")
public class FiltroPaginas implements Filter {

    public FiltroPaginas() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//HttpSession sessao = request.getSession();
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		
		String url = httpServletRequest .getRequestURI();
		
		HttpSession session = httpServletRequest.getSession();
		
		if (session.getAttribute("usuario")!=null || url.lastIndexOf("index.jsp")>-1 ||
		url.lastIndexOf("LoginController") >-1  || url.endsWith("manterAtleta.jsp") || url.lastIndexOf("ManterAtletaController") >-1){
		chain.doFilter(request, response); 
		}else{
		((HttpServletResponse) response).sendRedirect("index.jsp");
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}
