package br.com.mili.milibackend.fornecedor.adapter.web;

import br.com.mili.milibackend.fornecedor.application.dto.gfdDocumento.GfdDocumentoDownloadInputDto;
import br.com.mili.milibackend.fornecedor.application.dto.gfdDocumento.GfdDocumentoDownloadOutputDto;
import br.com.mili.milibackend.fornecedor.application.dto.gfdDocumento.GfdDocumentoUpdateInputDto;
import br.com.mili.milibackend.fornecedor.application.dto.gfdDocumento.GfdDocumentoUpdateOutputDto;
import br.com.mili.milibackend.gfd.domain.interfaces.IGfdDocumentoService;
import br.com.mili.milibackend.shared.infra.security.model.CustomUserPrincipal;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(GfdDocumentoController.ENDPOINT)
public class GfdDocumentoController {
    protected static final String ENDPOINT = "/mili-backend/v1/fornecedor-documentos";

    private final IGfdDocumentoService gfdDocumentoService;

    public GfdDocumentoController(IGfdDocumentoService gfdDocumentoService) {
        this.gfdDocumentoService = gfdDocumentoService;
    }


    @PutMapping
    public ResponseEntity<GfdDocumentoUpdateOutputDto> update(
            @RequestBody @Valid GfdDocumentoUpdateInputDto inputDto,
            @AuthenticationPrincipal CustomUserPrincipal user
    ) {
        log.info("{} {}/{}", RequestMethod.GET, ENDPOINT, user.getUsername());


        return ResponseEntity.ok(gfdDocumentoService.update(inputDto));
    }

    @GetMapping("{id}/download")
    public ResponseEntity<GfdDocumentoDownloadOutputDto> download(
            @PathVariable Integer id,
            @AuthenticationPrincipal CustomUserPrincipal user
    ) {
        log.info("{} {}/{}", RequestMethod.GET, ENDPOINT, user.getUsername());

        var inputDto = new GfdDocumentoDownloadInputDto(id);
        return ResponseEntity.ok(gfdDocumentoService.download(inputDto));
    }
}
