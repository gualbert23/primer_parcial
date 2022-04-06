<%-- 
    Document   : editar
    Created on : Apr 5, 2022, 7:36:29 PM
    Author     : Gualbert
--%>
<%@page import="com.emergentes.modelo.Producto"%>
<%

    Producto item =(Producto) request.getAttribute("miProdcuto");
    
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1> <%=(item.getId()==0)?"Nuevo Registro":"Editar registro" %> </h1>
        <form action="MainController" method="POST">
            <input type="hidden" name="id" value=" " />
            <table>
                <tr>
                    <td>Descripcion</td>
                    <td> <input type="text" name="descripccion" value="<%=item.getId()%>" /> </td>
                </tr>
                <tr>
                    <td>Cantidad</td>
                    <td><input type="text" name="cantidad" value="<%=item.getCantidad()%>" /></td>
                </tr>
                <tr>
                    <td>Precio</td>
                    <td><input type="text" name="precio" value="<%=item.getPrecio()%>" /></td>
                </tr>
                <tr>
                    <td>Categoria</td>
                    <td><input type="text" name="categoria" value="<%=item.getCategoria()%>" /></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Guardar" /></td>
                </tr>
            </table>
            
        </form>
        
    </body>
</html>
