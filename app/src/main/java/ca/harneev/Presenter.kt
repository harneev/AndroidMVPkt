package ca.harneev

import ca.harneev.bean.Book
import ca.harneev.contract.ModelContract
import ca.harneev.contract.ViewContract

/**
 * @author Harneev Sethi
 */
class Presenter(val view:ViewContract, val model:ModelContract) {

    fun getBookList() {
        model.getBookList(ModelListener())
    }

    inner class ModelListener:ModelContract.Callback {

        override fun onResult(bookList: List<Book>) {
            view.showBookList(bookList)
        }
    }

}