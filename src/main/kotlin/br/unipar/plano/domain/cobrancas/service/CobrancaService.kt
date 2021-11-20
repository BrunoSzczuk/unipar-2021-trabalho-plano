package br.unipar.plano.domain.cobrancas.service

import br.unipar.plano.application.exceptions.NegocioException
import br.unipar.plano.domain.cobrancas.model.Cobranca
import br.unipar.plano.domain.cobrancas.model.Contrato
import br.unipar.plano.domain.cobrancas.model.IdCobranca
import br.unipar.plano.domain.cobrancas.service.impl.CobrancaNotFoundException
import br.unipar.plano.interfaces.rest.cobrancas.CobrancaDetailsDTO
import br.unipar.plano.interfaces.rest.cobrancas.CobrancaSummaryDTO
import java.time.LocalDate

interface CobrancaService {
    @Throws(NegocioException::class)
    fun registrarCobranca(contrato: Contrato, dataEmissao: LocalDate): Cobranca

    @Throws(CobrancaNotFoundException::class)
    fun cancelarCobranca(idCobranca: IdCobranca): CobrancaDetailsDTO

    fun buscaTodos(): List<CobrancaSummaryDTO>

    @Throws(CobrancaNotFoundException::class)
    fun buscarPorId(id: IdCobranca): CobrancaDetailsDTO
}