package com.loja.clientes.service;

import com.loja.clientes.model.Cliente;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * ============================================================
 *  CAMADA SERVICE — ClienteService
 * ============================================================
 *
 * Contém toda a LÓGICA DE NEGÓCIO da aplicação.
 * Simula um banco de dados usando uma List<Cliente> em memória.
 *
 * @Service → indica ao Spring que esta classe é um componente
 * de serviço e deve ser gerenciada como um bean (singleton).
 * Com isso, podemos injetá-la em outros componentes com @Autowired.
 */
@Service
public class ClienteService {

    // ─── "Banco de dados" em memória ──────────────────────────
    private final List<Cliente> clientes = new ArrayList<>();

    /**
     * Contador usado para gerar IDs únicos e crescentes.
     * Começa em 1 e é incrementado a cada novo cliente criado.
     */
    private Long nextId = 1L;

    // ──────────────────────────────────────────────────────────
    //  LISTAR → retorna todos os clientes cadastrados
    // ──────────────────────────────────────────────────────────
    public List<Cliente> listar() {
        return clientes;
    }

    // ──────────────────────────────────────────────────────────
    //  CRIAR → gera o ID, adiciona na lista e retorna o cliente
    // ──────────────────────────────────────────────────────────
    public Cliente criar(Cliente c) {
        c.setId(nextId++);      // atribui o próximo ID disponível
        clientes.add(c);        // salva na lista (nosso "banco")
        return c;               // retorna o cliente já com o ID gerado
    }

    // ──────────────────────────────────────────────────────────
    //  BUSCAR POR ID → percorre a lista e retorna o cliente
    //                  correspondente, ou null se não encontrar
    // ──────────────────────────────────────────────────────────
    public Cliente buscarPorId(Long id) {
        /*
         * Usamos stream() + filter() do Java 8+:
         *   1. stream()        → transforma a lista em um fluxo de elementos
         *   2. filter(...)     → mantém só o elemento cujo id seja igual ao buscado
         *   3. findFirst()     → pega o primeiro resultado (retorna um Optional)
         *   4. orElse(null)    → se não encontrar nada, retorna null
         */
        return clientes.stream()
                       .filter(c -> c.getId().equals(id))
                       .findFirst()
                       .orElse(null);
    }

    // ──────────────────────────────────────────────────────────
    //  REMOVER → remove o cliente pelo ID e informa o sucesso
    // ──────────────────────────────────────────────────────────
    public boolean remover(Long id) {
        /*
         * removeIf() remove todos os elementos que satisfazem
         * o predicado (condição). Retorna true se algum elemento
         * foi removido, false caso contrário.
         *
         * É equivalente ao for tradicional abaixo, porém mais
         * conciso e idiomático em Java moderno:
         *
         *   for (Cliente c : clientes) {
         *       if (c.getId().equals(id)) {
         *           clientes.remove(c);
         *           return true;
         *       }
         *   }
         *   return false;
         */
        return clientes.removeIf(c -> c.getId().equals(id));
    }

    // ──────────────────────────────────────────────────────────
    //  ATUALIZAR → localiza pelo ID e substitui nome/email/idade
    // ──────────────────────────────────────────────────────────
    public Cliente atualizar(Long id, Cliente novo) {
        // Primeiro buscamos o cliente existente na lista
        Cliente existente = buscarPorId(id);

        if (existente == null) {
            return null;    // sinaliza ao controller que não foi encontrado
        }

        // Atualiza apenas os campos de dados (o ID permanece o mesmo!)
        existente.setNome(novo.getNome());
        existente.setEmail(novo.getEmail());
        existente.setIdade(novo.getIdade());

        return existente;   // retorna o cliente com os dados atualizados
    }
}
