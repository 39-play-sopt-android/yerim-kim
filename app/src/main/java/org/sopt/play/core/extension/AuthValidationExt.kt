package org.sopt.play.core.extension

const val EMAIL_REGEX = "^[\\w.-]+@([\\w\\-]+\\.)+[a-z]{2,}$"

fun isEmailValid(email: String) = email.matches(EMAIL_REGEX.toRegex())

fun isPasswordValid(password: String) = password.length >= 6

fun isPasswordCheckValid(pw: String, pwCheck: String) = (pw == pwCheck)
