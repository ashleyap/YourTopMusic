package uca.edu.yourtopmusic.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_first.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import uca.edu.yourtopmusic.R
import uca.edu.yourtopmusic.intent.Intent
import uca.edu.yourtopmusic.ui.MainViewModel
import uca.edu.yourtopmusic.utils.AdapterDiscografia
import uca.edu.yourtopmusic.utils.DataState
import javax.inject.Inject

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class MainFragment
constructor(): Fragment(R.layout.fragment_first) {
    private val TAG: String = "AppDebug"

    private val viewModel: MainViewModel by viewModels()

    @Inject
    lateinit var  adapterDiscografia: AdapterDiscografia

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupDataState()
        val layoutManager = LinearLayoutManager(requireActivity().applicationContext, LinearLayoutManager.VERTICAL, true)
        layoutManager.stackFromEnd = true
        rv_discografia.layoutManager = layoutManager
        rv_discografia.adapter = adapterDiscografia

        lifecycleScope.launch {
            viewModel.userIntent.send(Intent.GetDiscografiaEvent)
        }
    }

    private fun setupDataState(){
        lifecycleScope.launch {
            viewModel.dataState.collect {
                when (it){
                    is DataState.Success -> {
                        displayProgressBar(false)
                        displayError("")
                        adapterDiscografia.setDiscografia(it.discografia)
                    }
                    is DataState.Error -> {
                        displayProgressBar(false)
                        displayError(it.exception.toString())
                    }
                    is DataState.Loading -> {
                        displayProgressBar(true)
                    }
                }
            }
        }
    }

    private fun displayError(message: String){
        if(message != null) tv_error.text = message else tv_error.text = "Unknown error."
    }

    private fun displayProgressBar(isDisplayed: Boolean){
        progress_bar.visibility = if (isDisplayed) View.VISIBLE else View.GONE
    }
}