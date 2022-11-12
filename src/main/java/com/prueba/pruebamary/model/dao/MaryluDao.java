package com.prueba.pruebamary.model.dao;

import com.prueba.pruebamary.dto.Marylu;
import java.util.List;
import java.util.Optional;

public interface MaryluDao {

    Optional<Marylu> obtenerPorId(Integer idEmpleado);

    List<Marylu> listarTodo();

    Marylu guardar(Marylu marylu);

    void editar(Marylu marylu);

    void eliminar(Integer idEmpleado);
}
