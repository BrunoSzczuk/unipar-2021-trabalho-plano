package br.unipar.plano.infra.cobrancas.gateway

import br.unipar.plano.domain.cobrancas.gateway.CobrancaGateway
import br.unipar.plano.domain.cobrancas.model.Cobranca
import br.unipar.plano.domain.cobrancas.model.IdCobranca
import br.unipar.plano.domain.cobrancas.model.IdContrato
import br.unipar.plano.domain.cobrancas.valueobjects.StatusCobranca
import br.unipar.plano.infra.cobrancas.repository.CobrancaRepository
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.util.*

@Service
class CobrancaGatewayImpl(val cobrancaRepository: CobrancaRepository) : CobrancaGateway {
    override fun salvar(cobranca: Cobranca): Cobranca {
        return cobrancaRepository.save(cobranca)
    }

    override fun remover(cobranca: Cobranca) {
        cobrancaRepository.delete(cobranca)
    }

    override fun buscarPorId(id: IdCobranca, idContrato: IdContrato): Optional<Cobranca> {
        return cobrancaRepository.findById(idContrato, id)
    }


    override fun buscarPorContratoAndStatus(
        idContrato: IdContrato,
        status: Optional<List<StatusCobranca>>
    ): List<Cobranca> {
        return cobrancaRepository.buscarPorContratoAndStatus(idContrato, status.orElse(null))
    }

    override fun verificaSeExisteCobrancaProContratoNoMes(
        idContrato: IdContrato,
        dataEmissao: LocalDate,
        statusCobranca: StatusCobranca
    ): Boolean {
        return cobrancaRepository.verificaSeExisteCobrancaProContratoNoMes(idContrato, dataEmissao, statusCobranca)
    }
}