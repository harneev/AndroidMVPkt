package ca.harneev.contract

import ca.harneev.bean.Book

/**
 * @author Harneev Sethi
 */
interface ModelContract {

    fun getBookList(callback: Callback)

    interface Callback {

        fun onResult(bookList:List<Book>)
    }
}