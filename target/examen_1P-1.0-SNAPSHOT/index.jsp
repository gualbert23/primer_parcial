<%-- 
    Document   : index
    Created on : Apr 5, 2022, 7:03:40 PM
    Author     : Gualbert
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.emergentes.modelo.Producto"%>
<%
    ArrayList<Producto> lista =(ArrayList<Producto>) session.getAttribute("listapro");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Productos</h1>
        <a href="MainController?op=nuevo">Nuevo</a>
        <table border="1">
            <tr>
                <th>ID</th>
                <th>DESCRIPCCION</th>
                <th>CANTIDAD</th>
                <th>PRECIO</th>
                <th>CATEGORIA</th>
                <th></th>
                <th></th>
            </tr>
            
            <%
                if(lista != null){
                    for(Producto item : lista){
                    
                
            %>
            
            <tr>
                <td><%=item.getId()%></td>
                <td><%=item.getDescripcion()%></td>
                <td><%=item.getCantidad()%></td>
                <td><%=item.getPrecio()%></td>
                <td><%=item.getCategoria()%></td>
                <td> <a href="MainController?op=editar&id=<%=item.getId()%>">Editar</a></td>
                <td> <a href="MainController?op=eliminar&id=<%=item.getId()%>"
                        onclick='return confirm("Esta seguro de eliminar el registro ?")'>Eliminar</a></td>
                
            </tr>
            
            <%
                     }
                }
            %>
        </table>
    </body>
</html>
