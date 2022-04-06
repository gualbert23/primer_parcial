
package com.emergentes.controlador;

import com.emergentes.modelo.Producto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Gualbert
 */
@WebServlet(name = "MainController", urlPatterns = {"/MainController"})
public class MainController extends HttpServlet {

    
    

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession ses = request.getSession();
        
        if(ses.getAttribute("listapro")== null){
            ArrayList<Producto> listaux = new ArrayList<Producto>();
            ses.setAttribute("listapro", listaux);
        }
        
        ArrayList<Producto> lista = (ArrayList<Producto>) ses.getAttribute("listapro");
        
        String op = request.getParameter("op");
        String opcion = (op != null) ? request.getParameter("op") : "view";
        
        Producto obj1 = new Producto();
        int id, pos;
        
        switch (opcion){
            case "nuevo":
                request.setAttribute("miProducto", obj1);
                request.getRequestDispatcher("editar.jsp").forward(request, response);
            break;
            
            case "editar":
                id=Integer.parseInt(request.getParameter("id"));
                pos = buscarIndice(request,id);
                obj1 = lista.get(pos);
                request.setAttribute("miProducto", obj1);
                request.getRequestDispatcher("editar.jsp").forward(request, response);
                
            break;
            
            case "eliminar":
                pos = buscarIndice(request, Integer.parseInt(request.getParameter("id")));
                lista.remove(pos);
                ses.setAttribute("listapro", lista);
                response.sendRedirect("index.jsp");
            break;
            
            case "view":
                response.sendRedirect("index.jsp");
            break;
            
            
        } 
        
        
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession ses =request.getSession();
        ArrayList<Producto> lista = (ArrayList<Producto>) ses.getAttribute("listapro");
        
        
        Producto obj = new Producto();
        
        obj.setId(Integer.parseInt(request.getParameter("id")));
        obj.setDescripcion("descripcion");
        obj.setCantidad(Integer.parseInt(request.getParameter("cantidad")));
        obj.setPrecio(Double.parseDouble(request.getParameter("precio")));
        obj.setCategoria("categoria");
   
        int idt = obj.getId();
        
        if(idt==0){
            int ultID = ultimoId(request);
            obj.setId(ultID);
            lista.add(obj);
        }
        else{
            lista.set(buscarIndice(request, idt), obj);
        }
        ses.setAttribute("listapro", lista);
        response.sendRedirect("index.jsp");
    }

   private int ultimoId(HttpServletRequest request){
       HttpSession ses = request.getSession();
       ArrayList<Producto> lista = (ArrayList<Producto>) ses.getAttribute("listapro");
       
       int idaux = 0;
       
       for(Producto item : lista){
           idaux = item.getId();
       }
       return idaux+1;
   }
   
   private int buscarIndice(HttpServletRequest request, int id){
       HttpSession ses = request.getSession();
       ArrayList<Producto> lista = (ArrayList<Producto>) ses.getAttribute("listapro");
       
       int i=0;
       if(lista.size()>0){
           while(1<lista.size()){
               if(lista.get(i).getId()==id){
                   break;
               }
               else{
                   i++;
               }
           }
       }
       return i;
   }
    

}
