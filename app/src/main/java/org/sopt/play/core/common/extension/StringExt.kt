package org.sopt.play.core.common.extension

import java.text.SimpleDateFormat
import java.util.Locale

fun String.toEpochMillis(): Long {
    val withoutFraction = replace(Regex("\\.\\d+"), "")
    val patterns = listOf("yyyy-MM-dd'T'HH:mm:ssXXX", "yyyy-MM-dd'T'HH:mm:ss")
    patterns.forEach { pattern ->
        runCatching {
            SimpleDateFormat(pattern, Locale.KOREA).parse(withoutFraction)?.time
        }.getOrNull()?.let { return it }
    }
    throw IllegalArgumentException("시간 형식을 변환할 수 없습니다: $this")
}
