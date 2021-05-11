package school.cactus.succulentshop.signup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.textfield.TextInputLayout
import school.cactus.succulentshop.R
import school.cactus.succulentshop.databinding.FragmentSignupBinding
import school.cactus.succulentshop.signup.validation.EmailValidator
import school.cactus.succulentshop.signup.validation.IdentifierValidator
import school.cactus.succulentshop.signup.validation.PasswordValidator

class SignupFragment: Fragment(){

    private var _binding: FragmentSignupBinding? = null

    private val binding get() = _binding!!

    private val signupEmailValidator = EmailValidator()
    private val signupIdentifierValidator = IdentifierValidator()
    private val signupPasswordValidator = PasswordValidator()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSignupBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        requireActivity().title = getString(R.string.sign_up)

        binding.apply {
            signUpButton.setOnClickListener {
                if (signupEmailInputLayout.validate() and signupUsernameInputLayout.validate() and signupPasswordInputLayout.validate()){
                    findNavController().navigate(R.id.signupSuccessful)
                }
            }

            haveAnAccountButton.setOnClickListener {
                findNavController().navigate(R.id.haveAnAccount)
            }
        }
    }

    private fun TextInputLayout.validate() :Boolean{
        val errorMessage = validator().validate(editText!!.text.toString())
        error = errorMessage?.resolveAsString()
        isErrorEnabled = errorMessage != null
        return errorMessage == null
    }

    private fun Int.resolveAsString() = getString(this)

    private fun TextInputLayout.validator() = when (this) {
        binding.signupEmailInputLayout -> signupEmailValidator
        binding.signupUsernameInputLayout -> signupIdentifierValidator
        binding.signupPasswordInputLayout -> signupPasswordValidator
        else -> throw IllegalArgumentException("Cannot find any validator for the given TextInputLayout")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}