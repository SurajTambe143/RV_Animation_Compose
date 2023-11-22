package com.example.basicc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

import androidx.compose.runtime.saveable.rememberSaveable

import androidx.compose.ui.tooling.preview.Preview

import com.example.basicc.ui.screen.OnBordingScreen
import com.example.basicc.ui.theme.BasicCTheme
import com.example.basicc.ui.screen.Greetings


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicCTheme {
                MyApp(modifier = Modifier.fillMaxSize())
            }
        }
    }


}

@Composable
fun MyApp(modifier: Modifier = Modifier) {
    var shouldShowOnBoarding by rememberSaveable { mutableStateOf(true) }

    Surface(modifier, color = MaterialTheme.colorScheme.background) {
        if (shouldShowOnBoarding) OnBordingScreen(onContinueClick = {
            shouldShowOnBoarding = false
        })
        else Greetings()
    }
}

@Preview
@Composable
fun MyAppPreview() {
    BasicCTheme {
        MyApp(Modifier.fillMaxSize())
    }
}



