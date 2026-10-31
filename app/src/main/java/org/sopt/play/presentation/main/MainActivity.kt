package org.sopt.play.presentation.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import org.sopt.play.core.designsystem.theme.PlaySoptTheme
import org.sopt.play.data.di.RepositoryModule

class MainActivity : ComponentActivity() {
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        RepositoryModule.init(applicationContext)
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
