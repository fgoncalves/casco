package com.github.fgoncalves.casco.presentation.home

import com.github.fgoncalves.casco.R
import com.github.fgoncalves.casco.databinding.HomeBinding
import com.github.fgoncalves.casco.presentation.base.BaseFragment

class HomeScreen : BaseFragment<HomeViewModel, HomeBinding>() {
    override val viewModelClass: Class<HomeViewModel> = HomeViewModel::class.java

    override val layoutResId: Int = R.layout.home

    override fun applyBindings(binding: HomeBinding) {
        binding.viewModel = viewModel
    }
}
