package com.clevertrap.quizapp.start

import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.databinding.Bindable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.clevertrap.quizapp.R
import kotlinx.coroutines.launch


/*
 * Copyright 2021 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
class ViewModelStart: ViewModel() {

  var textMutable = MutableLiveData<String> ()
  val buttonClick = MutableLiveData<Boolean>()

  init {
    viewModelScope.launch {

      textMutable.value = "Enter data her"
    }
  }

  fun onStartClick() {
    Log.d("WASTE", "ButtonClicked: ${textMutable.value}")
    buttonClick.value = true
  }
}