package com.example.funfact

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.funfact.data.UserDataUiEvent
import com.example.funfact.data.UserInputScreenState

class UserInputViewModel: ViewModel() {
    var uiState = mutableStateOf(UserInputScreenState())

    fun onEvent(event: UserDataUiEvent){
        when(event){
            is UserDataUiEvent.NameChanged -> {
                uiState.value = uiState.value.copy(nameEnter = event.name)
            }
            is UserDataUiEvent.AnimalChanged -> {
                uiState.value = uiState.value.copy(animalSelect = event.animal)
            }
        }
    }

    fun isValidState() : Boolean
    {
        return !uiState.value.nameEnter.isNullOrEmpty() &&
                !uiState.value.animalSelect.isNullOrEmpty()
    }
}
