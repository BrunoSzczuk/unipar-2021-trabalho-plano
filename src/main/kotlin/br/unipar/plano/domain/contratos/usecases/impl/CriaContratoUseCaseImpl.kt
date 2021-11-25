package br.unipar.plano.domain.contratos.usecases.impl

import br.unipar.plano.domain.contratos.model.Contrato
import br.unipar.plano.domain.contratos.model.ContratoRepository
import br.unipar.plano.domain.contratos.usecases.CriaContratoUseCase
import org.springframework.stereotype.Service

@Service
class CriaContratoUseCaseImpl (private val contratoRepository: ContratoRepository): CriaContratoUseCase {

    override fun cria(contrato: Contrato): Contrato {
        if (contratoRepository.existsById(contrato.idContrato)) {
            throw IllegalStateException("Já existe contrato cadastrado com a ID ${contrato.idContrato}")
        }
        return contratoRepository.save(contrato)
    }
}