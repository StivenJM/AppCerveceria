package com.example.proyectomovilesb2.sealed

import com.example.proyectomovilesb2.sealed.Error as ErrorBody

sealed class UiState {
    object Idle : UiState()
    object Loading : UiState()
    object Success : UiState()
    class Error(val error: ErrorBody) : UiState()
}
