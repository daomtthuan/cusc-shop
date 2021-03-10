package vn.cusc.aptech.cuscshop.coresystem.war.filters;

import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import vn.cusc.aptech.cuscshop.coresystem.war.session.AuthSession;

@WebFilter(filterName = "DashboardFilter", urlPatterns = {"/pages/dashboard/*"})
public class DashboardFilter implements Filter {

  @Inject
  private AuthSession authSession;

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    HttpServletRequest req = (HttpServletRequest) request;
    HttpServletResponse res = (HttpServletResponse) response;

    if (!authSession.isLoggedIn()) {
      res.sendRedirect(req.getContextPath());
    } else {
      chain.doFilter(request, response);
    }
  }

  @Override
  public void destroy() {
  }

}
