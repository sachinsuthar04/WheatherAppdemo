package com.sachin.weathear.ui.activity

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.sachin.weathear.R
import com.sachin.weathear.base.BaseActivity
import com.sachin.weathear.databinding.ActivityMainBinding
import com.sachin.weathear.ui.viewmodle.MainViewModel
import com.sachin.weathear.utils.ViewModelFactory
import com.google.android.material.snackbar.Snackbar
import kotlin.math.roundToInt

class MainActivity : BaseActivity() {

    lateinit var mDatabinding: ActivityMainBinding
    lateinit var viewModel: MainViewModel
    private var errorSnackbar: Snackbar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mDatabinding = DataBindingUtil.setContentView(this, R.layout.activity_main)


        viewModel = ViewModelProviders.of(this, ViewModelFactory(this))
            .get(MainViewModel::class.java)
        viewModel.errorMessage.observe(this, Observer { errorMessage ->
            if (errorMessage != null) showError(errorMessage) else hideError()
        })

        viewModel.loadingVisibility.observe(this, Observer {
            if (viewModel.loadingVisibility.value == 8) {
                mDatabinding.tvCity.text = viewModel.response.city.name

                mDatabinding.tvTempr.text =  (viewModel.response.list[0].main.temp).roundToInt().toString()+" C"
                mDatabinding.tvWeatherType.text = viewModel.response.list[0].weather[0].main
                viewModel.response.list.forEach {

                }
            }
        })

        mDatabinding.viewModel = viewModel

    }


    private fun showError(errorMessage: String) {
        errorSnackbar = Snackbar.make(mDatabinding.root, errorMessage, Snackbar.LENGTH_INDEFINITE)
        errorSnackbar?.setAction("Retry", viewModel.errorClickListener)
        errorSnackbar?.show()
    }

    private fun hideError() {
        errorSnackbar?.dismiss()
    }
}
