package br.com.mili.milibackend.gfd.shared.roles;

public interface GfdTipoContratacaoRole extends GfdRoleBase {
    String CONSULTAR = PREFIX + "TIPO_CONTRATACAO_VISUALIZAR";
    String ALTERAR = PREFIX + "TIPO_CONTRATACAO_ALTERAR";
    String EXCLUIR = PREFIX + "TIPO_CONTRATACAO_EXCLUIR";
    String CRIAR = PREFIX + "TIPO_CONTRATACAO_CRIAR";
}
