package br.com.tipotelas.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("tipotelas")
public class TipoTela implements Serializable {

    private static final long serialVersionUID = -3974117086812844503L;

    @Id
    private String registro;
    private String tipo;
    private String titulo;

    private List<Itens> itens;
    private Botao botaoOK;
    private Botao botaoCancelar;
}
