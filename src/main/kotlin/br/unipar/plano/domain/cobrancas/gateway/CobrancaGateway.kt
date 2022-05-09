package br.unipar.plano.domain.cobrancas.gateway

import br.unipar.plano.domain.cobrancas.model.Cobranca
import br.unipar.plano.domain.cobrancas.model.IdCobranca
import br.unipar.plano.domain.cobrancas.model.IdContrato
import br.unipar.plano.domain.cobrancas.valueobjects.StatusCobranca
import java.time.LocalDate
import java.util.*

interface CobrancaGateway {

    fun salvar(cobranca: Cobranca): Cobranca
    fun remover(cobranca: Cobranca)

    fun buscarPorId(id: IdCobranca, idContrato: IdContrato): Optional<Cobranca>
    fun buscarPorContratoAndStatus(idContrato: IdContrato, status: Optional<List<StatusCobranca>>): List<Cobranca>
    fun verificaSeExisteCobrancaProContratoNoMes(
        idContrato: IdContrato,
        dataEmissao: LocalDate,
        statusCobranca: StatusCobranca
    ): Boolean
}