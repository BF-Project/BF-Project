//package com.pro.bf.filter;
//
//import java.io.IOException;
//import java.util.StringTokenizer;
//
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.FilterConfig;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//
//public class LoginCheckFilter implements Filter{
//   
//   private String[] uri = null;
//
//   @Override
//   public void init(FilterConfig arg0) throws ServletException {
//      String names = arg0.getInitParameter("uri");
//      StringTokenizer st = new StringTokenizer(names, ",");
//      uri = new String[st.countTokens()];
//      for(int i=0; st.hasMoreTokens(); i++){
//         uri[i] = st.nextToken();
//      }
//   }
//   
//   @Override
//   public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//      HttpServletRequest httpRequest = (HttpServletRequest) request;
//      HttpSession session = httpRequest.getSession(false);
//      boolean login = false;
//      if(includeUri(httpRequest)){
//         if(session != null){
//            if(session.getAttribute("loginUser") != null){
//               chain.doFilter(request, response);
//               return;
//            }
//         }
//         if(login){
//            return;
//         }else{ // login의 기본 값이 false임, 로그인이 되어 있지 않다면 여기로옴
//            request.getRequestDispatcher("/loginForm.do").forward(request, response);
////            RequestDispatcher dispatcher = request.getRequestDispatcher("/loginForm.jsp");
////            dispatcher.forward(request, response);
//            return;
//         }
//      }else{
//         chain.doFilter(request, response);
//         return;
//      }
//   }
//
//   private boolean includeUri(HttpServletRequest request){
//      String requestUri = request.getRequestURI().toString().trim().toLowerCase();
//      boolean result = false;
//      if(requestUri.contains("admin")){
//         return false;
//      }
//      for(int i = 0; i < uri.length; i++){
//         if(requestUri.contains(uri[i])){
//            return true;
//         }
//      }
//      return result;
//   }
//   
//   @Override
//   public void destroy() {
//   }
//}