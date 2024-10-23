package com.example.rickandmortyapp.detailscreen.domain

import com.example.rickandmortyapp.core.Resource
import com.example.rickandmortyapp.detailscreen.data.network.GetEpisodesByCharacterRepository
import com.example.rickandmortyapp.detailscreen.ui.model.EpisodeModelUI
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class GetEpisodeByCharacterUseCaseTest{
    @RelaxedMockK
    private lateinit var getEpisodesByCharacterRepository: GetEpisodesByCharacterRepository
    private lateinit var getEpisodeByCharacterUseCase: GetEpisodeByCharacterUseCase

    @Before
    fun onBefore(){
        MockKAnnotations.init(this)
        getEpisodeByCharacterUseCase = GetEpisodeByCharacterUseCase(getEpisodesByCharacterRepository)
    }

    @Test
    fun `when repository returns Success, then is success`() = runTest {
        val url = "gfdgdfgfdg"
        val nameEpisodeFalse = "Pilot"
        val airDateFalse = "December 2, 2013"
        val numberFalse = "S01E01"
        coEvery { getEpisodesByCharacterRepository.listEpisodes(url) } returns Resource.Success(
            EpisodeModelUI(nameEpisodeFalse,airDateFalse, numberFalse)
        )

        val result = getEpisodeByCharacterUseCase.getEpisodeByCharacter(url)

        assert(result is Resource.Success)
        coVerify { getEpisodesByCharacterRepository.listEpisodes(url) }
    }
}