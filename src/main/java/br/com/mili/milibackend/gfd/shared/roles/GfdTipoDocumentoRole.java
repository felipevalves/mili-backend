package br.com.mili.milibackend.gfd.shared.roles;

public interface GfdTipoDocumentoRole extends GfdRoleBase {
    String CONSULTAR = PREFIX + "TIPO_DOC_VISUALIZAR";
    String ALTERAR = PREFIX + "TIPO_DOC_ALTERAR";
    String EXCLUIR = PREFIX + "TIPO_DOC_EXCLUIR";
    String CRIAR = PREFIX + "TIPO_DOC_CRIAR";
}
