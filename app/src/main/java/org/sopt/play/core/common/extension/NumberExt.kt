package org.sopt.play.core.common.extension

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun Long.toDateString(): String =
    SimpleDateFormat("yyyy.MM.dd", Locale.getDefault()).format(Date(this))