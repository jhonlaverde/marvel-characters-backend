package com.example.api.rest.controller;

import com.example.api.model.ResultDto;
import com.example.api.ports.api.CharacterServicePort;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/heroes")
public class BookController {
    @Autowired
    private CharacterServicePort characterServicePort;

    @GetMapping("/{id}")
    public ResponseEntity<ResultDto> getHeroByID(@PathVariable String id, HttpServletRequest request) {
        return ResponseEntity.ok(characterServicePort.getHeroById(id, request.getRequestURI()));
    }

    @GetMapping
    public ResponseEntity<List<ResultDto>> getHeroes(HttpServletRequest request){
        return ResponseEntity.ok(characterServicePort.getHeroes(request.getRequestURI()));
    }

}
