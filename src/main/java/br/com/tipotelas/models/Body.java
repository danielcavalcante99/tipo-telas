package br.com.tipotelas.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Body implements Serializable {
    private static final long serialVersionUID = -2416751011793766329L;

    @JsonProperty("campo1")
    private String campoUm;
    @JsonProperty("campo2")
    private String campoDois;
    private String idCampoTexto;
    private Long idCampoNumerico;
    private String idCampoData;
}
