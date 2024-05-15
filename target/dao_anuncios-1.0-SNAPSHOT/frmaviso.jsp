<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Registro Dia del Internet</title>
</head>
<body>
<h1>
    <c:if test="${estudiante.id == 0}">Nuevo</c:if>
    <c:if test="${estudiante.id != 0}">Editar</c:if>
    estudiante
</h1>

<form action="inicio" method="post">
    <input type="hidden" name="id" value="${estudiante.id}" />
    <table>
        <tr>
            <td>Nombre:</td>
            <td><input type="text" name="nombre" value="${estudiante.nombre}"/></td>
        </tr>
        <tr>
            <td>Apellidos:</td>
            <td><input type="text" name="apellidos" value="${estudiante.apellidos}"/></td>
        </tr>
        <tr>
            <td>Seminarios:</td>
            <td><input type="TEXT" name="sseminarios" value="${estudiante.sseminarios}"/></td>
        </tr>
        <tr>
            <td>Confirmado:</td>
            <td><input type="checkbox" name="confirmado" value="true" <c:if test="${estudiante.confirmado}">checked</c:if> /></td>
        </tr>
        <tr>
            <td>Fecha de Inscripción:</td>
            <td><input type="text" name="fecha_inscripcion" value="${estudiante.fechaInscripcion}"/></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Guardar" /></td>
        </tr>
    </table>
</form>
</body>
</html>
