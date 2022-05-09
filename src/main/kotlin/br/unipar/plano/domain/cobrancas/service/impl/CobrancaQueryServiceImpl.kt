package br.unipar.plano.domain.cobrancas.service.impl

import br.unipar.plano.domain.cobrancas.service.CobrancaQueryService
import br.unipar.plano.infra.cobrancas.model.BuscaCobrancasPorIdContrato
import br.unipar.plano.infra.cobrancas.model.BuscaCobrancasPorIdContratoEIdCobranca
import br.unipar.plano.infra.cobrancas.model.BuscaCobrancasPorIdContratoEStatus
import br.unipar.plano.infra.cobrancas.model.CobrancaView
import br.unipar.plano.infra.cobrancas.repository.CobrancaQueryRepository
import mu.KotlinLogging
import org.springframework.stereotype.Service

@Service
class CobrancaQueryServiceImpl(private val repository: CobrancaQueryRepository) : CobrancaQueryService {
    private val logger = KotlinLogging.logger {}
    override fun lista(query: BuscaCobrancasPorIdContrato): List<CobrancaView> {
        logger.info { "MONGO-DB -> método lista sendo chamado." }
        return repository.findAll(query)
    }

    override fun buscaPorId(query: BuscaCobrancasPorIdContratoEIdCobranca): CobrancaView {
        logger.info { "MONGO-DB -> método buscarPorId sendo chamado." }
        return repository.findById(query).orElseThrow {
            CobrancaNotFoundException(query.idCobranca)
        }
    }

    override fun salvar(cobranca: CobrancaView): CobrancaView {
        logger.info { "MONGO-DB -> método salvar sendo chamado." }
        return repository.save(cobranca)
    }

    override fun buscarPorContratoAndStatus(query: BuscaCobrancasPorIdContratoEStatus): List<CobrancaView> {
        logger.info { "MONGO-DB -> método buscarPorContratoAndStatus sendo chamado." }
        return repository.findAllByContratoAndStatusIn(query)
    }

}