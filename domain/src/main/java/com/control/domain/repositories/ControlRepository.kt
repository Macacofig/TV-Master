package com.control.domain.repositories

interface ControlRepository {
    suspend fun apagarTelevisor()
    suspend fun subirVolumen()
    suspend fun cambiarCanal()
}