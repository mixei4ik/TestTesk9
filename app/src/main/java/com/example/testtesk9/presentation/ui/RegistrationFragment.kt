package com.example.testtesk9.presentation.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.testtesk9.R
import com.example.testtesk9.databinding.FragmentRegistrationBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class RegistrationFragment : Fragment(R.layout.fragment_registration) {

    private lateinit var binding: FragmentRegistrationBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentRegistrationBinding.bind(view)

        binding.signInButton.setOnClickListener {
            findNavController().navigate(
                R.id.action_registrationFragment_to_tradePageFragment
            )
        }

        binding.logInButton.setOnClickListener {
            findNavController().navigate(
                R.id.action_registrationFragment_to_loginFragment
            )
        }
    }
}