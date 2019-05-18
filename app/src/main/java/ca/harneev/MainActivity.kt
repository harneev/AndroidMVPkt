package ca.harneev

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import ca.harneev.bean.Book
import ca.harneev.contract.ViewContract

class MainActivity : AppCompatActivity() {

    lateinit var presenter:Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = Presenter(ViewContractImpl(), ModelContractImpl())
        presenter.getBookList()
    }

    private fun drawBookList(bookList: List<Book>) {

        val mainLayout = findViewById<LinearLayout>(R.id.main_content_area)

        for (book in bookList) {

            val textView = TextView(this)
            textView.text = book.name

            mainLayout.addView(textView)
        }
    }

    inner class ViewContractImpl:ViewContract {

        override fun showBookList(bookList: List<Book>) {

            this@MainActivity.runOnUiThread(Runnable {
                drawBookList(bookList)
            })
        }
    }
}
