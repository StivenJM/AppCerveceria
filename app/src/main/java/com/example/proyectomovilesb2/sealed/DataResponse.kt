package com.example.proyectomovilesb2.sealed

sealed class DataResponse<T>(
    var data: T? = null,
    var error: com.example.proyectomovilesb2.sealed.Error? = null,
) {
    class Success<T>(data: T) : DataResponse<T>(data = data)
    class Error<T>(error: com.example.proyectomovilesb2.sealed.Error) : DataResponse<T>(error = error)
}