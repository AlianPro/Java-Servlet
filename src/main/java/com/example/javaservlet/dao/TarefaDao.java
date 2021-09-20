package com.example.javaservlet.dao;

import com.example.javaservlet.conn.ConexaoFactory;
import com.example.javaservlet.util.DateUtil;
import com.example.javaservlet.model.Tarefa;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TarefaDao {
    public static void addTask(Tarefa tarefa){
        String sql = "INSERT INTO `prova_remsoft`.`tarefa` (`descricao`, `dt_criacao`) VALUES (?, ?)";
        Connection conn = ConexaoFactory.getConexao();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, tarefa.getDescricao());
            ps.setString(2,DateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
            ps.executeUpdate();
            ConexaoFactory.close(conn,ps);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void deleteTask(int idTask){
        String sql = "UPDATE `prova_remsoft`.`tarefa` SET `excluido` = '1' WHERE (`id` = ?)";
        Connection conn = ConexaoFactory.getConexao();
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idTask);
            ps.executeUpdate();
            ConexaoFactory.close(conn,ps);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void updateTask(Tarefa tarefa){
        String sql = "UPDATE `prova_remsoft`.`tarefa` SET `descricao` = ?, `dt_ult_alt` = ? WHERE (`id` = ?)";
        Connection conn = ConexaoFactory.getConexao();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,tarefa.getDescricao());
            ps.setString(2,DateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
            ps.setInt(3,tarefa.getId());
            ps.executeUpdate();
            ConexaoFactory.close(conn,ps);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void finishTask(int idTask){
        String sql = "UPDATE `prova_remsoft`.`tarefa` SET `finalizado` = '1', `dt_finalizado` = ? WHERE (`id` = ?)";
        Connection conn = ConexaoFactory.getConexao();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,DateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
            ps.setInt(2,idTask);
            ps.executeUpdate();
            ConexaoFactory.close(conn,ps);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static List<Tarefa> getAllTasks(){
        String sql = "SELECT id,descricao,dt_finalizado,dt_criacao,dt_ult_alt FROM tarefa where excluido <> 1";
        Connection conn = ConexaoFactory.getConexao();
        List<Tarefa> tarefaList = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                tarefaList.add(new Tarefa(rs.getInt("id"),rs.getString("descricao"),rs.getString("dt_finalizado"),rs.getString("dt_criacao"),rs.getString("dt_ult_alt")));
            }
            ConexaoFactory.close(conn,ps,rs);
            return tarefaList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static Tarefa getTaskById(int idTask){
        Tarefa tarefa = new Tarefa();
        String sql = "select * from tarefa where id= ?";
        Connection conn = ConexaoFactory.getConexao();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,idTask);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                tarefa.setId(rs.getInt("id"));
                tarefa.setDescricao(rs.getString("descricao"));
                tarefa.setFinalizado(rs.getByte("finalizado"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tarefa;
    }
}
