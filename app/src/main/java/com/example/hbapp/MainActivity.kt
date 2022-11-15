package com.example.hbapp


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hbapp.ui.theme.HBAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HBAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BirthdayGreetingWithImage(getString(R.string.happy_birthday_text), getString(R.string.signature_text))
                }
            }
        }
    }
}


// Functions

@Composable
fun BirthdayGreetingWithText(message: String, from: String) {
   Column{

       Text(text = message,
            fontSize = 34.sp,
       modifier = Modifier
           .fillMaxWidth().fillMaxHeight()
           .wrapContentWidth(Alignment.CenterHorizontally)
           .wrapContentHeight(Alignment.CenterVertically)
           .weight(1f, true)
           .padding(start = 16.dp, top = 16.dp))

       Text(text = from,
        fontSize = 34.sp,
           modifier = Modifier.fillMaxWidth()
               .wrapContentWidth(Alignment.CenterHorizontally)
               .wrapContentHeight(Alignment.CenterVertically)
               .weight(1f, true)
               .padding(start = 16.dp, top = 16.dp))
   }
}


@Composable
fun BirthdayGreetingWithImage(message: String, from: String) {
    val image = painterResource(R.drawable.androidparty)
    Box {
        Image(painter = image,
            contentDescription = null,
            modifier = Modifier.fillMaxHeight(),
        contentScale = ContentScale.Crop) // rellena la pantalla con la imagen
        BirthdayGreetingWithText(message = message, from = from )
    }

}

// Preview

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun BirthdayCardPreview() {
    HBAppTheme {
        BirthdayGreetingWithImage("Happy Birthday Natalia!", "- from Siena")
    }
}