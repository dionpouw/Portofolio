package com.jeflette.mynotes.mainScreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jeflette.mynotes.affirmation.AffirmationCard
import com.jeflette.mynotes.restaurantScreen.RestaurantScreen
import com.jeflette.mynotes.ui.theme.MyNotesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyNotesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AffirmationCard()
                }
            }
        }
    }
}

@Preview(
    showSystemUi = true,
    device = Devices.PIXEL_4_XL,
    name = "Greeting Preview"
)
@Composable
fun MainScreen() {
    RestaurantScreen()
}

@Composable
fun Greeting() {
    Column {
        Text(
            text = "Hello World!",
            style = MaterialTheme.typography.bodySmall,
            fontFamily = FontFamily.Monospace,
            color = MaterialTheme.colorScheme.primary
        )
        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Blue,
                contentColor = Color.Red
            ),
            shape = MaterialTheme.shapes.medium
        ) {
            Text(text = "Button")
        }
        NameInput()
        Box(
            modifier = Modifier
                .size(120.dp)
                .background(MaterialTheme.colorScheme.primaryContainer)
        ) {
            Text(
                text = "Box",
                color = MaterialTheme.colorScheme.primary,
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NameInput() {
    val textState = remember { mutableStateOf("") }
    TextField(
        textStyle = TextStyle(fontFamily = FontFamily.Serif),
        value = textState.value, onValueChange = { newValue ->
            textState.value = newValue
        }, label = {
            Text(
                fontFamily = FontFamily.Serif,
                text = "Name"
            )
        })
}