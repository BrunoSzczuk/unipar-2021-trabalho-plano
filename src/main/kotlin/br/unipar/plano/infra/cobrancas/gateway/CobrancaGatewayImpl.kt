package br.unipar.plano.infra.cobrancas.gateway

import br.unipar.plano.domain.cobrancas.gateway.CobrancaGateway
import br.unipar.plano.domain.cobrancas.model.Cobranca
import br.unipar.plano.domain.cobrancas.model.IdCobranca
import br.unipar.plano.domain.cobrancas.model.IdContrato
import br.unipar.plano.domain.cobrancas.valueobjects.StatusCobranca
import br.unipar.plano.infra.cobrancas.repository.CobrancaRepository
import mu.KotlinLogging
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.util.*

@Service
class CobrancaGatewayImpl(val cobrancaRepository: CobrancaRepository) : CobrancaGateway {

    private val logger = KotlinLogging.logger {}
    override fun salvar(cobranca: Cobranca): Cobranca {
        logger.info { "PostgreSQL -> método salvar sendo chamado." }
        return cobrancaRepository.save(cobranca)
    }

    override fun remover(cobranca: Cobranca) {
        logger.info { "PostgreSQL -> método remover sendo chamado." }
        cobrancaRepository.delete(cobranca)
    }

    override fun buscarPorId(id: IdCobranca, idContrato: IdContrato): Optional<Cobranca> {
        logger.info { "PostgreSQL -> método buscarPorId sendo chamado." }
        return cobrancaRepository.findById(idContrato, id)
    }


    override fun buscarPorContratoAndStatus(
        idContrato: IdContrato,
        status: Optional<List<StatusCobranca>>
    ): List<Cobranca> {
        logger.info { "PostgreSQL -> método buscarPorContratoAndStatus sendo chamado." }
        return cobrancaRepository.buscarPorContratoAndStatus(idContrato, status.orElse(null))
    }

    override fun verificaSeExisteCobrancaProContratoNoMes(
        idContrato: IdContrato,
        dataEmissao: LocalDate,
        statusCobranca: StatusCobranca
    ): Boolean {
        logger.info { "PostgreSQL -> método verificaSeExisteCobrancaProContratoNoMes sendo chamado." }
        return cobrancaRepository.verificaSeExisteCobrancaProContratoNoMes(idContrato, dataEmissao, statusCobranca)
    }
}