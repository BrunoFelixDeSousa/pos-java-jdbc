package br.com.jdev.dao;

import br.com.jdev.conexaojdbc.SingleConnection;
import br.com.jdev.model.BeanUSerFone;
import br.com.jdev.model.Telefone;
import br.com.jdev.model.Userposjava;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserPosDAO {

    private final Connection connection;

    public UserPosDAO() {
        connection = SingleConnection.getConnection();
    }

    public void salvar(Userposjava userposjava) {
        try {
            String sql = "insert into userposjava (nome, email) values (?,?)";
            PreparedStatement insert = connection.prepareStatement(sql);
            insert.setString(1, userposjava.getNome());
            insert.setString(2, userposjava.getEmail());
            insert.execute();
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        }
    }

    public List<Userposjava> listarUsuarios() throws SQLException {
        List<Userposjava> lista = new ArrayList<>();
        String sql = "select * from userposjava";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultado = preparedStatement.executeQuery();

        while(resultado.next()) {
            Userposjava userposjava = new Userposjava();
            userposjava.setId(resultado.getLong("id"));
            userposjava.setNome(resultado.getString("nome"));
            userposjava.setEmail(resultado.getString("email"));

            lista.add(userposjava);
        }
            return lista;
    }

    public Userposjava buscar( Long id ) throws Exception {
        Userposjava usuario = new Userposjava();
        String sql = "select * from userposjava where id = " + id;
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultado = preparedStatement.executeQuery();

        while(resultado.next()) {
            usuario.setId(resultado.getLong("id"));
            usuario.setNome(resultado.getString("nome"));
            usuario.setEmail(resultado.getString("email"));
        }
        return usuario;
    }

    public void atualizar(Userposjava userposjava) {
        String sql = "update userposjava set email = ? where id = " + userposjava.getId();

        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, userposjava.getEmail());

            preparedStatement.execute();
            connection.commit();
        } catch (SQLException e) {
            // TODO Auto-generated catch block

            try {
                connection.rollback();
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
    }

    public void deletar( Long id ) {

        try {
            String sql = "delete from userposjava where id = " + id;
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.execute();
            connection.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void salvarTelefone(Telefone telefone ) {

        try {

            String sql = "INSERT INTO public.telefoneuser(numero, tipo, usuariopessoa) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, telefone.getNumero());
            statement.setString(2, telefone.getTipo());
            statement.setLong(3, telefone.getUsuario());
            statement.execute();
            connection.commit();

        } catch (Exception e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            System.out.println(e.getMessage());
        }
    }

    public List<BeanUSerFone> listaUserFone( Long id) {

        return null;
    }


}