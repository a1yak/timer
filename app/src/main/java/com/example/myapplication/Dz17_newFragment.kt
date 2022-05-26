package com.example.myapplication

import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.myapplication.databinding.FragmentDz17NewBinding


class Dz17_newFragment : Fragment() {
    private var _binding: FragmentDz17NewBinding? = null
    private val binding get() = _binding!!
    private var timer: CountDownTimer? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDz17NewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        binding.btnBegin.setOnClickListener {
            startTimer(binding.secondsReceiver.text.toString().toInt())
        }
    }

    fun startTimer(seconds: Int) {
        timer = object : CountDownTimer(seconds*1000.toLong(), 1000) {
            override fun onTick(millisUntilFinished: Long) {
                binding.secondsReceiver.setText((millisUntilFinished / 1000).toString())
            }

            override fun onFinish() {
               Toast.makeText(context, "Finished", Toast.LENGTH_LONG).show()
            }
        }.start()
    }

    companion object {

        fun newInstance() =
           Dz17_newFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}





