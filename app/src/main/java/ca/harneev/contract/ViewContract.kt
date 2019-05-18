package ca.harneev.contract

import ca.harneev.bean.Book

/**
 * @author Harneev Sethi
 */
interface ViewContract {

    fun showBookList(bookList: List<Book>)
}