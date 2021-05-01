package com.example.domain

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

interface UseCase<T, Params> {

    fun run(params: Params? = null): Flow<Resource<T>>

    operator fun invoke(
        scope: CoroutineScope,
        params: Params? = null,
        onResult: (Resource<T>) -> Unit = {}
    ): Job = scope.launch {
        run(params).collect {
            onResult(it)
        }
    }
}