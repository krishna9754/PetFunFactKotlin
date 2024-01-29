package com.example.funfact.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.funfact.UserInputViewModel
import com.example.funfact.data.UserDataUiEvent
import com.example.funfact.screens.Routes
import com.example.funfact.screens.User_Input
import com.example.funfact.screens.Welcome_Screen

@Composable
fun FunFactNavigationGraph(userInputViewModel: UserInputViewModel = viewModel()){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.USER_INPUT){

        composable(Routes.USER_INPUT){
            User_Input(userInputViewModel, ShowWelcomeScreen = {
                navController.navigate(Routes.Welcome_Screen+"/${it.first}/${it.second}")
                userInputViewModel.onEvent(UserDataUiEvent.NameChanged(it.first))
                userInputViewModel.onEvent(UserDataUiEvent.AnimalChanged(it.second))
            })
        }

        composable("${Routes.Welcome_Screen}/{${Routes.username}}/{${Routes.animalSelected}}",
            arguments = listOf(
                navArgument("${Routes.username}") {
                    type = NavType.StringType
                },
                navArgument("${Routes.animalSelected}") {
                    type = NavType.StringType
                }
            )
            ){

            val userName = it.arguments?.getString(Routes.USER_INPUT)
            val animalSelect = it.arguments?.getString(Routes.animalSelected)
            Welcome_Screen(userName, animalSelect)
        }
    }
}