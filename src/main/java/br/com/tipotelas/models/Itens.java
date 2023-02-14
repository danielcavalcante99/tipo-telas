package br.com.tipotelas.models;

import br.com.tipotelas.models.enums.TipoInput;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Itens implements Serializable {


    private static final long serialVersionUID = -5383257186831951244L;


    private TipoInput tipo;
    private String id;
    private String titulo;
    private String valor;


}
