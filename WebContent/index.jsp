<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>

<meta name="Description" content="Information architecture, Web Design, Web Standards." />
<meta name="Keywords" content="your, keywords" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="Distribution" content="Global" />
<meta name="Author" content="piotr.kijanski@gmail.com" />
<meta name="Robots" content="index,follow" />

<link rel="stylesheet" href="images/Underground.css" type="text/css" />
<!-- import css files -->
<link href="css/jquery-ui.css" rel="stylesheet" />
<link href="css/page.css" rel="stylesheet" />
<!-- import javascript -->
<script src="scripts/jquery.js"></script>
<script src="scripts/jquery-ui.js"></script>
<script src="scripts/common.js"></script>

<title>Nożownik</title>

</head>

<body onload="load_page_basic_components();load_main_page()">
<!-- wrap starts here -->
<div id="wrap">

		<!-- header -->
		<div id="header">
		</div>

		<div id="header-logo">
		</div>

		<div id="sidebar">
		</div>

		<div id="main">
		</div>

<!-- wrap ends here -->
</div>

<!-- footer starts here -->
<div id="footer" class="footer">
</div>

<%
  String login = (String) session.getAttribute("login");
  Boolean checkLogin = (Boolean) session.getAttribute("checkLogin");
  if (null != checkLogin && checkLogin && null == login) {
%>  
  <script>alert("Login incorrect")</script>
<% 
  session.setAttribute("checkLogin", false);
  } %>

<%
  Boolean registerred = (Boolean) session.getAttribute("registerred");
  if (null != registerred && registerred) {
%>  
  <script>alert("Register complete. Please login")</script>
<% 
  session.setAttribute("registerred", false);
  } %>

</body>
</html>
