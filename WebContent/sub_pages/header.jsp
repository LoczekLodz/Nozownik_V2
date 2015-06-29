<span id="slogan">Nożownik</span>

<!-- tabs -->
<ul>
  <li><a href="index.jsp"><span>Home</span></a></li>
  <li><a href="getProducts"><span>Products</span></a></li>
  <li><a href="kontakt.jsp"><span>About</span></a></li>
  <li><a href="javascript:load_login_page();"><span>Basket</span></a></li>
  
<%
  String login = (String) session.getAttribute("login");
  if (null == login) {
%>  
         <li><a href="javascript:load_login_page();"><span>Login</span></a></li>
<% } else { %>
       <li><a href="logout"><span>Logout[<%= login %>]</span></a></li> 
<% } %>
</ul>