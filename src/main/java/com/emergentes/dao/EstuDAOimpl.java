/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.emergentes.dao;

import com.emergentes.modelo.estu;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EstuDAOimpl extends ConexionDB implements EstuDAO {
    @Override
    public void insert(estu estudiante) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("INSERT into estudiantes (nombre, apellidos, sseminarios, confirmado, fecha_inscripcion) values (?, ?, ?, ?, ?)");
            ps.setString(1, estudiante.getNombre());
            ps.setString(2, estudiante.getApellidos());
            ps.setInt(3, estudiante.getSseminarios());
            ps.setBoolean(4, estudiante.isConfirmado());
            ps.setString(5, estudiante.getFechaInscripcion());
            ps.executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(estu estudiante) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("UPDATE estudiantes set nombre = ?, apellidos = ?, sseminarios = ?, confirmado = ?, fecha_inscripcion = ? where id = ?");
            ps.setString(1, estudiante.getNombre());
            ps.setString(2, estudiante.getApellidos());
            ps.setInt(3, estudiante.getSseminarios());
            ps.setBoolean(4, estudiante.isConfirmado());
            ps.setString(5, estudiante.getFechaInscripcion());
            ps.setInt(6, estudiante.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(int id) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("DELETE FROM estudiantes WHERE id=?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public estu getById(int id) throws Exception {
        estu est = new estu();
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM estudiantes WHERE id = ? limit 1");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                est.setId(rs.getInt("id"));
                est.setNombre(rs.getString("nombre"));
                est.setApellidos(rs.getString("apellidos"));
                est.setSseminarios(rs.getInt("sseminarios"));
                est.setConfirmado(rs.getBoolean("confirmado"));
                est.setFechaInscripcion(rs.getString("fecha_inscripcion"));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return est;
    }

    @Override
    public List<estu> getAll() throws Exception {
        List<estu> lista = null;
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM estudiantes");
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<estu>();
            while (rs.next()) {
                estu est = new estu();
                est.setId(rs.getInt("id"));
                est.setNombre(rs.getString("nombre"));
                est.setApellidos(rs.getString("apellidos"));
                est.setSseminarios(rs.getInt("sseminarios"));
                est.setConfirmado(rs.getBoolean("confirmado"));
                est.setFechaInscripcion(rs.getString("fecha_inscripcion"));
                lista.add(est);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return lista;
    }
}
