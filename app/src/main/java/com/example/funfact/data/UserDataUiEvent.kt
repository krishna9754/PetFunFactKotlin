package com.example.funfact.data


sealed class UserDataUiEvent{
    data class NameChanged(val name: String): UserDataUiEvent()
    data class AnimalChanged(val animal: String): UserDataUiEvent()
}