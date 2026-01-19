package br.com.mili.milibackend.gfd.shared.roles;

public interface GfdDocumentoRole extends GfdRoleBase {
    String CONSULTAR = PREFIX + "DOC_VISUALIZAR";
    String ALTERAR = PREFIX + "DOC_ALTERAR";
    String ALTERAR_DATA = PREFIX + "DOC_ALTERAR_DATA";
    String EXCLUIR = PREFIX + "DOC_EXCLUIR";
    String CRIAR = PREFIX + "DOC_CRIAR";
    String BAIXAR = PREFIX + "DOC_BAIXAR";
    String RELATORIO_BAIXAR = PREFIX + "DOC_RELATORIO_BAIXAR";
    String HISTORICO_CONSULTAR = PREFIX + "DOC_HISTORICO_VISUALIZAR";
}
