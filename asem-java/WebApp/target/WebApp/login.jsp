<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String userName = request.getParameter("userName");
    String password = request.getParameter("password");

    if (userName.equalsIgnoreCase("root") &&
            password.equals("croot")){
        response.sendRedirect("success.jsp");
    }else {
        response.sendRedirect("index.jsp");
    }

%>