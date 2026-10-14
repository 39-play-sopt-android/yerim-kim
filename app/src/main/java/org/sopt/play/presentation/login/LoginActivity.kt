package org.sopt.play.presentation.login

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
import org.sopt.play.MainActivity
import org.sopt.play.R
import org.sopt.play.core.designsystem.theme.PLAYSOPTTheme
import org.sopt.play.core.designsystem.theme.PlaySoptTheme
import org.sopt.play.core.extension.toast
import org.sopt.play.presentation.register.RegisterActivity

const val EXTRA_EMAIL = "email"
const val EXTRA_PASSWORD = "password"

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val registerEmail = intent.getStringExtra(EXTRA_EMAIL)
        val registerPassword = intent.getStringExtra(EXTRA_PASSWORD)

        enableEdgeToEdge()
        setContent {
            PlaySoptTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    containerColor = PLAYSOPTTheme.colors.white,
                ) { innerPadding ->
                    LoginScreen(
                        onLoginClick = { email,password ->
                            val intent = Intent(this, MainActivity::class.java).apply {
                                flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                            }

                            if (email == registerEmail && password == registerPassword) {
                                this.toast("로그인 성공!")
                                startActivity(intent)
                            } else {
                                this.toast(getString(R.string.wrong_input))
                            }
                        },
                        onRegisterClick = {
                            val intent = Intent(this, RegisterActivity::class.java)

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
