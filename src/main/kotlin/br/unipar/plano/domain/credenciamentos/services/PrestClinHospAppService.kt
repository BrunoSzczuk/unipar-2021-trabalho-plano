package br.unipar.plano.domain.credenciamentos.services


import br.unipar.plano.domain.credenciamentos.model.IdPrestadorClinicaHospital
import br.unipar.plano.interfaces.rest.credenciamentos.PrestClinHospDTO
import br.unipar.plano.interfaces.rest.credenciamentos.PrestClinHospDetailsDTO
import br.unipar.plano.interfaces.rest.credenciamentos.PrestClinHospSummaryDTO


interface PrestClinHospAppService {
    fun cria(prestClinHospDTO: PrestClinHospDTO): IdPrestadorClinicaHospital
    fun lista(): List<PrestClinHospSummaryDTO>
    fun buscaPorId(idPrestadorClinicaHospital: IdPrestadorClinicaHospital): PrestClinHospDetailsDTO
}

