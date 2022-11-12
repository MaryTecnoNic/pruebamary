package com.prueba.pruebamary.model.daoImpl;

import com.prueba.pruebamary.dto.Marylu;
import com.prueba.pruebamary.model.dao.MaryluDao;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class MaryluDaoImpl implements MaryluDao {


    JdbcTemplate oJdbcTemplate;

    private SimpleJdbcInsert oSimpleJdbcInsert;

    public MaryluDaoImpl(JdbcTemplate oJdbcTemplate) {
        this.oJdbcTemplate = oJdbcTemplate;
    }

    @Override
    public Optional<Marylu> obtenerPorId(Integer idEmpleado) {
        return oJdbcTemplate.query("Select * from dbo.marylu where idempleado = ? ", BeanPropertyRowMapper.newInstance(Marylu.class),idEmpleado).stream().findFirst();
//        return oJdbcTemplate.query("Select * from dbo.marylu where idempleado = ? ", new RowMapper<Marylu>,idEmpleado).stream().findFirst();
    }

    @Override
    public List<Marylu> listarTodo() {
//        return jdbcTemplate.query("Select * from dbo.marylu", BeanPropertyRowMapper.newInstance(Marylu.class));
        return oJdbcTemplate.query("Select * from dbo.marylu", BeanPropertyRowMapper.newInstance(Marylu.class));

    }
    @Override
    public Marylu guardar(Marylu oMarylu) {
        this.oSimpleJdbcInsert = new SimpleJdbcInsert(oJdbcTemplate.getDataSource()).withTableName("marylu").usingGeneratedKeyColumns("idempleado");
        Map<String, Object> params = new HashMap<>();
        params.put("nombre", oMarylu.getNombre());
        params.put("apellido", oMarylu.getApellido());
        params.put("sexo",oMarylu.getSexo());
        Number num = oSimpleJdbcInsert.executeAndReturnKey(params);
        oMarylu.setIdempleado(num.intValue());
        return oMarylu;
    }

    @Override
    public void editar(Marylu oMarylu) {
        this.oJdbcTemplate.update("UPDATE dbo.marylu SET nombre = ?, apellido = ? ,sexo = ? where idempleado = ? ",oMarylu.getNombre(), oMarylu.getApellido(), oMarylu.getSexo(), oMarylu.getIdempleado());
    }

    @Override
    public void eliminar(Integer idEmpleado) {
        this.oJdbcTemplate.update("delete from  dbo.marylu where idempleado = ? ",idEmpleado);
    }
}
