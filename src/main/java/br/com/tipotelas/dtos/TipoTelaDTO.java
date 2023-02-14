package br.com.tipotelas.dtos;

import br.com.tipotelas.models.Botao;
import br.com.tipotelas.models.Itens;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.List;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TipoTelaDTO {

    @NotBlank(message = "Tipo não pode ser nulo ou vazio")
    private String tipo;
    @NotBlank(message = "Titulo não pode ser nulo ou vazio")
    private String titulo;

    private List<Itens> itens;
    private Botao botaoOK;
    private Botao botaoCancelar;
}
