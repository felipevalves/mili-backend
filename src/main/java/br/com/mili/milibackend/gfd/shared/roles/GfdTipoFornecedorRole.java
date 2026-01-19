package br.com.mili.milibackend.gfd.shared.roles;

public interface GfdTipoFornecedorRole extends GfdRoleBase {
    String CONSULTAR = PREFIX + "TIPO_FORNECEDOR_VISUALIZAR";
    String ALTERAR = PREFIX + "TIPO_FORNECEDOR_ALTERAR";
    String EXCLUIR = PREFIX + "TIPO_FORNECEDOR_EXCLUIR";
    String CRIAR = PREFIX + "TIPO_FORNECEDOR_CRIAR";
}
