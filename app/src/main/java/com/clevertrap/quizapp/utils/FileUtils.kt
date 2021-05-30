package com.clevertrap.quizapp.utils

import android.content.Context
import android.content.res.Resources
import android.util.Log
import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder


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
object FileUtils {

  fun readRaw(rawId: Int, resources: Resources): String {

    val reader = BufferedReader(InputStreamReader(resources.openRawResource(rawId)))
    val strBuilder = StringBuilder()
    try {
      var line = reader.readLine()
      while (line != null) {
        strBuilder.append(line)
        line = reader.readLine()
      }
    }finally {
      reader.close()
    }
    return strBuilder.toString()
  }
}