package ca.harneev

import ca.harneev.bean.Book
import ca.harneev.contract.ModelContract

/**
 * @author Harneev Sethi
 */
class ModelContractImpl : ModelContract {

    override fun getBookList(callback: ModelContract.Callback) {
        Thread(Runnable {
            Thread.sleep(5000)

            callback.onResult(listOf(Book("1", "John Snow"), Book("2", "Sansa Stark")))
        }).start()
    }
}