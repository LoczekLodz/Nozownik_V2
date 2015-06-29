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

<title>Nozownik</title>

</head>

<body onload="load_page_basic_components()">
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
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>About us</h1>

<p>Fake company.<br/><strong>Do not trust us</strong></p>

<h1>How to find us</h1>

<p>
Fake company.<br/><strong>Do not trust us</strong>
</p>

test

<c:forEach var="prod" items="${products}">
    <tr>
      <td>${prod.id}</td>
    </tr> 
  </c:forEach>

  test 2
		</div>

<!-- wrap ends here -->
</div>

<!-- footer starts here -->
<div id="footer" class="footer">
</div>

</body>
</html>
