package com.example.exercise_ui_thread

import android.app.ProgressDialog
import android.os.AsyncTask
import android.widget.ProgressBar
import org.json.JSONArray
import java.net.HttpURLConnection
import java.net.URL


class ProgressDialogTask(var progressDialog: ProgressDialog): AsyncTask<Unit, Unit, Unit>(){
    override fun onPreExecute() {
        progressDialog.show()
    }

    override fun doInBackground(vararg p0: Unit?) {
        for (i in 1..100){
            Thread.sleep(50)
        }
    }

    override fun onPostExecute(result: Unit?) {
        progressDialog.dismiss()
    }
}

class ProgressBarTask(var progressBar: ProgressBar): AsyncTask<Unit, Unit, Unit>(){
    //Unit pertama untuk input, kedua untuk onprogress update, ketiga untuk return
    override fun doInBackground(vararg p0: Unit?) {
        for (i in 1..100){
            progressBar.progress=i
            Thread.sleep(50)
        }
    }

    override fun onProgressUpdate(vararg values: Unit?) {
        super.onProgressUpdate(*values)
    }
}

class ProgressThread(var progressBar: ProgressBar):Thread(){
    override fun run() {
        for (i in 1..100){
            progressBar.progress=i
            Thread.sleep(200)
            i
        }
    }
}

class FetchDataTask: AsyncTask<Unit,Unit,Unit>(){
    override fun doInBackground(vararg p0: Unit?) {
//        val url = URL("http://10.0.2.2:8080/rooms")
        val url = URL("https://jsonplaceholder.typicode.com/users")
        val urlConnection =  url.openConnection() as HttpURLConnection
        urlConnection.requestMethod = "GET"
        val response = urlConnection.inputStream.bufferedReader().readText()
//        println(response)
        val jsonArray = JSONArray(response)
        println(jsonArray.getJSONObject(0).getJSONObject(""))

//        val stringResponse = url.readText()
//        println(stringResponse)
    }

}