package com.prueba.pruebamary.vista;

import com.prueba.pruebamary.dto.Marylu;
import com.prueba.pruebamary.service.MaryluService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/marylu")
public class VistaControlador {

    private MaryluService oMaryluService;

    @Autowired
    public VistaControlador(MaryluService oMaryluService) {
        this.oMaryluService = oMaryluService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Marylu>> obtenerPorId(@PathVariable int id){
        return new ResponseEntity<>(oMaryluService.obtenerPorId(id), HttpStatus.OK) ;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Marylu>> listar(){
        return new ResponseEntity<>(oMaryluService.listarTodo(), HttpStatus.OK) ;
    }

    @PostMapping("/guardar")
    public ResponseEntity<Marylu> guardar(@RequestBody Marylu oMarylu){
        return new ResponseEntity<>(oMaryluService.guardar(oMarylu),HttpStatus.OK);
    }

    @PutMapping(value = "/editar",consumes= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity editar(@RequestBody Marylu oMarylu){
        oMaryluService.editar(oMarylu);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity eliminar(@PathVariable int id){
        oMaryluService.eliminar(id);
        return new ResponseEntity(HttpStatus.OK);
    }


}
