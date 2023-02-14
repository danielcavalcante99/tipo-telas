package br.com.tipotelas.models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Botao implements Serializable {

    private static final long serialVersionUID = -407407085921759593L;

    private String texto;
    private String url;
    private Body body;

}
