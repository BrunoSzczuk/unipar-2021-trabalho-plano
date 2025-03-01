package br.unipar.plano.interfaces.rest.cobrancas

import br.unipar.plano.domain.cobrancas.model.*
import br.unipar.plano.domain.cobrancas.valueobjects.StatusCobranca
import br.unipar.plano.infra.cobrancas.model.CobrancaView
import br.unipar.plano.interfaces.rest.planos.PlanoDTO
import java.math.BigDecimal
import java.time.LocalDate
import java.util.*
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull


data class CobrancaSummaryDTO(
    val id: UUID,
    val valorContrato: BigDecimal,
    val dataEmissao: LocalDate,
    val dataVencimento: LocalDate,
    var valorTotal: BigDecimal?,
    val contrato: ContratoDTO
) {

    companion object {

        fun toDTO(cobranca: CobrancaView) = CobrancaSummaryDTO(
            id = cobranca.id,
            valorContrato = cobranca.valorContrato,
            dataEmissao = cobranca.dataEmissao,
            dataVencimento = cobranca.dataVencimento,
            valorTotal = cobranca.valorTotal,
            contrato = ContratoDTO.toDTO(cobranca.contrato)
        )

    }

}

data class CobrancaDetailsDTO(
    val id: UUID,
    val status: StatusCobranca,
    val cobrancaData: CobrancaDTO
) {

    companion object {

        fun toDTO(cobranca: CobrancaView) = CobrancaDetailsDTO(
            id = cobranca.id,
            status = cobranca.status,
            cobrancaData = CobrancaDTO.toDTO(cobranca)
        )

        fun toDTO(cobranca: Cobranca) = CobrancaDetailsDTO(
            id = cobranca.id.id,
            status = cobranca.status,
            cobrancaData = CobrancaDTO.toDTO(cobranca)
        )

    }

}

data class CobrancaDTO(

    val valorContrato: BigDecimal,
    val valorAdicionalConsulta: BigDecimal,
    val valorAdicionalCirurgia: BigDecimal,
    val valorAdicionalIdade: BigDecimal,

    val dataEmissao: LocalDate,

    var dataCancelamento: LocalDate?,


    val dataVencimento: LocalDate,
    var valorTotal: BigDecimal?,
    val contrato: ContratoDTO

) {


    companion object {

        fun toDTO(cobranca: CobrancaView) = CobrancaDTO(
            valorAdicionalConsulta = cobranca.valorAdicionalConsulta,
            valorAdicionalCirurgia = cobranca.valorAdicionalCirurgia,
            valorAdicionalIdade = cobranca.valorAdicionalIdade,
            dataEmissao = cobranca.dataEmissao,
            dataCancelamento = cobranca.dataCancelamento,
            dataVencimento = cobranca.dataVencimento,
            valorTotal = cobranca.valorTotal,
            valorContrato = cobranca.valorContrato,
            contrato = ContratoDTO.toDTO(contrato = cobranca.contrato)
        )

        fun toDTO(cobranca: Cobranca) = CobrancaDTO(
            valorAdicionalConsulta = cobranca.valorAdicionalConsulta,
            valorAdicionalCirurgia = cobranca.valorAdicionalCirurgia,
            valorAdicionalIdade = cobranca.valorAdicionalIdade,
            dataEmissao = cobranca.dataEmissao,
            dataCancelamento = cobranca.dataCancelamento,
            dataVencimento = cobranca.dataVencimento,
            valorTotal = cobranca.valorTotal,
            valorContrato = cobranca.valorContrato,
            contrato = ContratoDTO.toDTO(contrato = cobranca.contrato)
        )
    }

}

data class ContratoDTO(

    @field:NotNull(message = "O campo ID é obrigatório para o contrato.")
    val id: UUID,
    @field:NotNull(message = "É necessário informar os dependentes do contrato.")
    @field:NotEmpty(message = "É necessário informar os dependentes do contrato.")
    val dependentes: Collection<UsuarioDTO>
) {
    companion object {
        fun toDTO(contrato: Contrato) = ContratoDTO(
            id = contrato.id.id,
            dependentes = contrato.dependentes.map { UsuarioDTO.toDTO(it) }
        )
    }

}

data class ProcedimentoDTO(
    val id: UUID
) {
    fun toModel() = Procedimento(
        id = this.id
    )

}

data class CirurgiaDTO(
    val id: UUID
) {
    fun toModel() = Cirurgia(
        id = this.id
    )
}

data class UsuarioDTO(
    val id: UUID,
    val plano: PlanoDTO,
    val dataNascimento: LocalDate
) {
    companion object {

        fun toDTO(usuario: Usuario) = UsuarioDTO(
            id = usuario.id,
            plano = PlanoDTO.toDTO(usuario.plano),
            dataNascimento = usuario.dataNascimento
        )

    }
}

