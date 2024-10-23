package com.example.rickandmortyapp.detailscreen.domain

import com.example.rickandmortyapp.core.Resource
import com.example.rickandmortyapp.detailscreen.ui.model.EpisodeModelUI
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class GetAllEpisodesByCharacterUseCaseTest{

    @RelaxedMockK
    private lateinit var getEpisodeByCharacterUseCase: GetEpisodeByCharacterUseCase
    private lateinit var getAllEpisodesByCharacterUseCase: GetAllEpisodesByCharacterUseCase

    @Before
    fun onBefore(){
        MockKAnnotations.init(this)
        getAllEpisodesByCharacterUseCase = GetAllEpisodesByCharacterUseCase(getEpisodeByCharacterUseCase)
    }

    @Test
    fun `when getEpisodeByCharacterUseCase return success, then is success`() = runTest {
        val url = "gfdgdfgfdg"
        val nameEpisodeFalse = "Pilot"
        val airDateFalse = "December 2, 2013"
        val numberFalse = "S01E01"

        coEvery { getEpisodeByCharacterUseCase.getEpisodeByCharacter(url) } returns Resource.Success(
            EpisodeModelUI(
                nameEpisodeFalse, airDateFalse, numberFalse
            )
        )

        val result = getAllEpisodesByCharacterUseCase.getAllEpisodeByCharacter(listOf(url))

        assert(result is Resource.Success)
        coVerify { getEpisodeByCharacterUseCase.getEpisodeByCharacter(url) }
    }

    @Test
    fun `when getEpisodeByCharacterUseCase return error, then is error`() = runTest {
        val url = "gfdgdfgfdg"
        val exception = Exception("Episodes not found")
        coEvery { getEpisodeByCharacterUseCase.getEpisodeByCharacter(url) } returns Resource.Error(exception)

        val result = getAllEpisodesByCharacterUseCase.getAllEpisodeByCharacter(listOf(url))

        assert(result is Resource.Error)
        coVerify { getEpisodeByCharacterUseCase.getEpisodeByCharacter(url) }
    }
}