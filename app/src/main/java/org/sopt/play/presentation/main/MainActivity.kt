package org.sopt.play.presentation.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import org.sopt.play.PlaySoptApplication
import org.sopt.play.core.designsystem.theme.PlaySoptTheme
import org.sopt.play.di.ViewModelFactory

class MainActivity : ComponentActivity() {
    private val viewModel: MainViewModel by viewModels {
        ViewModelFactory((application as PlaySoptApplication).container)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PlaySoptTheme {
                MainScreen(
                    viewModel = viewModel
                )
            }
        }
    }
}
