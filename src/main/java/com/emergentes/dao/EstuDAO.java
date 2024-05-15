/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.emergentes.dao;
import com.emergentes.modelo.estu;
import java.util.List;

public interface EstuDAO {
        public void insert(estu estudiante) throws Exception;
    public void update(estu estudiante) throws Exception;
    public void delete(int id) throws Exception;
    public estu getById(int id) throws Exception;
    public List<estu> getAll() throws Exception;
}
