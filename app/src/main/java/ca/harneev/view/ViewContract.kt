package ca.harneev.view

import ca.harneev.bean.Book

/**
 * @author Harneev Sethi
 */
interface ViewContract {

    fun showBookList(bookList: List<Book>)

    fun showError(errorMessage:String)
}