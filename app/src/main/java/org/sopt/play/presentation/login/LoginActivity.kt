package org.sopt.play.presentation.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
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
import org.sopt.play.presentation.register.RegisterActivity

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val registerEmail = intent.getStringExtra("email")
        val registerPassword = intent.getStringExtra("password")

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
                                Toast.makeText(this, "로그인 성공!", Toast.LENGTH_SHORT).show()

                                startActivity(intent)
                            } else {
                                Toast.makeText(this, R.string.wrong_input, Toast.LENGTH_SHORT).show()
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
