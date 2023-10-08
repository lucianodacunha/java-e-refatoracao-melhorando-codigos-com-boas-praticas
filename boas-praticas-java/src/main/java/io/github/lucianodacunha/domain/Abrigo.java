package io.github.lucianodacunha.domain;

import lombok.*;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode
public class Abrigo {
    @Setter(AccessLevel.PUBLIC)
    private Long id;
    @NonNull
    private String nome;
    @NonNull
    private String telefone;
    @NonNull
    private String email;
    private List<Pet> pets;

    public String toString(){
        return """
               "id":%s,"nome":"%s","telefone":"%s","email":"%s"
               """.formatted(this.id, this.nome, this.telefone, this.email);
    }
}