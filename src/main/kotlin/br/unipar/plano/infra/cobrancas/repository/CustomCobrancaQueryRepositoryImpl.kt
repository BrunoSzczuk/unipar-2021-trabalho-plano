package br.unipar.plano.infra.cobrancas.repository

import br.unipar.plano.infra.cobrancas.model.BuscaCobrancasPorIdContrato
import br.unipar.plano.infra.cobrancas.model.BuscaCobrancasPorIdContratoEIdCobranca
import br.unipar.plano.infra.cobrancas.model.BuscaCobrancasPorIdContratoEStatus
import br.unipar.plano.infra.cobrancas.model.CobrancaView
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import java.util.*


class CustomCobrancaQueryRepositoryImpl(private val mongoTemplate: MongoTemplate) :
    CustomCobrancaQueryRepository {

    override fun findAllByContratoAndStatusIn(query: BuscaCobrancasPorIdContratoEStatus): List<CobrancaView> {
        return mongoTemplate.find(
            Query.query(Criteria.where("contrato.id").`is`(query.idContrato).and("status").`in`(query.status)),
            CobrancaView::class.java
        )

    }

    override fun findAll(query: BuscaCobrancasPorIdContrato): List<CobrancaView> {
        return mongoTemplate.find(
            Query.query(
                Criteria.where("contrato.id").`is`(query.idContrato)
            ), CobrancaView::class.java
        )

    }

    override fun findById(query: BuscaCobrancasPorIdContratoEIdCobranca): Optional<CobrancaView> {
        return Optional.ofNullable(
            mongoTemplate.find(
                Query.query(
                    Criteria.where("contrato.id").`is`(query.idContrato).and("id").`is`(query.idCobranca.id)
                ), CobrancaView::class.java
            ).first()
        )
    }
}