package com.clevertrap.quizapp.data

import android.content.Context
import com.clevertrap.quizapp.R
import com.clevertrap.quizapp.utils.FileUtils
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import java.io.BufferedReader


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
object Constants {

  fun getQuestions(str: String): Quiz {
      return GsonBuilder().create().fromJson(str, Quiz::class.java)
  }
}