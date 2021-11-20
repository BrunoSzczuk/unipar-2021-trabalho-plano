package br.unipar.plano.domain.cobrancas.model.factories

import br.unipar.plano.domain.cobrancas.model.Cobranca
import br.unipar.plano.domain.cobrancas.model.Contrato
import br.unipar.plano.domain.cobrancas.model.IdCobranca
import br.unipar.plano.domain.cobrancas.valueobjects.StatusCobranca
import java.math.BigDecimal
import java.time.LocalDate

class CobrancaTestFactories

fun cobranca(
    id: IdCobranca = IdCobranca(),
    valorContrato: BigDecimal = VALOR_CONTRATO,
    valorAdicionalConsulta: BigDecimal = VALOR_ADICIONAL_CONSULTA,
    valorAdicionalCirurgia: BigDecimal = VALOR_ADICIONAL_CIRURGIA,
    valorAdicionalIdade: BigDecimal = VALOR_ADICIONAL_IDADE,
    status: StatusCobranca = StatusCobranca.ABERTO,
    dataEmissao: LocalDate = DATA_EMISSAO_COBRANCA,
    dataCancelamento: LocalDate?,
    dataVencimento: LocalDate = DATA_VENCIMENTO_COBRANCA,
    valorTotal: BigDecimal?,
    contrato: Contrato = contrato()
) = Cobranca(id, valorContrato, valorAdicionalConsulta, valorAdicionalCirurgia, valorAdicionalIdade, status, dataEmissao, dataCancelamento, dataVencimento, valorTotal, contrato)