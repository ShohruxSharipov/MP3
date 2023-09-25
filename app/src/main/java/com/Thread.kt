package com

import android.util.Log
import java.lang.Thread

class Thread:Thread() {
    override fun run() {
        super.run()
        Log.d("TAG", "run: 123454")
    }
}