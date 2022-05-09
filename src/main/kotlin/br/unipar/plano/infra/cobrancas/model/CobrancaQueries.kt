package br.unipar.plano.infra.cobrancas.model

import br.unipar.plano.domain.cobrancas.model.IdCobranca
import br.unipar.plano.domain.cobrancas.model.IdContrato
import br.unipar.plano.domain.cobrancas.valueobjects.StatusCobranca


data class BuscaCobrancasPorIdContrato(val idContrato: IdContrato)
data class BuscaCobrancasPorIdContratoEIdCobranca(val idContrato: IdContrato, val idCobranca: IdCobranca)
data class BuscaCobrancasPorIdContratoEStatus(val idContrato: IdContrato, val status: List<StatusCobranca>?)
