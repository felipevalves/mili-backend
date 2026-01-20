package br.com.mili.milibackend.gfd.shared.roles;

public interface GfdCategoriaDocumentoRole extends GfdRoleBase {
    String CONSULTAR = PREFIX + "CATEGORIA_DOC_VISUALIZAR";
    String CRIAR = PREFIX + "CATEGORIA_DOC_CRIAR";
    String ALTERAR = PREFIX + "CATEGORIA_DOC_ALTERAR";
    String EXCLUIR = PREFIX + "CATEGORIA_DOC_EXCLUIR";
    String BAIXAR = PREFIX + "CATEGORIA_DOC_BAIXAR";
}
