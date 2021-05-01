package com.example.domain

sealed class Resource<T>(open val data: T? = null) {

    data class Success<T>(override val data: T) : Resource<T>()

    class Error<T>(val error: Throwable) : Resource<T>()

    class Loading<T> : Resource<T>() {
        override fun equals(other: Any?) = other is Loading<*>

        override fun hashCode() = javaClass.hashCode()
    }

    fun <R> map(mapper: (T) -> R): Resource<R> =
        when (this) {
            is Success -> Success(mapper.invoke(this.data))
            is Error -> Error(this.error)
            is Loading -> Loading()
        }
}
