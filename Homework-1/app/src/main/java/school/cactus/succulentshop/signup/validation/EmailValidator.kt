package school.cactus.succulentshop.signup.validation

import school.cactus.succulentshop.R
import school.cactus.succulentshop.validation.Validator

class EmailValidator : Validator {
    override fun validate(field: String): Int? = when{
        field.isEmpty() -> R.string.email_is_required
        !(field.contains("@") && field.contains(".")) -> R.string.email_is_invalid
        field.length !in 6..49 -> R.string.email_is_invalid
        else -> null
    }
}