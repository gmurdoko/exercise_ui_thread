package com.example.exercise_ui_thread

import android.app.ProgressDialog
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    lateinit var progressDialog: ProgressDialog
    lateinit var coroutineScope: CoroutineScope

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        progress_bar.max = 100
        coroutineScope = CoroutineScope(Dispatchers.IO)
        progressDialog = ProgressDialog(this)
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER)
    }

    fun button_start_progress_bar(view: View) {
// THREAD
//        val progressThread = ProgressThread(progress_bar)
//        progressThread.start()
// ASYNC TASK
//        val progressBarTask =ProgressBarTask(progress_bar)
//        progressBarTask.execute()
// ASYNC
//        val progressDialogTask = ProgressDialogTask(progressDialog)
//        progressDialogTask.execute()
        //CO ROUTINE
        //IO Fetching
//        coroutineScope.cancel()
//        println(coroutineScope.isActive)
//        if(coroutineScope.isActive == true) {
//            coroutineScope.cancel()
//            println(coroutineScope.isActive)
//        } else {
//            coroutineScope.launch {
//                for (i in 1..100){
//                    progress_bar.setProgress(i)
//                    delay(50)
//                }
//                coroutineScope.cancel()
//            }
//        }
        //FETCHING
        val fetchDataTask = FetchDataTask()
        fetchDataTask.execute()
    }
}
