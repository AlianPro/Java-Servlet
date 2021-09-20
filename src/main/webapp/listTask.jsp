<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <script>
            function confirma(id){
                if (window.confirm("Tem certeza que deseja excluir?")) {
                    location.href = "TarefaController?action=delete&id=" + id;
                }
            }
    </script>
    <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
    <title>Daily Task</title>
</head>
<body>
<table id="tableGrip" border=1>
    <thead>
    <tr>
        <th>Id</th>
        <th>Descricao</th>
        <th>Data_Finalizado</th>
        <th>Data_Criacao</th>
        <th>Data_Ultima_Alteracao</th>
        <th colspan=3>Acao</th>

    </tr>
    </thead>
    <tbody>
    <c:forEach items="${tasks}" var="task">
        <tr>
            <td><c:out value="${task.id}" /></td>
            <td><c:out value="${task.descricao}" /></td>
            <td><c:out value="${task.dt_finalizado}" /></td>
            <td><c:out value="${task.dt_criacao}" /></td>
            <td><c:out value="${task.dt_ult_alt}" /></td>
            <div class="divAcao">
            <td><input id="finalizadoButton" type="button" value="Feita" onclick="window.location.href = 'TarefaController?action=finalizado&id=<c:out value="${task.id}"/>'"></td>
            <td><input id="alterarButton" type="button" value="Alterar" onclick="window.location.href = 'TarefaController?action=edit&id=<c:out value="${task.id}"/>'"></td>
            <td><input id="excluirButton" type="button" value="Excluir" onclick="window.location.href = 'javascript:confirma(<c:out value="${task.id}"/>)'"></input></td>
            </div>
        </tr>
    </c:forEach>
    </tbody>
</table>
<p></p>
<input type="button" value="Add Task" onclick="window.location.href = 'TarefaController?action=insert'"/>
</body>
</html>