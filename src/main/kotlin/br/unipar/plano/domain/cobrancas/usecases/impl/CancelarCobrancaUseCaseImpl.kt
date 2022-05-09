package br.unipar.plano.domain.cobrancas.usecases.impl

import br.unipar.plano.domain.cobrancas.commands.CancelarCobrancaCommand
import br.unipar.plano.domain.cobrancas.gateway.CobrancaGateway
import br.unipar.plano.domain.cobrancas.model.Cobranca
import br.unipar.plano.domain.cobrancas.model.toCobrancaView
import br.unipar.plano.domain.cobrancas.service.CobrancaQueryService
import br.unipar.plano.domain.cobrancas.service.impl.CobrancaNotFoundException
import br.unipar.plano.domain.cobrancas.usecases.CancelarCobrancaUseCase
import org.springframework.stereotype.Service

@Service
class CancelarCobrancaUseCaseImpl(
    private val queryService: CobrancaQueryService,
    private val gateway: CobrancaGateway
) : CancelarCobrancaUseCase {
    override fun executa(command: CancelarCobrancaCommand): Cobranca {
        val cobrancaBanco = gateway.buscarPorId(command.idCobranca, command.idContrato).orElseThrow {
            CobrancaNotFoundException(command.idCobranca)
        }.cancelar()
        queryService.salvar(cobrancaBanco.toCobrancaView())
        return gateway.salvar(cobrancaBanco)
    }
}