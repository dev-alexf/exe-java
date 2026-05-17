package com.loja.clientes.controller;

import com.loja.clientes.model.Cliente;
import com.loja.clientes.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * ============================================================
 *  CAMADA CONTROLLER — ClienteController
 * ============================================================
 *
 * Responsável por receber as requisições HTTP, delegar o
 * processamento ao Service e devolver as respostas adequadas.
 *
 * @RestController    → combina @Controller + @ResponseBody,
 *                      fazendo com que todos os métodos retornem
 *                      JSON automaticamente (via Jackson).
 *
 * @RequestMapping    → define o prefixo de URL para todos os
 *                      endpoints desta classe: /clientes
 */
@RestController
@RequestMapping("/clientes")
public class ClienteController {

    /**
     * @Autowired injeta automaticamente o bean ClienteService
     * gerenciado pelo Spring — não precisamos instanciar manualmente.
     */
    @Autowired
    private ClienteService clienteService;

    // ──────────────────────────────────────────────────────────
    //  GET /clientes
    //  Lista todos os clientes cadastrados.
    //
    //  Resposta de sucesso: 200 OK + array JSON com os clientes
    // ──────────────────────────────────────────────────────────
    @GetMapping
    public ResponseEntity<List<Cliente>> listarTodos() {
        List<Cliente> lista = clienteService.listar();
        return ResponseEntity.ok(lista);    // 200 OK
    }

    // ──────────────────────────────────────────────────────────
    //  GET /clientes/{id}
    //  Busca um cliente específico pelo ID.
    //
    //  Resposta de sucesso: 200 OK + JSON do cliente
    //  Resposta de erro:    404 Not Found (ID não existe)
    // ──────────────────────────────────────────────────────────
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable Long id) {
        Cliente cliente = clienteService.buscarPorId(id);

        if (cliente == null) {
            // 404 Not Found → ID solicitado não existe na lista
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(cliente);  // 200 OK
    }

    // ──────────────────────────────────────────────────────────
    //  POST /clientes
    //  Cadastra um novo cliente.
    //
    //  Corpo da requisição (JSON):
    //    { "nome": "Maria", "email": "maria@email.com", "idade": 28 }
    //
    //  Resposta de sucesso: 201 Created + JSON do cliente criado
    //                       (já com o ID gerado)
    // ──────────────────────────────────────────────────────────
    @PostMapping
    public ResponseEntity<Cliente> criar(@RequestBody Cliente cliente) {
        /*
         * @RequestBody → o Spring usa o Jackson para desserializar
         * o JSON do corpo da requisição e preenchê-lo no objeto Cliente.
         */
        Cliente criado = clienteService.criar(cliente);

        // 201 Created é o status HTTP correto para recursos recém-criados
        return ResponseEntity.status(201).body(criado);
    }

    // ──────────────────────────────────────────────────────────
    //  PUT /clientes/{id}
    //  Atualiza os dados de um cliente existente.
    //
    //  Corpo da requisição (JSON):
    //    { "nome": "Maria Silva", "email": "nova@email.com", "idade": 29 }
    //
    //  Resposta de sucesso: 200 OK + JSON do cliente atualizado
    //  Resposta de erro:    404 Not Found (ID não existe)
    // ──────────────────────────────────────────────────────────
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizar(
            @PathVariable Long id,
            @RequestBody  Cliente clienteNovo) {

        /*
         * @PathVariable → captura o {id} da URL e o injeta no parâmetro
         * @RequestBody  → desserializa o JSON do corpo da requisição
         */
        Cliente atualizado = clienteService.atualizar(id, clienteNovo);

        if (atualizado == null) {
            return ResponseEntity.notFound().build();   // 404 Not Found
        }

        return ResponseEntity.ok(atualizado);           // 200 OK
    }

    // ──────────────────────────────────────────────────────────
    //  DELETE /clientes/{id}
    //  Remove um cliente pelo ID.
    //
    //  Resposta de sucesso: 204 No Content (removido com sucesso)
    //  Resposta de erro:    404 Not Found (ID não existe)
    // ──────────────────────────────────────────────────────────
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        boolean removido = clienteService.remover(id);

        if (!removido) {
            return ResponseEntity.notFound().build();   // 404 Not Found
        }

        // 204 No Content → operação bem-sucedida, sem corpo de resposta
        return ResponseEntity.noContent().build();
    }
}
