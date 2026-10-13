package org.sopt.play.core.util

import android.util.Patterns
import androidx.annotation.StringRes
import org.sopt.play.R

private fun isEmailValid(email: String) = Patterns.EMAIL_ADDRESS.matcher(email).matches()
private fun isPasswordValid(password: String) = password.length >= 6

@StringRes
fun getEmailError(email: String?): Int?  {
    return if (email.isNullOrEmpty() || isEmailValid(email)) null else R.string.invalid_email
}

@StringRes
fun getPasswordError(password: String?): Int? {
    return if (password.isNullOrEmpty() || isPasswordValid(password)) null else R.string.short_password
}

@StringRes
fun getPasswordCheckError(password: String?, passwordCheck: String?): Int? {
    return if (passwordCheck.isNullOrEmpty() || password == passwordCheck) null else R.string.different_password
}
