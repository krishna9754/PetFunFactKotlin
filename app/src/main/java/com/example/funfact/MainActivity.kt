package com.example.funfact

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import com.example.funfact.navigation.FunFactNavigationGraph
import com.example.funfact.ui.theme.FunFactTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FunFactTheme {
               FunFacyAPP()
            }
        }
    }
}


@Composable
fun FunFacyAPP(){
    FunFactNavigationGraph()
}