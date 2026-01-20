package br.com.mili.milibackend.gfd.adapter.web.controller;


import br.com.mili.milibackend.gfd.application.dto.gfdCategoriaDocumento.*;
import br.com.mili.milibackend.gfd.domain.usecases.gfdCategoriaDocumento.CreateGfdCategoriaDocumentoUseCase;
import br.com.mili.milibackend.gfd.domain.usecases.gfdCategoriaDocumento.GetAllGfdCategoriaDocumentoUseCase;
import br.com.mili.milibackend.gfd.domain.usecases.gfdCategoriaDocumento.GetByIdGfdCategoriaDocumentoUseCase;
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
@RequestMapping(GfdCategoriaDocumentoController.ENDPOINT)
@RequiredArgsConstructor
public class GfdCategoriaDocumentoController {
    protected static final String ENDPOINT = "/mili-backend/v1/gfd/categorias-documento";

    private final GetAllGfdCategoriaDocumentoUseCase getAllGfdCategoriaDocumentoUseCase;
    private final GetByIdGfdCategoriaDocumentoUseCase getByIdGfdCategoriaDocumentoUseCase;
    private final CreateGfdCategoriaDocumentoUseCase createGfdCategoriaDocumentoUseCase;

    @PreAuthorize("hasAuthority('" + ANALISTA + "') " +
                  "or hasAuthority('" + FORNECEDOR + "')" +
                  "or hasAuthority('" + PORTARIA + "')" +
                  "or hasAuthority('" + FABRICA + "')" +
                  "or hasAuthority('" + SESMT + "')"
    )
    @GetMapping()
    @LogOperation
    public ResponseEntity<List<GfdCategoriaDocumentoGetAllOutputDto>> getAll(
            @AuthenticationPrincipal CustomUserPrincipal user,
            @ParameterObject @ModelAttribute @Valid GfdCategoriaDocumentoGetAllInputDto inputDto
    ) {
        return ResponseEntity.ok(getAllGfdCategoriaDocumentoUseCase.execute(inputDto));
    }

    @PreAuthorize("hasAuthority('" + ANALISTA + "') " +
                  "or hasAuthority('" + FORNECEDOR + "')" +
                  "or hasAuthority('" + PORTARIA + "')" +
                  "or hasAuthority('" + SESMT + "')"
    )
    @PostMapping()
    @LogOperation
    public ResponseEntity<GfdCategoriaDocumentoCreateOutputDto> create(
            @AuthenticationPrincipal CustomUserPrincipal user,
            @RequestBody @Valid GfdCategoriaDocumentoCreateInputDto inputDto
    ) {
        return ResponseEntity.ok(createGfdCategoriaDocumentoUseCase.execute(inputDto));
    }

    @PreAuthorize("hasAuthority('" + ANALISTA + "') " +
                  "or hasAuthority('" + FORNECEDOR + "')" +
                  "or hasAuthority('" + PORTARIA + "')" +
                  "or hasAuthority('" + FABRICA + "')" +
                  "or hasAuthority('" + SESMT + "')"
    )
    @GetMapping("{id}")
    @LogOperation
    public ResponseEntity<GfdCategoriaDocumentoGetByIdOutputDto> getById(
            @AuthenticationPrincipal CustomUserPrincipal user,
            @PathVariable Integer id
    ) {
        return ResponseEntity.ok(getByIdGfdCategoriaDocumentoUseCase.execute(id));
    }
}
