package com.example.garagemanagmentapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import com.example.garagemanagmentapp.databinding.FragmentLoginBinding
import com.google.android.material.textfield.TextInputEditText


class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentLoginBinding.inflate(inflater, container, false)

        val view = _binding!!.root
        val binding = _binding!!

        binding.loginTiePassword.setOnFocusChangeListener { _, hasFocus ->
            run {
                if (hasFocus) {
                    binding.loginTilPassword.error = ""
                }
            }
        }
        //texto añadido donde co mprabamos que el edit text tiene suçize caracteres
        binding.loginTiePassword.addTextChangedListener {
            val size = it!!.length
            if (size < 6) {
                binding.loginTilPassword.error = "La contraseña tiene que tener $size/6"
            } else {
                binding.loginTilPassword.error = ""
            }
        }

        binding.loginTiePassword.setOnClickListener {
            val textInputEditText = it as TextInputEditText //Casteo


            //Recupermaos el texto del edit text lo convertimnos en string y comprobamos su longuitud
            val size = textInputEditText.text.toString().length
            if (size < 6) {
                binding.loginTilPassword.error = "La contraseña tiene que tener $size/6"
            }else {
                binding.loginTilPassword.error = ""
            }
        }

        binding.loginBtnLogin.setOnClickListener {
            val editPassword= binding.loginTiePassword
            val password = editPassword.text

            if(password.isNullOrBlank()){
                binding.loginTilPassword.error= getString(R.string.error_blank)
                return@setOnClickListener
            }
        }



        return view
    }


}