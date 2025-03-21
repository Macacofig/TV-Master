package com.control.app.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.control.usecases.ControlUseCase
import kotlinx.coroutines.launch

class ControlViewModel(private val controlUseCase: ControlUseCase) : ViewModel() {

    fun onApagarClicked() {
        viewModelScope.launch {
            controlUseCase.apagarTelevisor()
        }
    }

    // Agrega otros métodos para manejar eventos de la UI (botones)
}