package ca.harneev

import ca.harneev.bean.Book
import ca.harneev.model.ApiService
import ca.harneev.model.NetworkService
import ca.harneev.view.ViewContract
import ca.harneev.model.scheduler.BaseScheduler
import ca.harneev.model.scheduler.SimpleScheduler
import java.util.concurrent.TimeUnit

/**
 * @author Harneev Sethi
 */
class Presenter(val view:ViewContract, val service: ApiService, private val scheduler: BaseScheduler = SimpleScheduler()) {

    fun getBookList() {
        service.getBooks()
            .delay(3000, TimeUnit.MILLISECONDS, scheduler.io())
            .observeOn(scheduler.ui())
            .subscribeOn(scheduler.io())
            .subscribe({ result ->
                view.showBookList(listOf(Book("1", "John Snow"), Book("2", "Sansa Stark")))
            },
                { error ->
                    error.message?.let { view.showError(it) }
                })
    }
}