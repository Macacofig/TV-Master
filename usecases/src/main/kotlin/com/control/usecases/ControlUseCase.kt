package com.control.usecases

import com.control.domain.repositories.ControlRepository

class ControlUseCase(private val controlRepository: ControlRepository) {
    suspend fun apagarTelevisor() {
        controlRepository.apagarTelevisor()
    }

    suspend fun subirVolumen() {
        controlRepository.subirVolumen()
    }

    suspend fun cambiarCanal() {
        controlRepository.cambiarCanal()
    }
}