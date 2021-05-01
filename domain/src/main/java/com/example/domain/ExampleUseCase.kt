package com.example.domain

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onStart
import javax.inject.Named

class ExampleUseCase(
    @param:Named("io") val dispatcher: CoroutineDispatcher
) : UseCase<List<Int>, Int> {
    override fun run(params: Int?) =
        flow<Resource<List<Int>>> {
            val result = countTo(params ?: 1)
            emit(Resource.Success(result))
        }
            .onStart { emit(Resource.Loading()) }
            .flowOn(dispatcher)
            .catch { emit(Resource.Error(it)) }


    private suspend fun countTo(maxIntVal: Int): List<Int> {
        if (maxIntVal > 10) throw IllegalArgumentException("Yo! We haven't got this much time!")
        val mutableList = mutableListOf<Int>()
        for (int in 0..maxIntVal) {
            mutableList.add(int)
            delay(500)
        }
        return mutableList
    }
}