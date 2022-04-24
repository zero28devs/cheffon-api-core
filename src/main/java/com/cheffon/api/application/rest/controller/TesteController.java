package com.cheffon.api.application.rest.controller;

import com.cheffon.api.infra.db.jpa.TesteDataRepositorio;
import com.cheffon.api.infra.db.orm.TesteData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teste")
public class TesteController {
    private final TesteDataRepositorio testeDataRepositorio;

    @Autowired
    public TesteController(TesteDataRepositorio testeDataRepositorio) {
        this.testeDataRepositorio = testeDataRepositorio;
    }

    @GetMapping
    public Page<TesteData> listar() {
        return testeDataRepositorio.findAll( Pageable.unpaged());
    }

    @PostMapping
    public ResponseEntity<TesteData> inserir() {
        var testeData = new TesteData();
        testeData.setNome("TesteHml");

        testeDataRepositorio.save(testeData);

        return ResponseEntity.ok(testeData);
    }
}
