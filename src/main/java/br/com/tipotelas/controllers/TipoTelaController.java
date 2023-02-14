package br.com.tipotelas.controllers;

import br.com.tipotelas.controllers.exceptions.ApiException;
import br.com.tipotelas.dtos.TipoTelaDTO;
import br.com.tipotelas.models.TipoTela;
import br.com.tipotelas.repositories.TipoTelaRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Tag(name="Tipo de Tela")
@AllArgsConstructor
@RestController
@RequestMapping("/api/tipotela")
public class TipoTelaController {

    private final TipoTelaRepository repository;

    @GetMapping("/v1/{id}")
    @Operation(summary = "Consultar Tipo de Tela por id")
    @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso")
    @ApiResponse(responseCode = "404", description = "Tipo de tela não encotrada",
    content = @Content(schema = @Schema(defaultValue = "")))
    public ResponseEntity<TipoTelaDTO> buscarPorId(@PathVariable String id) {

        Optional<TipoTela> opttipoTela = this.repository.findById(id);

        if(opttipoTela.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        TipoTela tipoTela = opttipoTela.get();
        TipoTelaDTO tipoTelaDTO = TipoTelaDTO.builder()
                .tipo(tipoTela.getTipo())
                .titulo(tipoTela.getTitulo())
                .itens(tipoTela.getItens())
                .botaoOK(tipoTela.getBotaoOK())
                .botaoCancelar(tipoTela.getBotaoCancelar()).build();

        return ResponseEntity.ok(tipoTelaDTO);
    }

    @GetMapping("/v1/tipo")
    @Operation(summary = "Consultar Tipo de Tela pelo tipo")
    @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso")
    @ApiResponse(responseCode = "404", description = "Tipo de tela não encotrada",
    content = @Content(schema = @Schema(defaultValue = "")))
    public ResponseEntity<TipoTelaDTO> buscarPorTipoDeTela(@RequestParam String tipo) {

        Optional<TipoTela> optTipoTela = this.repository.findByTipo(tipo);

        if(optTipoTela.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        TipoTela tipoTela = optTipoTela.get();
        TipoTelaDTO tipoTelaDTO = TipoTelaDTO.builder()
                .tipo(tipoTela.getTipo())
                .titulo(tipoTela.getTitulo())
                .itens(tipoTela.getItens())
                .botaoOK(tipoTela.getBotaoOK())
                .botaoCancelar(tipoTela.getBotaoCancelar()).build();

        return ResponseEntity.ok(tipoTelaDTO);
    }

    @PostMapping("/v1/cadastrar")
    @Operation(summary = "Cadastrar Tipo de Tela")
    @ApiResponse(responseCode = "201", description = "Cadastro realizado com sucesso",
    content = @Content(schema = @Schema(implementation = TipoTelaDTO.class)))
    @ApiResponse(responseCode = "400", description = "Requisição inválida",
    content = @Content(schema = @Schema(implementation = ApiException.class)))
    public ResponseEntity<TipoTelaDTO> cadastrarTipoDeTela(@RequestBody @Valid TipoTelaDTO tpTelaDTO) {

        TipoTelaDTO tipoTelaDTO = TipoTelaDTO.builder()
                .tipo(tpTelaDTO.getTipo())
                .titulo(tpTelaDTO.getTitulo())
                .itens(tpTelaDTO.getItens())
                .botaoOK(tpTelaDTO.getBotaoOK())
                .botaoCancelar(tpTelaDTO.getBotaoCancelar()).build();

        TipoTela tipoTela = new TipoTela();
        BeanUtils.copyProperties(tipoTelaDTO, tipoTela);

        this.repository.save(tipoTela);
        return ResponseEntity.status(HttpStatus.CREATED).body(tipoTelaDTO);
    }


    @DeleteMapping("/v1/excluir/{id}")
    @Operation(summary = "Exclusão do Tipo de Tela por id")
    @ApiResponse(responseCode = "204", description = "Exclusão realizada com sucesso",
    content = @Content(schema = @Schema(defaultValue = "Tipo de tela excluído com sucesso.")))
    @ApiResponse(responseCode = "404", description = "Tipo de tela não encotrada",
    content = @Content(schema = @Schema(defaultValue = "Não será possível excluir tipo de tela, pois não existe.")))
    public ResponseEntity<String> excluirPorId(@PathVariable String id) {

        Optional<TipoTela> opttipoTela = this.repository.findById(id);

        if(opttipoTela.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não será possível excluir tipo de tela, pois não existe.");
        }
        this.repository.deleteById(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Tipo de tela excluído com sucesso.");
    }


    @PutMapping("/v1/atualizar")
    @Operation(summary = "Cadastrar Tipo de Tela")
    @ApiResponse(responseCode = "201", description = "Cadastro realizado com sucesso",
    content = @Content(schema = @Schema(implementation = TipoTelaDTO.class)))
    @ApiResponse(responseCode = "404", description = "Requisição inválida",
    content = @Content(schema = @Schema(defaultValue = "Não será possível atualizar o tipo de tela, pois não existe.")))
    @ApiResponse(responseCode = "400", description = "Requisição inválida",
    content = @Content(schema = @Schema(implementation = ApiException.class)))
    public ResponseEntity<?> atualizar(@RequestBody @Valid TipoTelaDTO tpTelaDTO) {

        Optional<TipoTela> optTipoTela = this.repository.findByTipo(tpTelaDTO.getTipo());

        if(optTipoTela.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não será possível atualizar o tipo de tela, pois não existe.");
        }

        TipoTela tipoTela = optTipoTela.get();
        tipoTela.setTitulo(tpTelaDTO.getTitulo() != null ? tpTelaDTO.getTitulo() : tipoTela.getTitulo());
        tipoTela.setTipo(tpTelaDTO.getTipo() != null ? tpTelaDTO.getTipo() : tipoTela.getTipo());
        tipoTela.setItens(tpTelaDTO.getItens() != null ? tpTelaDTO.getItens() : tipoTela.getItens());
        tipoTela.setBotaoOK(tpTelaDTO.getBotaoOK() != null ? tpTelaDTO.getBotaoOK() :  tipoTela.getBotaoOK());
        tipoTela.setBotaoCancelar(tpTelaDTO.getBotaoCancelar() != null ? tpTelaDTO.getBotaoCancelar() : tipoTela.getBotaoCancelar());

        this.repository.save(tipoTela);

        return ResponseEntity.status(HttpStatus.CREATED).body(tipoTela);
    }

}
