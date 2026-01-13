package br.com.mili.milibackend.gfd.application.dto.gfdDocumento.relatorio;

import br.com.mili.milibackend.gfd.domain.entity.GfdDocumentoStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GfdDocumentoRelatorioFiltroDto {
    private Integer funcionarioId;
    private Integer ctforCodigo;
    private String razaoSocial;
    private String cnpj;
    private GfdDocumentoStatusEnum status;
    private Integer idLocalTrabalho;
}
