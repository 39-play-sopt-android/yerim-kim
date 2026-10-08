package org.sopt.play.presentation.signup

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

class SignUpActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PlaySoptTheme {

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    containerColor = PLAYSOPTTheme.colors.white,
                ) { innerPadding ->
                    SignUpScreen(
                        onSignUpClick = { email, password ->
                            val intent = Intent(this, LoginActivity::class.java).apply {
                                putExtra("email", email)
                                putExtra("password", password)
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