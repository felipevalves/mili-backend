package br.com.mili.milibackend.fornecedor.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@Setter
@NoArgsConstructor
public class FornecedorGetByCodUsuarioInputDto {
    private Integer codUsuario;
}
