package com.clevertrap.quizapp.extensions

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


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

fun <T: ViewDataBinding> Fragment.fragmentBinding(inflater: LayoutInflater,
                                                  layoutId: Int,
                                                  parent: ViewGroup?,
                                                  attachedToRoot: Boolean): T {
  val t = DataBindingUtil.inflate<T>(inflater, layoutId, parent, attachedToRoot)
  // To release databinding when activity is released.
  t.lifecycleOwner = this
  return t
}

inline fun<reified T: ViewModel> Fragment.getViewModel(): T {
  return ViewModelProvider(this).get(T::class.java)
}