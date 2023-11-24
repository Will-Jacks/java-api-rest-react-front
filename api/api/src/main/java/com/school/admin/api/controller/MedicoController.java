package com.school.admin.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school.admin.api.entities.MedicoEntity;
import com.school.admin.api.repository.MedicoRepository;

@RestController
@RequestMapping("/medicos")
@CrossOrigin(origins = "htt´://localhost:5173")
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

    @GetMapping("/{id}")
    public ResponseEntity<MedicoEntity> consultarMedicoPorId(@PathVariable Integer id) {
        
        return medicoRepository.findById(id)
               .map(medico -> ResponseEntity.ok().body(medico))
               .orElse(ResponseEntity.notFound().build()); 
    }

    @PostMapping("/cadastrar")
    //Request body para dizer pra o SpringBoot que é pra retornar o corpo da requisição
    public ResponseEntity<String> cadastrar(@RequestBody MedicoEntity cadastroMedico) {
        medicoRepository.save(cadastroMedico);

        return ResponseEntity.status(HttpStatus.CREATED).body("Cadastro feito com sucesso!");
    }
}
