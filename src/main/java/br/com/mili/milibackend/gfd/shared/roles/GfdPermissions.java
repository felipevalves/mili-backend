package br.com.mili.milibackend.gfd.shared.roles;

public final class GfdPermissions {

    private GfdPermissions() {
    }

    public static final class Geral {
        public static final String ANALISTA = GfdGeralRole.ANALISTA;
        public static final String FORNECEDOR = GfdGeralRole.FORNECEDOR;
        public static final String PORTARIA = GfdGeralRole.VISUALIZACAO;
        public static final String SESMT = GfdGeralRole.SESMT;
        public static final String FABRICA = GfdGeralRole.FABRICA;
    }
/*
    public static final class Fornecedor {
        public static final String CONSULTAR = GfdFornecedorRole.CONSULTAR;
        public static final String DADOS_ALTERAR = GfdFornecedorRole.DADOS_ALTERAR;
        public static final String VERIFICAR = GfdFornecedorRole.VERIFICAR;
        public static final String RECUPERAR = GfdFornecedorRole.RECUPERAR;
    }

    public static final class Documento {
        public static final String CONSULTAR = GfdDocumentoRole.CONSULTAR;
        public static final String ALTERAR = GfdDocumentoRole.ALTERAR;
        public static final String ALTERAR_DATA = GfdDocumentoRole.ALTERAR_DATA;
        public static final String EXCLUIR = GfdDocumentoRole.EXCLUIR;
        public static final String CRIAR = GfdDocumentoRole.CRIAR;
        public static final String HISTORICO = GfdDocumentoRole.HISTORICO_CONSULTAR;
        public static final String BAIXAR = GfdDocumentoRole.BAIXAR;
        public static final String RELATORIO_BAIXAR = GfdDocumentoRole.RELATORIO_BAIXAR;
    }

    public static final class Funcionario {
        public static final String CONSULTAR = GfdFuncionarioRole.CONSULTAR;
        public static final String ALTERAR = GfdFuncionarioRole.ALTERAR;
        public static final String DESLIGAR = GfdFuncionarioRole.DESLIGAR;
        public static final String EXCLUIR = GfdFuncionarioRole.EXCLUIR;
        public static final String CRIAR = GfdFuncionarioRole.CRIAR;
        public static final String JUSTIFICAR_LIBERAR = GfdFuncionarioRole.JUSTIFICAR_LIBERAR;
        public static final String LIBERAR = GfdFuncionarioRole.LIBERAR;
        public static final String LIBERAR_HISTORICO = GfdFuncionarioRole.LIBERACAO_HISTORICO;
        public static final String ACADEMIA_REENVIO_EMAIL = GfdFuncionarioRole.ACADEMIA_REENVIO_EMAIL;
    }

    public static final class TipoDocumento {
        public static final String CONSULTAR = GfdTipoDocumentoRole.CONSULTAR;
        public static final String ALTERAR = GfdTipoDocumentoRole.ALTERAR;
        public static final String EXCLUIR = GfdTipoDocumentoRole.EXCLUIR;
        public static final String CRIAR = GfdTipoDocumentoRole.CRIAR;
    }

    public static final class CategoriaDocumento {
        public static final String CONSULTAR = GfdCategoriaDocumentoRole.CONSULTAR;
        public static final String CRIAR = GfdCategoriaDocumentoRole.CRIAR;
        public static final String ALTERAR = GfdCategoriaDocumentoRole.ALTERAR;
        public static final String EXCLUIR = GfdCategoriaDocumentoRole.EXCLUIR;
        public static final String BAIXAR = GfdCategoriaDocumentoRole.BAIXAR;
    }

    public static final class TipoContratacao {
        public static final String CONSULTAR = GfdTipoContratacaoRole.CONSULTAR;
        public static final String ALTERAR = GfdTipoContratacaoRole.ALTERAR;
        public static final String EXCLUIR = GfdTipoContratacaoRole.EXCLUIR;
        public static final String CRIAR = GfdTipoContratacaoRole.CRIAR;
    }

    public static final class TipoFornecedor {
        public static final String CONSULTAR = GfdTipoFornecedorRole.CONSULTAR;
        public static final String ALTERAR = GfdTipoFornecedorRole.ALTERAR;
        public static final String EXCLUIR = GfdTipoFornecedorRole.EXCLUIR;
        public static final String CRIAR = GfdTipoFornecedorRole.CRIAR;
    }*/
}
