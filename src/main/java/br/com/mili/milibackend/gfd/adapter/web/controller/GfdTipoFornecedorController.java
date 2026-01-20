package br.com.mili.milibackend.gfd.adapter.web.controller;

import br.com.mili.milibackend.gfd.application.dto.gfdTipoFornecedor.GfdTipoFornecedorGetAllInputDto;
import br.com.mili.milibackend.gfd.application.dto.gfdTipoFornecedor.GfdTipoFornecedorGetAllOutputDto;
import br.com.mili.milibackend.gfd.domain.usecases.gfdTipoFornecedor.GetAllUseGfdTipoFornecedorCase;
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
@RequestMapping(GfdTipoFornecedorController.ENDPOINT)
@RequiredArgsConstructor
public class GfdTipoFornecedorController {

    protected static final String ENDPOINT = "/mili-backend/v1/gfd/tipos-fornecedor";

    private final GetAllUseGfdTipoFornecedorCase gfdTipoFornecedorGetAllUseCase;

    @PreAuthorize("hasAuthority('" + ANALISTA + "') " +
                  "or hasAuthority('" + FORNECEDOR + "')" +
                  "or hasAuthority('" + PORTARIA + "')" +
                  "or hasAuthority('" + FABRICA + "')" +
                  "or hasAuthority('" + SESMT + "')")
    @GetMapping
    @LogOperation
    public ResponseEntity<List<GfdTipoFornecedorGetAllOutputDto>> getAll(
            @AuthenticationPrincipal CustomUserPrincipal user,
            @ParameterObject @ModelAttribute @Valid GfdTipoFornecedorGetAllInputDto inputDto
    ) {
        return ResponseEntity.ok(gfdTipoFornecedorGetAllUseCase.execute(inputDto));
    }
}

