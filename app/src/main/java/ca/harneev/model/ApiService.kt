package ca.harneev.model

import ca.harneev.bean.Book
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET

/**
 * @author Harneev Sethi
 */
interface ApiService  {

    @GET("api/json/est/now")
    fun getBooks():Single<Book>
}