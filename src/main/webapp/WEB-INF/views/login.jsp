<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
	<head>
		<title>Prova Spring + JSP | Login</title>
	</head>
	<body>
		<h1>${intestazione}</h1>
		<p>${saluti}</p>
		<hr />
		
		<c:if test="${not empty messaggio}">
			<p style="color:red;">${messaggio}</p>
		</c:if>
		
		<h1>Esegui qui sotto il login.</h1>
		<form action="login" method="POST">
			<input type="text" name="email" placeholder="Email"/>
			<input type="password" name="password" placeholder="Password"/>
			<input type="submit" value="Login" />
		</form>
	</body>
</html>
