package org.sopt.play.presentation.register

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import org.sopt.play.core.designsystem.theme.PLAYSOPTTheme
import org.sopt.play.core.designsystem.theme.PlaySoptTheme
import org.sopt.play.presentation.login.LoginActivity

const val EXTRA_EMAIL = "email"
const val EXTRA_PASSWORD = "password"

class RegisterActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PlaySoptTheme {

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    containerColor = PLAYSOPTTheme.colors.white,
                ) { innerPadding ->
                    RegisterScreen(
                        onRegisterClick = { email, password ->
                            val intent = Intent(this, LoginActivity::class.java).apply {
                                flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK

                                putExtra(EXTRA_EMAIL, email)
                                putExtra(EXTRA_PASSWORD, password)
                            }

                            startActivity(intent)
                        },
                        modifier = Modifier
                            .padding(innerPadding)
                            .consumeWindowInsets(innerPadding),
                        )
                }
            }
        }
    }
}
