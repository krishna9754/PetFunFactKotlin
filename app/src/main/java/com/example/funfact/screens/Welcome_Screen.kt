package com.example.funfact.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight.Companion.SemiBold
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Welcome_Screen(userName: String?, animalSelect: String?) {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize()
        ) {
            TopBar(value = "Welcome $userName \uD83D\uDe0D")
            Text(text = "Thank you! for sharing Your Data",
                modifier = Modifier.padding(top = 20.dp),
                fontSize = 24.sp,
                fontWeight = SemiBold
            )

            Spacer(modifier = Modifier.size(60.dp))

            val finalText = if (animalSelect == "Cat")  "Your are a Cat lover" else  "Your are a Dog Lover"
           TextWithShadow(value = finalText)
        }

    }
}
