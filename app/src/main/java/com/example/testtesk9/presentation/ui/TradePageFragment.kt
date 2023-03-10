package com.example.testtesk9.presentation.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.testtesk9.R
import com.example.testtesk9.databinding.FragmentTradePageBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TradePageFragment : Fragment(R.layout.fragment_trade_page) {

    private lateinit var binding: FragmentTradePageBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentTradePageBinding.bind(view)

    }
}