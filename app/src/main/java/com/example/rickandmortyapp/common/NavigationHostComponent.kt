package com.example.rickandmortyapp.common

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.rickandmortyapp.detailscreen.ui.screen.DetailCharacter
import com.example.rickandmortyapp.detailscreen.ui.viewmodel.DetailCharacterViewModel
import com.example.rickandmortyapp.mainscreen.ui.model.HomeCharacterCard
import com.example.rickandmortyapp.mainscreen.ui.model.Routes
import com.example.rickandmortyapp.mainscreen.ui.screen.component.HomeScreen
import com.example.rickandmortyapp.mainscreen.ui.viewmodel.CharactersViewModel

@Composable
fun NavigationHost(navController: NavHostController, detailsCharacterViewModel : DetailCharacterViewModel, charactersViewModel: CharactersViewModel){
    NavHost(
        navController = navController,
        startDestination = Routes.ListCharacters.route
    ) {
        composable(Routes.ListCharacters.route) {
            HomeScreen(
                viewModel = charactersViewModel,
                onDetailClick = {
                    navController.currentBackStackEntry?.savedStateHandle?.set(
                        key = HomeCharacterCard.TAG,
                        value = it
                    )
                    navController.navigate(Routes.DetailCharacters.route)
                }
            )
        }
        composable(
            Routes.DetailCharacters.route
        ) { backStackEntry ->

            val cardUI =
                navController.previousBackStackEntry?.savedStateHandle?.get<HomeCharacterCard>(
                    HomeCharacterCard.TAG
                )
            DetailCharacter(
                viewModel = detailsCharacterViewModel,
                cardDetailCharacter = cardUI?.toDetail()
            )

        }
    }
}