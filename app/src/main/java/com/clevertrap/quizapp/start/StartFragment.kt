package com.clevertrap.quizapp.start

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.clevertrap.quizapp.R
import com.clevertrap.quizapp.databinding.FragmentStartBinding
import com.clevertrap.quizapp.extensions.fragmentBinding
import com.clevertrap.quizapp.extensions.getViewModel

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class StartFragment : Fragment() {

  private val viewModelStart by lazy { getViewModel<ViewModelStart>() }

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    // Inflate the layout for this fragment
    val binding = fragmentBinding<FragmentStartBinding>(inflater, R.layout.fragment_start, container, false)
    binding.viewModel = viewModelStart
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    viewModelStart.buttonClick.observe(viewLifecycleOwner, buttonClickObserver())
  }

  fun navigate() {
    findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
  }

  private fun buttonClickObserver(): Observer<Boolean> {
    return Observer<Boolean> {
      navigate()
    }
  }
}