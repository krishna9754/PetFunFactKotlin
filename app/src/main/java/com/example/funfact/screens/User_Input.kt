package com.example.funfact.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.funfact.R
import com.example.funfact.UserInputViewModel
import com.example.funfact.data.UserDataUiEvent


@Composable
fun User_Input(
    navController: UserInputViewModel,
    ShowWelcomeScreen: (valuesPair: Pair<String, String>) -> Unit
){
  Surface(
      modifier = Modifier.fillMaxSize()
  ) {
      Column(
          modifier = Modifier
              .padding(10.dp)
              .fillMaxSize()
      ) {
          TopBar(value = "Hi there \uD83D\uDE0A")
          TextComponent(textValue = "Let's learn about us !")
          TextInputField(onTextChange = {
              navController.onEvent(UserDataUiEvent.NameChanged(it))
          })

          Row(modifier = Modifier.fillMaxWidth()) {
              AnimalCard(Image = R.drawable.img, animalSelect = {
                  navController.onEvent(UserDataUiEvent.AnimalChanged(it)
                  )
              }, Selected = navController.uiState.value.animalSelect == "Cat")


              AnimalCard(Image = R.drawable.img_1, animalSelect = {
                  navController.onEvent(UserDataUiEvent.AnimalChanged(it)
                  )
              }, Selected = navController.uiState.value.animalSelect == "Dog")
          }

          
          Spacer(modifier = Modifier.weight(1f))

          if(navController.isValidState()
          ) {
              ButtonComponent(
                  gotoDetailScreen = {
                      ShowWelcomeScreen(
                          Pair(
                              navController.uiState.value.nameEnter,
                              navController.uiState.value.animalSelect
                          )
                      )
                  }
              )
          }
      }
  }

}

