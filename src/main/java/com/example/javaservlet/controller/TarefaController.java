package com.example.javaservlet.controller;

import com.example.javaservlet.dao.TarefaDao;
import com.example.javaservlet.model.Tarefa;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "TarefaController", value = "/TarefaController")
public class TarefaController extends HttpServlet {
    private static String INSERT_OR_EDIT = "/task.jsp";
    private static String LIST_TASK = "/listTask.jsp";

    public TarefaController(){
        super();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter("action");
        if (action.equalsIgnoreCase("delete")){
            int idTask = Integer.parseInt(request.getParameter("id"));
            TarefaDao.deleteTask(idTask);
            forward = LIST_TASK;
            request.setAttribute("tasks", TarefaDao.getAllTasks());
        }else if (action.equalsIgnoreCase("finalizado")){
            int idTask = Integer.parseInt(request.getParameter("id"));
            Tarefa tarefa = TarefaDao.getTaskById(idTask);
            if (tarefa.getFinalizado()==0)
            TarefaDao.finishTask(idTask);
            forward = LIST_TASK;
            request.setAttribute("tasks",TarefaDao.getAllTasks());
        }else if (action.equalsIgnoreCase("edit")){
            forward = INSERT_OR_EDIT;
            int idTask = Integer.parseInt(request.getParameter("id"));
            Tarefa tarefa = TarefaDao.getTaskById(idTask);
            request.setAttribute("task",tarefa);
        }else if (action.equalsIgnoreCase("listTask")){
            forward = LIST_TASK;
            request.setAttribute("tasks",TarefaDao.getAllTasks());
        }
        else {
            forward = INSERT_OR_EDIT;
        }
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Tarefa tarefa = new Tarefa();
        String idTask = request.getParameter("id");
        if ((idTask == null || idTask.isEmpty())){
            tarefa.setDescricao(request.getParameter("descricao"));
            if (!tarefa.getDescricao().trim().isEmpty())
            TarefaDao.addTask(tarefa);
        }
        else{
            tarefa.setId(Integer.parseInt(idTask));
            String descricaoAnterior = TarefaDao.getTaskById(tarefa.getId()).getDescricao();
            tarefa.setDescricao(request.getParameter("descricao"));
            if (!tarefa.getDescricao().trim().isEmpty() && !(descricaoAnterior.equals(tarefa.getDescricao())))
            TarefaDao.updateTask(tarefa);
        }
        RequestDispatcher view = request.getRequestDispatcher(LIST_TASK);
        request.setAttribute("tasks",TarefaDao.getAllTasks());
        view.forward(request,response);
    }
}
