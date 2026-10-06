package org.sopt.play.core.extension

fun isEmailValid(email: String) : Boolean {
    val emailRegex = "^[\\w.-]+@([\\w\\-]+\\.)+[a-z]{2,4}$"
    return email.matches(emailRegex.toRegex())
}

fun isPasswordValid(password: String) = password.length >= 6

fun isPasswordCheckValid(pw: String, pwCheck: String) = (pw == pwCheck)
