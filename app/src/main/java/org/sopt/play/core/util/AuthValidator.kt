package org.sopt.play.core.util

import android.util.Patterns

fun isEmailValid(email: String) = Patterns.EMAIL_ADDRESS.matcher(email).matches()

fun isPasswordValid(password: String) = password.length >= 6

fun isPasswordCheckValid(pw: String, pwCheck: String) = (pw == pwCheck)
