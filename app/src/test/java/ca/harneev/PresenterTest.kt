package ca.harneev

import ca.harneev.bean.Book
import ca.harneev.model.ApiService
import ca.harneev.view.ViewContract
import ca.harneev.model.scheduler.TrampolineScheduler
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.*
import com.nhaarman.mockitokotlin2.argumentCaptor
import com.nhaarman.mockitokotlin2.given
import io.reactivex.Single
import org.junit.Assert
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

/**
 * @author Harneev Sethi
 */
@RunWith(RobolectricTestRunner::class)
@Config(manifest = Config.NONE)
class PresenterTest {

    @Mock
    lateinit var service: ApiService

    @Mock
    lateinit var view: ViewContract

    lateinit var presenter: Presenter

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)

        presenter = Presenter(view, service, TrampolineScheduler())
    }

    @Test
    fun `test if books are displayed`() {
        // given
        given(service.getBooks()).willReturn(Single.just(Book("1", "John Snow")))

        // when
        presenter.getBookList()

        // then
        val captor = argumentCaptor<List<Book>>()
        Mockito.verify(view).showBookList(captor.capture())
        Assert.assertEquals(2, captor.firstValue.size)
    }
}