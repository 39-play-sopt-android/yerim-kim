package org.sopt.play

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import org.sopt.play.core.designsystem.theme.PlaySoptTheme
import org.sopt.play.data.di.RepositoryModule
import org.sopt.play.presentation.main.MainScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        RepositoryModule.init(applicationContext)
        enableEdgeToEdge()
        setContent {
            PlaySoptTheme {
                MainScreen()
            }
        }
    }
}
