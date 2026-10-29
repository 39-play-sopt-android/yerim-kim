package org.sopt.play.presentation.auth.register

import androidx.annotation.StringRes
import org.sopt.play.core.base.BaseUiState

data class RegisterUiState(
    val name: String = "",
    val email: String = "",
    val password: String = "",
    val passwordCheck: String = "",
    @param:StringRes val emailError: Int? = null,
    @param:StringRes val passwordError: Int? = null,
    @param:StringRes val passwordCheckError: Int? = null,
) : BaseUiState {
    val isRegisterEnabled: Boolean
        get() = name.isNotEmpty() &&
                email.isNotEmpty() &&
                password.isNotEmpty() &&
                passwordCheck.isNotEmpty() &&
                emailError == null &&
                passwordError == null &&
                passwordCheckError == null
}
