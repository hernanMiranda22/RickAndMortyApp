package com.example.rickandmortyapp.mainscreen.domain

import com.example.rickandmortyapp.core.Resource
import com.example.rickandmortyapp.mainscreen.data.network.GetAllCharactersRepository
import com.example.rickandmortyapp.mainscreen.ui.model.CharacterModelUI
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
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

    }
}