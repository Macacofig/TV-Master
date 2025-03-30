package com.control.app.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import com.control.usecases.ControlUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.text.Typography.dagger

@HiltViewModel
class ControlViewModel @Inject constructor(
    private val controlUseCase: ControlUseCase
) : ViewModel() {

    fun onApagarClicked() {
        viewModelScope.launch {
            controlUseCase.apagarTelevisor()
        }
    }
}

class FakeControlViewModel : ViewModel() {
    fun onApagarClicked() {
        // Simular acción sin lógica real
    }
}
