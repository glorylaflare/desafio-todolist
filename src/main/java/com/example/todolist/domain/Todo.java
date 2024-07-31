package com.example.todolist.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "todos")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private boolean realizado;
    private int prioridade;
}
