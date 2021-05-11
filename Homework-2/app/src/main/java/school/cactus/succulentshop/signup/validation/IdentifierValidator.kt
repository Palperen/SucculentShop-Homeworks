package school.cactus.succulentshop.signup.validation

import school.cactus.succulentshop.R
import school.cactus.succulentshop.validation.Validator

class IdentifierValidator : Validator {
    override fun validate(field: String): Int? = when{
        field.isEmpty() -> R.string.username_is_required
        !field.all { it.isLowerCase() || it.isDigit() || it == '_' } -> R.string.username_can_only_include
        field.length <= 2 -> R.string.username_is_too_short
        field.length >= 20 -> R.string.username_is_too_long
        else -> null
    }
}