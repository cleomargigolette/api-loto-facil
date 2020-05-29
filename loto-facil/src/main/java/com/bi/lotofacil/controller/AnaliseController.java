package com.bi.lotofacil.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/loto-facil")
public class AnaliseController {

    @GetMapping
    public List<List<Long>> sorteios() {
        return null;
    }

    @GetMapping("tendencia/{bola}")
    public Long tendenciaBol(@PathVariable("bola") Long bol) {
        return null;
    }

    @GetMapping("/{bola}")
    public Long vezesQueSaiuNosSorteios(@PathVariable("bola") Long bol) {
        return null;
    }
}
