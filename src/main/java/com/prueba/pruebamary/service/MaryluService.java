package com.prueba.pruebamary.service;

import com.prueba.pruebamary.dto.Marylu;
import com.prueba.pruebamary.model.dao.MaryluDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaryluService {
    MaryluDao oMaryluDao;

    @Autowired
    public MaryluService(MaryluDao maryluDao) {
        this.oMaryluDao = maryluDao;
    }

    public Optional<Marylu> obtenerPorId(Integer idEmpleado) {
        return oMaryluDao.obtenerPorId(idEmpleado);
    }

    public List<Marylu> listarTodo() {
        return oMaryluDao.listarTodo();
    }

    public Marylu guardar(Marylu oMarylu) {
        return oMaryluDao.guardar(oMarylu);
    }

    public void editar(Marylu oMarylu) {
        oMaryluDao.editar(oMarylu);
    }

    public void eliminar(Integer idEmpleado) {
        oMaryluDao.eliminar(idEmpleado);
    }
}
