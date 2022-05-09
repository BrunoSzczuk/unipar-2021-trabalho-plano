package br.unipar.plano.infra.cobrancas.repository

import br.unipar.plano.domain.cobrancas.model.Cobranca
import br.unipar.plano.domain.cobrancas.model.IdCobranca
import br.unipar.plano.domain.cobrancas.model.IdContrato
import br.unipar.plano.domain.cobrancas.valueobjects.StatusCobranca
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import java.time.LocalDate
import java.util.*


interface CobrancaRepository : JpaRepository<Cobranca, IdCobranca> {

    @Deprecated(
        message = "Procurar usar a função findAll(idContrato) que passa o contrato como filtro",
        replaceWith = ReplaceWith("this.findAll(idContrato)")
    )
    override fun findAll(): MutableList<Cobranca>

    @Deprecated(
        message = "Procurar usar a função findById(idContrato, idCobranca) que passa o contrato como filtro",
        replaceWith = ReplaceWith("this.findById(idContrato, idCobranca)")
    )
    override fun findById(id: IdCobranca): Optional<Cobranca>

    @Query(value = "select count(c)> 0  from Cobranca c where c.contrato.id = :contrato and date_part('month', cast(c.dataEmissao as date)) = date_part('month', cast(:emissao as date)) and date_part('year',cast(c.dataEmissao as date)) = date_part('year', cast(:emissao as date)) and not c.status = :status ")
    fun verificaSeExisteCobrancaProContratoNoMes(
        @Param("contrato") idContrato: IdContrato,
        @Param("emissao") data: LocalDate,
        @Param("status") status: StatusCobranca
    ): Boolean

    @Query(value = "select c from Cobranca c where c.contrato.id = :contrato and (:status is null or c.status in (:status))")
    fun buscarPorContratoAndStatus(
        @Param("contrato") idContrato: IdContrato,
        @Param("status") status: List<StatusCobranca>
    ): List<Cobranca>

    @Query(value = "select c from Cobranca c where c.contrato.id = :contrato")
    fun findAll(@Param("contrato") idContrato: IdContrato): List<Cobranca>

    @Query(value = "select c from Cobranca c where c.contrato.id = :contrato and c.id = :id")
    fun findById(@Param("contrato") idContrato: IdContrato, @Param("id") idCobranca: IdCobranca): Optional<Cobranca>

}