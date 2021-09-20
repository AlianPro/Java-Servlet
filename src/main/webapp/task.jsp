<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
    <title>Adicionar Task</title>
</head>
<body>
<form method="POST" action='TarefaController' name="frmAddTask">
    ID : <input type="text" readonly="readonly" name="id"
                     value="<c:out value="${task.id}" />" /> <br />
    Descricao : <input type="text" placeholder="Max 255" name="descricao"
        value="<c:out value="${task.descricao}" />" /> <br />
     <input type="submit" value="Enviar" />
     <input type="button" value="Voltar" onclick="window.location.href = './index.jsp'"/>
</form>
</body>
</html>