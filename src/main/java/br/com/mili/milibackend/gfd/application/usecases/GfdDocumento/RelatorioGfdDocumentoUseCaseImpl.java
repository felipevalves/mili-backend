package br.com.mili.milibackend.gfd.application.usecases.GfdDocumento;

import br.com.mili.milibackend.gfd.adapter.web.external.external.ReportExternalService;
import br.com.mili.milibackend.gfd.adapter.web.external.external.dto.ReportGfdDocumentoRequestDto;
import br.com.mili.milibackend.gfd.application.dto.gfdDocumento.relatorio.GfdDocumentoRelatorioFiltroDto;
import br.com.mili.milibackend.gfd.domain.usecases.gfdDocumento.RelatorioGfdDocumentoUseCase;
import org.springframework.stereotype.Service;

@Service
public class RelatorioGfdDocumentoUseCaseImpl implements RelatorioGfdDocumentoUseCase {

    private final ReportExternalService reportExternalService;

    public RelatorioGfdDocumentoUseCaseImpl(ReportExternalService reportExternalService) {
        this.reportExternalService = reportExternalService;
    }

    @Override
    public byte[] execute(GfdDocumentoRelatorioFiltroDto filtro) {
        StringBuilder where = new StringBuilder();

        if (filtro.getCtforCodigo() != null) {
            where.append(" AND CTFOR_CODIGO = ").append(filtro.getCtforCodigo());
        }

        if(filtro.getRazaoSocial() != null) {
            where.append(" AND RAZAO_SOCIAL LIKE '%").append(filtro.getRazaoSocial().toUpperCase()).append("%'");
        }

        if(filtro.getCnpj() != null) {
            where.append(" AND CTFOR_CGCCPF = '").append(filtro.getCnpj()).append("'");
        }

        if (filtro.getFuncionarioId() != null) {
            where.append(" AND ID_FUNCIONARIO = ").append(filtro.getFuncionarioId());
        }

        where.append(" AND PERIODO_INICIAL >= TO_DATE('2025-09-01', 'YYYY-MM-DD')");

        ReportGfdDocumentoRequestDto req = ReportGfdDocumentoRequestDto.builder()
                .paramQuery(where.toString())
                .build();

        return reportExternalService.getDocumento(req);
    }
}
