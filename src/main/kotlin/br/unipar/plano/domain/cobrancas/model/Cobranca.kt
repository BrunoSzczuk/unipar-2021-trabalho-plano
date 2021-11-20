package br.unipar.plano.domain.cobrancas.model

import br.unipar.plano.domain.cobrancas.valueobjects.StatusCobranca
import java.math.BigDecimal
import java.math.RoundingMode
import java.time.LocalDate
import java.util.*
import javax.persistence.*


@Entity
class Cobranca(
    @EmbeddedId
    val id: IdCobranca,
    @Column(nullable = false)
    val valorContrato: BigDecimal,
    @Column(nullable = false)
    val valorAdicionalConsulta: BigDecimal,
    @Column(nullable = false)
    val valorAdicionalCirurgia: BigDecimal,
    @Column(nullable = false)
    val valorAdicionalIdade: BigDecimal,
    @Column(nullable = false)
    var status: StatusCobranca = StatusCobranca.ABERTO,
    @Column(nullable = false)
    val dataEmissao: LocalDate,
    var dataCancelamento: LocalDate?,
    @Column(nullable = false)
    val dataVencimento: LocalDate,
    @Column(nullable = false)
    var valorTotal: BigDecimal?,
    @ManyToOne
    val contrato: Contrato
) {
    init {
        valorTotal = valorContrato
            .add(valorAdicionalIdade)
            .add(
                valorAdicionalCirurgia
                    .multiply(BigDecimal.valueOf(contrato.cirurgias.count().toDouble()))
            )
            .add(
                valorAdicionalConsulta
                    .multiply(BigDecimal.valueOf(contrato.procedimentos.count().toDouble()))
            )
            .setScale(2, RoundingMode.HALF_UP)
    }

    fun cancelar() : Cobranca {
        if (status != StatusCobranca.ABERTO || status != StatusCobranca.PAGO) {
            throw IllegalStateException("Não é possível cancelar uma Cobranca com status $status")
        }
        return copy(status = StatusCobranca.CANCELADO, dataCancelamento = LocalDate.now())
    }

    private fun copy(
        id: IdCobranca = this.id,
        valorContrato: BigDecimal = this.valorContrato,
        valorAdicionalConsulta: BigDecimal = this.valorAdicionalConsulta,
        valorAdicionalCirurgia: BigDecimal = this.valorAdicionalCirurgia,
        valorAdicionalIdade: BigDecimal = this.valorAdicionalIdade,
        status: StatusCobranca = this.status,
        dataEmissao: LocalDate = this.dataEmissao,
        dataCancelamento: LocalDate? = this.dataCancelamento,
        dataVencimento: LocalDate = this.dataVencimento,
        valorTotal: BigDecimal? = this.valorTotal,
        contrato: Contrato = this.contrato
    ) = Cobranca(
        id = id,
        valorContrato = valorContrato,
        valorAdicionalConsulta = valorAdicionalConsulta,
        valorAdicionalCirurgia = valorAdicionalCirurgia,
        valorAdicionalIdade = valorAdicionalIdade,
        dataEmissao = dataEmissao,
        dataCancelamento = dataCancelamento,
        dataVencimento = dataVencimento,
        contrato = contrato,
        status = status,
        valorTotal = valorTotal
    )
}