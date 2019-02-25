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

package com.example.android.lifecycle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.android.lifecycle.util.Utils;

/**
 * Example Activity to demonstrate the lifecycle callback methods.
 */
public class ActivityB extends Activity {

    private int mRestartCounter = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        mRestartCounter = getIntent().getIntExtra("RESTART_COUNTER", 0);
        mRestartCounter++;
        getIntent().putExtra("RESTART_COUNTER", mRestartCounter);
    }

    public void startDialog(View v) {
        Intent intent = new Intent(ActivityB.this, DialogActivity.class);
        startActivity(intent);
    }

    public void finishActivityB(View v) {
        Intent newintent = new Intent();
        mRestartCounter = getIntent().getIntExtra("RESTART_COUNTER", 0);
        newintent.putExtra("RESTART_COUNTER", mRestartCounter);
        setResult(RESULT_OK, newintent);
        ActivityB.this.finish();
    }
}
