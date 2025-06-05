package com.example.menubackend.controller;

import com.example.menubackend.model.Produto;
import com.example.menubackend.repository.ProdutoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
@CrossOrigin(origins = "*")
public class ProdutoController {

    private final ProdutoRepository produtoRepository;

    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @GetMapping
    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Produto findById(@PathVariable long id) {
        return produtoRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Produto save(@RequestBody Produto produto) {
        return produtoRepository.save(produto);
    }

    @PutMapping("/{id}")
    public Produto update(@RequestBody Produto produto, @PathVariable Long id) {
        Produto produtoAux = produtoRepository.findById(id).orElse(null);

        produtoAux.setNome(produto.getNome());
        produtoAux.setDescricao(produto.getDescricao());
        produtoAux.setPreco(produto.getPreco());
        return produtoRepository.save(produtoAux);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        produtoRepository.deleteById(id);
    }

}
