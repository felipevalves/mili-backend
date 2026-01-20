package br.com.mili.milibackend.gfd.adapter.web.controller;


import br.com.mili.milibackend.gfd.application.dto.gfdTipoDocumento.*;
import br.com.mili.milibackend.gfd.application.usecases.GfdTipoDocumento.GfdTipoDocumentoWithRescisaoGetAllInputDto;
import br.com.mili.milibackend.gfd.application.usecases.GfdTipoDocumento.GfdTipoDocumentoWithRescisaoGetAllOutputDto;
import br.com.mili.milibackend.gfd.domain.interfaces.IGfdTipoDocumentoService;
import br.com.mili.milibackend.gfd.domain.usecases.gfdDocumento.GetAllTipoDocumentoUseCase;
import br.com.mili.milibackend.gfd.domain.usecases.GfdTipoDocumento.GetAllTipoDocumentoWithRescisaoUseCase;
import br.com.mili.milibackend.gfd.shared.roles.GfdPermissions;
import br.com.mili.milibackend.shared.infra.security.model.CustomUserPrincipal;
import br.com.mili.milibackend.shared.logoperation.LogOperation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static br.com.mili.milibackend.gfd.shared.roles.GfdPermissions.Geral.*;


@Slf4j
@RestController
@RequestMapping(GfdTipoDocumentoController.ENDPOINT)
@RequiredArgsConstructor
public class GfdTipoDocumentoController {
    protected static final String ENDPOINT = "/mili-backend/v1/gfd/tipo-documentos";

    private final IGfdTipoDocumentoService gfdTipoDocumentoService;
    private final GetAllTipoDocumentoUseCase getAllTipoDocumentoUseCase;
    private final GetAllTipoDocumentoWithRescisaoUseCase getAllTipoDocumentoWithRescisaoUseCase;

    @PreAuthorize("hasAuthority('" + ANALISTA + "') " +
            "or hasAuthority('" + FORNECEDOR + "')" +
            "or hasAuthority('" + PORTARIA + "')" +
            "or hasAuthority('" + FABRICA + "')" +
            "or hasAuthority('" + SESMT + "')"
    )
    @GetMapping()
    @LogOperation
    public ResponseEntity<List<GfdTipoDocumentoGetAllOutputDto>> getAll(
            @AuthenticationPrincipal CustomUserPrincipal user,
            @ParameterObject @ModelAttribute @Valid GfdTipoDocumentoGetAllInputDto inputDto
    ) {
        return ResponseEntity.ok(getAllTipoDocumentoUseCase.execute(inputDto));
    }

    @LogOperation
    @PreAuthorize("hasAuthority('" + ANALISTA + "') " +
            "or hasAuthority('" + FORNECEDOR + "')" +
            "or hasAuthority('" + PORTARIA + "')" +
            "or hasAuthority('" + FABRICA + "')" +
            "or hasAuthority('" + SESMT + "')"
    )
    @GetMapping("/rescisao")
    public ResponseEntity<GfdTipoDocumentoWithRescisaoGetAllOutputDto> getAllWithRescisao(
            @AuthenticationPrincipal CustomUserPrincipal user,
            @ParameterObject @ModelAttribute @Valid GfdTipoDocumentoWithRescisaoGetAllInputDto inputDto
    ) {
        return ResponseEntity.ok(getAllTipoDocumentoWithRescisaoUseCase.execute(inputDto));
    }

    @PreAuthorize("hasAuthority('" + ANALISTA + "') " +
            "or hasAuthority('" + FORNECEDOR + "')" +
            "or hasAuthority('" + PORTARIA + "')" +
            "or hasAuthority('" + FABRICA + "')" +
            "or hasAuthority('" + SESMT + "')"
    )

    @LogOperation
    @GetMapping("{id}")
    public ResponseEntity<GfdTipoDocumentoGetByIdOutputDto> getById(
            @AuthenticationPrincipal CustomUserPrincipal user,
            @PathVariable Integer id
    ) {

        return ResponseEntity.ok(gfdTipoDocumentoService.getById(id));
    }

    @LogOperation
    @PreAuthorize("hasAuthority('" + ANALISTA + "')")
    @DeleteMapping("{id}")
    public ResponseEntity<Void> inactive(
            @AuthenticationPrincipal CustomUserPrincipal user,
            @PathVariable Integer id
    ) {
        gfdTipoDocumentoService.delete(id);

        return ResponseEntity.noContent().build();
    }

    @PreAuthorize("hasAuthority('" + ANALISTA + "')")
    @PutMapping("{id}")
    @LogOperation
    public ResponseEntity<GfdTipoDocumentoUpdateOutputDto> update(
            @AuthenticationPrincipal CustomUserPrincipal user,
            @RequestBody @Valid GfdTipoDocumentoUpdateInputDto inputDto,
            @PathVariable Integer id
    ) {
        inputDto.setId(id);

        return ResponseEntity.ok(gfdTipoDocumentoService.update(inputDto));
    }

    @PreAuthorize("hasAuthority('" + ANALISTA + "')")
    @PostMapping()
    @LogOperation
    public ResponseEntity<GfdTipoDocumentoCreateOutputDto> create(
            @AuthenticationPrincipal CustomUserPrincipal user,
            @RequestBody @Valid GfdTipoDocumentoCreateInputDto inputDto
    ) {
        return ResponseEntity.ok(gfdTipoDocumentoService.create(inputDto));
    }

}
