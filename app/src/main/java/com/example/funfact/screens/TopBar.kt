package com.example.funfact.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.font.FontWeight.Companion.SemiBold
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.funfact.R

@Composable
fun TopBar(value: String){

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = value,
            modifier = Modifier.padding(start = 2.dp),
            fontSize = 24.sp,
            fontWeight = Bold
            )

        Spacer(modifier = Modifier.weight(1f))
        Icon(imageVector = Icons.Default.Notifications, contentDescription = "")
    }


}


//@Preview(showBackground = true)
@Composable
fun TopBarItems(){
//    TextInputField()
}


@Composable
fun TextComponent(textValue: String){
    Surface(modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
              .padding(10.dp, top = 10.dp)
        ){
            Text(text = "${ textValue }",
                modifier = Modifier.padding(start = 2.dp),
                fontSize = 32.sp,
                fontWeight = SemiBold
            )
            Text(text = "This app will prepare a detail page based on input provided by you",
                modifier = Modifier.padding(top = 12.dp),
                fontSize = 16.sp,
                )

            Spacer(modifier = Modifier.size(60.dp))
        }
    }
}



@Composable
fun TextInputField(
    onTextChange: (name:String) -> Unit
){
    var currentValue by remember {
        mutableStateOf("")
    }

    val LocalFocus = LocalFocusManager.current
    Text(text = "Name")

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = currentValue,
            onValueChange = {
                currentValue = it
                onTextChange(it)
            },
            placeholder = {
                Text(text = "Enter your name")
            },
            textStyle = TextStyle.Default.copy(fontSize = 26.sp),
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    LocalFocus.clearFocus()
                }
            )
        )
    Spacer(modifier = Modifier.size(18.dp))
    Text(text = "What do you like")
    }


@Composable
fun AnimalCard(Image: Int, Selected: Boolean,
              animalSelect: (animalSelect: String) -> Unit
               ){
    Card(
        modifier = Modifier
            .padding(24.dp)
            .size(130.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {

        Box(
            modifier = Modifier
                .fillMaxSize()
                .border(
                    width = 1.dp,
                    color = if (Selected) Color.Green else Color.Transparent,
                    shape = RoundedCornerShape(8.dp)
                )
        ) {
            Image(
                modifier = Modifier
                    .padding(16.dp)
                    .wrapContentWidth()
                    .wrapContentHeight()
                    .clickable {
                        val animalName = if (Image == R.drawable.img) "Cat" else "Dog";
                        animalSelect(animalName)
                    },
                painter = painterResource(id = Image),
                contentDescription = "Cat")
        }

    }
}




@Composable
fun ButtonComponent(
    gotoDetailScreen: () -> Unit
){
    Button(
        modifier = Modifier.fillMaxWidth(),
        onClick = {
            gotoDetailScreen()
        }) {
        Text(text = "Go to Detail Screen")
    }
}


@Composable
fun TextWithShadow(value: String){
    val shadowOffset = Offset(x = 1f, y = 2f)

    Text(
        text = value,
        modifier = Modifier,
        fontSize = 24.sp,
        style = TextStyle(
            shadow = Shadow(
                color = Color.Green,
                offset = shadowOffset,
                blurRadius = 2f
            )
        )
        )
}



@Composable
fun FinalAnimalDetail(value: String){
    Card(
        modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Text(text = value)
    }
}




