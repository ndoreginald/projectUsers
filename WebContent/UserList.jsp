<%@page language="java" import="java.util.ArrayList, metier.User"%>
<%@include file="entete.jsp" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<% 
  String mc = (String) request.getAttribute("motCle");
	if (mc==null) mc="";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">

	
<title>Consultation</title>
</head>
<div>
<body >
	Rechercher utilisateur(s) par son nom...
	
	<div>
		<form action="UserListController" method="POST">
			<table>
				<tr>
					<td>Nom:</td>
					<td><input type="text" name="motCle" value =<%=mc%>/></td>
				</tr>
				<tr>
					<td align="center" colspan="2"><input type="submit" value="ok" />
					<input type="reset" value="Annuler" /></td>
				</tr>
			</table>
		</form>
		
			<hr>
			<br><br><br>

		Liste des utilisateurs
		<hr>
			<table border ="1">
			<tr>
				<th>Nom:</th>
				<th>Prenom:</th>
				<th>Login:</th>
				<th>Mot de passe:</th>
				<th colspan="2">Actions:</th>
				
			</tr>
		
		
		<%
			ArrayList users = (ArrayList) session.getAttribute("listOfUsers");
			if (users !=null) {
				
				for (int i = 0; i < users.size(); i++) 
				{
					out.println("<tr>");
					out.println("<td> " + ((User) users.get(i)).getNom() + "</td>");
					out.println("<td> " + ((User) users.get(i)).getPrenom() + "</td>");
					out.println("<td> " + ((User) users.get(i)).getLogin() + "</td>");
					out.println("<td> " + ((User) users.get(i)).getPassword() + "</td>");
					out.print("<td>  <a href ='UserEditionController?id="+((User) users.get(i)).getId()+"&mode=Edition"+"'>Modifier</a> </td>");
					out.println("<td>  <a href ='UserEditionController?id="+((User) users.get(i)).getId()+"&mode=Suppression"+"'  onclick='return confirm(\"Voulez vous vraiment supprimer cet utilisateur ?\")'      >Supprimer</a> </td>");

					
					out.println("</tr>");
				}
				
			}
		%>
		
			
		</table>

<hr>
<a href ="UserForm.jsp">Ajouter</a>
</div>

</body>
</html>