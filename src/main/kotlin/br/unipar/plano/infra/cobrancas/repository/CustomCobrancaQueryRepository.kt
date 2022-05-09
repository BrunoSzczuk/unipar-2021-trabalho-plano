package br.unipar.plano.infra.cobrancas.repository

import br.unipar.plano.infra.cobrancas.model.BuscaCobrancasPorIdContrato
import br.unipar.plano.infra.cobrancas.model.BuscaCobrancasPorIdContratoEIdCobranca
import br.unipar.plano.infra.cobrancas.model.BuscaCobrancasPorIdContratoEStatus
import br.unipar.plano.infra.cobrancas.model.CobrancaView
import java.util.*

interface CustomCobrancaQueryRepository {


    fun findAllByContratoAndStatusIn(
        query: BuscaCobrancasPorIdContratoEStatus
    ): List<CobrancaView>

    fun findAll(query: BuscaCobrancasPorIdContrato): List<CobrancaView>

    fun findById(query: BuscaCobrancasPorIdContratoEIdCobranca): Optional<CobrancaView>
}