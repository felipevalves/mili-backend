package br.com.mili.milibackend.gfd.shared.roles;

public interface GfdFornecedorRole extends GfdRoleBase {
    String CONSULTAR = PREFIX + "FORN_VISUALIZAR";
    String DADOS_ALTERAR = PREFIX + "FORN_DADOS_ALTERAR";
    String VERIFICAR = PREFIX + "FORN_VERIFICAR";
    String RECUPERAR = PREFIX + "FORN_RECUPERAR";
}
