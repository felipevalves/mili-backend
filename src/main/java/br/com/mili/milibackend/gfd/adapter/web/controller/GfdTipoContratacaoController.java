package br.com.mili.milibackend.gfd.adapter.web.controller;

import br.com.mili.milibackend.gfd.application.dto.tipoContratacao.GfdTipoContratacaoGetAllInputDto;
import br.com.mili.milibackend.gfd.application.dto.tipoContratacao.GfdTipoContratacaoGetAllOutputDto;
import br.com.mili.milibackend.gfd.domain.usecases.gfdTipoContratacao.GfdTipoContratacaoGetAllUseCase;
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
@RequestMapping(GfdTipoContratacaoController.ENDPOINT)
@RequiredArgsConstructor
public class GfdTipoContratacaoController {

    protected static final String ENDPOINT = "/mili-backend/v1/gfd/tipos-contratacao";

    private final GfdTipoContratacaoGetAllUseCase gfdTipoContratacaoGetAllUseCase;

    @PreAuthorize("hasAuthority('" + ANALISTA + "') " +
                  "or hasAuthority('" + FORNECEDOR + "')" +
                  "or hasAuthority('" + PORTARIA + "')" +
                  "or hasAuthority('" + FABRICA + "')" +
                  "or hasAuthority('" + SESMT + "')")
    @GetMapping
    @LogOperation
    public ResponseEntity<List<GfdTipoContratacaoGetAllOutputDto>> getAll(
            @AuthenticationPrincipal CustomUserPrincipal user,
            @ParameterObject @ModelAttribute @Valid GfdTipoContratacaoGetAllInputDto inputDto
    ) {
        return ResponseEntity.ok(gfdTipoContratacaoGetAllUseCase.execute(inputDto));
    }
}

