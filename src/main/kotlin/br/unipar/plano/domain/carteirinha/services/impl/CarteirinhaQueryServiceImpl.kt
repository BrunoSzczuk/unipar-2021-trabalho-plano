package br.unipar.plano.domain.carteirinha.services.impl

import br.unipar.plano.domain.carteirinha.model.Carteirinha
import br.unipar.plano.domain.carteirinha.model.CarteirinhaRepository
import br.unipar.plano.domain.carteirinha.model.IdCarteirinha
import br.unipar.plano.domain.carteirinha.services.CarteirinhaQueryService
import org.springframework.stereotype.Service

@Service
class CarteirinhaQueryServiceImpl(private val carteirinhaRepository: CarteirinhaRepository): CarteirinhaQueryService {
    override fun buscaPorId(idCarteirinha: IdCarteirinha): Carteirinha = carteirinhaRepository.findById(idCarteirinha).orElseThrow {
        Exception("Carteirinha com o id ${idCarteirinha.idCarteirinha} não encontrada!")
    }

}