<%-- 
    Document   : clientes
    Created on : Dec 6, 2022, 11:29:13 PM
    Author     : iud_m
--%>

<%@page import="java.util.List"%>
<%@page import="modelo.TblClientes"%>
<%@page import="control.TblClientesControl"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro clientes</title>
    </head>
    <body>
        <h1 align="center">Clientes</h1>
        <br/>

        <%

            TblClientesControl tblClientesControl = new TblClientesControl();
            TblClientes tblClientesObj = null;

            if (request.getParameter("reg") == null) {
        %>
        <table width="90%" border="1" align="center">
            <tr>
                <th>Documento</th>
                <th>Nombre</th>
                <th>Telefono</th>
                <th>Direccion</th>
                <th width="70px" align="center"> <a href="?reg=si">Agregar</a></th>
                <th width="70px"></th>
            </tr>
            <%
                List<TblClientes> lista = tblClientesControl.listar();
                for (TblClientes c : lista) {
            %>
            <tr>
                <td align="center"><% out.print(c.getCedulaCliente());%></td>
                <td align="center"><% out.print(c.getNombreCliente());%></td>
                <td align="center"><% out.print(c.getTelefonoCliente());%></td>
                <td align="center"><% out.print(c.getDireccionCliente());%></td>
                <td align="center"> <a href="?reg=si&id=<%=c.getCedulaCliente()%>">Editar</a> </td>
                <td align="center"> <a href="#" onclick="if(confirm('Estas seguro?')){window.location.href='STblClientes?eliminar=si&cedula=<%=c.getCedulaCliente()%>';}">Eliminar</a> </td>
            </tr>
            <%
                }
            %>
        </table>
        <%
        } else {

            if (request.getParameter("id") != null) {
                Integer id = Integer.parseInt(request.getParameter("id"));
                tblClientesObj = new TblClientes(id);
                tblClientesObj = tblClientesControl.buscar(tblClientesObj);

            }

        %>

        <form action="STblClientes" method="post">
            <table border="1" align="center">
                <tr>
                    <td>Cedula</td>
                    <td>
                        <input type="number" name="cedula" value="<%                           
                                if (tblClientesObj != null) {
                                out.print(tblClientesObj.getCedulaCliente());
                            }%>">
                    </td>
                </tr>
                <tr>
                    <td>Nombre</td>
                    <td>
                        <input type="text" name="nombre" value="<%
                            if (tblClientesObj != null) {
                                out.print(tblClientesObj.getNombreCliente());
                            }%>">
                    </td>
                </tr>
                <tr>
                    <td>Telefono</td>
                    <td>
                        <input type="text" name="telefono" value="<%
                            if (tblClientesObj != null) {
                                out.print(tblClientesObj.getTelefonoCliente());
                            }%>">
                    </td>
                </tr>
                <tr>
                    <td>Dirección</td>
                    <td>
                        <input type="text" name="direccion" value="<%
                            if (tblClientesObj != null) {
                                out.print(tblClientesObj.getDireccionCliente());
                            }%>">
                    </td>
                </tr>
                <tr>
                    <td colspan="2">&nbsp;</td>
                </tr>
                <tr>
                    <td colspan="2" align="center"><input type="submit" value="Enviar"><br>
                        <a href="clientes.jsp" align="center">Cancelar</a>
                    </td>
                </tr>

            </table>

        </form>
        <%            }
        %>
    </body>
</html>
