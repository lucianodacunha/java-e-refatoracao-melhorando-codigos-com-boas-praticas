package io.github.lucianodacunha.domain;

import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode
public class Pet{
    private Long id;
    @NonNull
    private String tipo;
    @NonNull
    private String nome;
    @NonNull
    private String raca;
    @NonNull
    private Integer idade;
    @NonNull
    private String cor;
    @NonNull
    private Float peso;
}