package com.example.rickandmortyapp.mainscreen.domain

import androidx.paging.PagingData
import app.cash.turbine.test
import com.example.rickandmortyapp.core.Resource
import com.example.rickandmortyapp.mainscreen.data.network.GetAllCharactersRepository
import com.example.rickandmortyapp.mainscreen.ui.model.CharacterModelUI
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class GetAllCharactersUseCaseTest{

    @RelaxedMockK
    private lateinit var getAllCharactersRepository: GetAllCharactersRepository
    private lateinit var getAllCharactersUseCase: GetAllCharactersUseCase

    @Before
    fun onBefore(){
        MockKAnnotations.init(this)
        getAllCharactersUseCase = GetAllCharactersUseCase(getAllCharactersRepository)
    }

    @Test
    fun `when repository return success, then is success`() = runTest {
        //Given
        val pagingData = PagingData.empty<CharacterModelUI>()
        val expectedResult = Resource.Success(pagingData)
        every { getAllCharactersRepository.getAllCharacters() } returns flowOf(expectedResult)

        //Then
        getAllCharactersUseCase.getAllCharacters().test {
            val result = awaitItem()
            assertEquals(expectedResult, result)
            awaitComplete()
        }
    }

    @Test
    fun `when repository return failure, then is error`() = runTest {
        val pagingError = Exception("characters not found")
        val exceptedResult = Resource.Error<PagingData<CharacterModelUI>>(exception = pagingError)
        every { getAllCharactersRepository.getAllCharacters() } returns flowOf(exceptedResult)

        getAllCharactersUseCase.getAllCharacters().test {
            val result = awaitItem()
            assertEquals(exceptedResult, result)
            awaitComplete()
        }
    }
}