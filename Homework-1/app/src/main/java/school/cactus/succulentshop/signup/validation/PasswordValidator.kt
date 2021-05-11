package school.cactus.succulentshop.signup.validation

import school.cactus.succulentshop.R
import school.cactus.succulentshop.validation.Validator

class PasswordValidator : Validator {
    override fun validate(field: String): Int? = when{
        field.isEmpty() -> R.string.password_is_required
        field.length <= 7 -> R.string.password_is_too_short
        field.length >= 40 -> R.string.password_is_too_long
        !field.any { it.isDigit() } -> R.string.Password_must_contain_one_digit_uppercase_lowercase_special_character
        !field.any { it.isLowerCase() } -> R.string.Password_must_contain_one_digit_uppercase_lowercase_special_character
        !field.any { it.isUpperCase() } -> R.string.Password_must_contain_one_digit_uppercase_lowercase_special_character
        field.all { it.isDigit() || it.isLowerCase() || it.isUpperCase() } -> R.string.Password_must_contain_one_digit_uppercase_lowercase_special_character
        else -> null
    }
}