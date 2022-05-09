package br.unipar.plano.domain.cobrancas.service

import br.unipar.plano.infra.cobrancas.model.BuscaCobrancasPorIdContrato
import br.unipar.plano.infra.cobrancas.model.BuscaCobrancasPorIdContratoEIdCobranca
import br.unipar.plano.infra.cobrancas.model.BuscaCobrancasPorIdContratoEStatus
import br.unipar.plano.infra.cobrancas.model.CobrancaView

interface CobrancaQueryService {
    fun lista(query: BuscaCobrancasPorIdContrato): List<CobrancaView>
    fun buscaPorId(query: BuscaCobrancasPorIdContratoEIdCobranca): CobrancaView
    fun salvar(cobranca: CobrancaView): CobrancaView
    fun buscarPorContratoAndStatus(query: BuscaCobrancasPorIdContratoEStatus): List<CobrancaView>

}
