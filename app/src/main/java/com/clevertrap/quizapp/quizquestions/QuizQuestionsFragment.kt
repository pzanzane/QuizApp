package com.clevertrap.quizapp.quizquestions

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.clevertrap.quizapp.R
import com.clevertrap.quizapp.data.Quiz
import com.clevertrap.quizapp.databinding.FragmentQuizQuestionBinding
import com.clevertrap.quizapp.extensions.fragmentBinding
import com.clevertrap.quizapp.extensions.getViewModel
import com.clevertrap.quizapp.utils.FileUtils
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class QuizQuestionsFragment : Fragment() {

  val viewModelQuizQuestion by lazy { getViewModel<ViewModelQuizQuestion>() }

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    // Inflate the layout for this fragment
    val binding = fragmentBinding<FragmentQuizQuestionBinding>(R.layout.fragment_quiz_question, container)
    binding.viewModel = viewModelQuizQuestion
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    viewModelQuizQuestion.backButtonClick.observe(viewLifecycleOwner, Observer {
      findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
    })

    viewModelQuizQuestion.loadQuestions(R.raw.questions, resources)
    viewModelQuizQuestion.quiz.observe(viewLifecycleOwner, Observer {
      Log.d("WASTE", "Questions Parsed: ${it.questions}")
    })
  }
}