/*
 * Copyright (C) 2012 The Android Open Source Project
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

package com.example.android.lifecycle.util;

import android.os.Handler;
import android.widget.TextView;

import com.example.android.lifecycle.R;

import java.util.List;

public class Utils {

  /**
   * Helper method to print out the lifecycle state of each Activity.  Note this has
   * been wrapped in a Handler to delay the output due to overlaps in lifecycle state
   * changes as one Activity launches another.
   * @link http://developer.android.com/guide/topics/fundamentals/activities.html#CoordinatingActivities
   * @param mRestartCounterView TextView to list out the lifecycle methods called
   * @param restartCounter TextView to list out the status of all Activity classes
   */
  public static void printStatus(final TextView mRestartCounterView, final int restartCounter) {
      Handler handler = new Handler();
      handler.postDelayed(new Runnable() {
        public void run() {
            if(mRestartCounterView!=null) {
                mRestartCounterView.setText(Integer.toString(restartCounter));
            }
          }
      }, 750);
    }
}




