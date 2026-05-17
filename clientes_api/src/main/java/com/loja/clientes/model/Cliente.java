package com.loja.clientes.model;

/**
 * ============================================================
 *  CAMADA MODEL — Cliente
 * ============================================================
 *
 * Representa um cliente da loja.
 * Esta classe é um POJO (Plain Old Java Object) simples, sem
 * nenhuma anotação de banco de dados, pois nosso "banco" é
 * uma lista em memória mantida pelo ClienteService.
 *
 * Atributos:
 *   - id    → identificador único, gerado automaticamente pelo service
 *   - nome  → nome completo do cliente
 *   - email → endereço de e-mail
 *   - idade → idade em anos
 */
public class Cliente {

    // ─── Atributos ────────────────────────────────────────────
    private Long   id;
    private String nome;
    private String email;
    private int    idade;

    // ─── Construtor padrão (obrigatório para o Jackson deserializar o JSON) ──
    public Cliente() {
    }

    // ─── Construtor com todos os parâmetros ───────────────────
    public Cliente(Long id, String nome, String email, int idade) {
        this.id    = id;
        this.nome  = nome;
        this.email = email;
        this.idade = idade;
    }

    // ─── Getters e Setters ────────────────────────────────────

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    // ─── toString (útil para debug nos logs) ──────────────────
    @Override
    public String toString() {
        return "Cliente{" +
               "id="    + id    +
               ", nome='"  + nome  + '\'' +
               ", email='" + email + '\'' +
               ", idade="  + idade +
               '}';
    }
}
