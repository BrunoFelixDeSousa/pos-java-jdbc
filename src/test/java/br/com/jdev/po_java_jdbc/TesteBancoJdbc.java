package br.com.jdev.po_java_jdbc;

import br.com.jdev.dao.UserPosDAO;
import br.com.jdev.model.Userposjava;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class TesteBancoJdbc {
    @Test
    public void initBanco() {
        UserPosDAO userPosDAO = new UserPosDAO();
        Userposjava userposjava = new Userposjava();

        userposjava.setNome("sousa");
        userposjava.setEmail("sousa@gmail.com");

        userPosDAO.salvar(userposjava);
    }

    @Test
    public void initListar() {
        UserPosDAO dao = new UserPosDAO();
        try {
            List<Userposjava> resultadoLista = dao.listarUsuarios();

            for (Userposjava userposjava : resultadoLista) {
                System.out.println(userposjava.getId() + " | " + userposjava.getNome() + " | " + userposjava.getEmail());
                System.out.println("--------------------------------");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test
    public void initDeletar() {
        try {
            UserPosDAO dao = new UserPosDAO();
            dao.deletar(6L);
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void initBuscar() {
        UserPosDAO dao = new UserPosDAO();

        try {
            Userposjava userposjava = dao.buscar(6L);
            System.out.println(userposjava);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test
    public void initAtualizar() {

        try {
            UserPosDAO dao = new UserPosDAO();
            Userposjava userposjava = dao.buscar(5L);

            // userposjava.setNome("Kakaroto");
            userposjava.setEmail("Kakaroto@hotmail.com");
            dao.atualizar(userposjava);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }
}