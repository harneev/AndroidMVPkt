package ca.harneev

import ca.harneev.bean.Book
import ca.harneev.contract.ModelContract
import ca.harneev.contract.ViewContract
import com.nhaarman.mockitokotlin2.any
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.*
import org.mockito.junit.MockitoJUnitRunner
import com.nhaarman.mockitokotlin2.argumentCaptor
import org.junit.Assert
import org.mockito.ArgumentMatchers.anyObject

/**
 * @author Harneev Sethi
 */
@RunWith(MockitoJUnitRunner::class)
class PresenterTest {

    @Mock
    lateinit var model: ModelContract

    @Mock
    lateinit var view: ViewContract

    lateinit var presenter: Presenter

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)

        presenter = Presenter(view, model)
    }

    @Test
    fun `test if books are displayed`() {
        // given
        Mockito.`when`(model.getBookList(any())).then {
            view.showBookList(
                arrayListOf(
                    Book("1", "Ice and Fire"),
                    Book("2", "Harry Potter")
                )
            )
        }

        // when
        presenter.getBookList()

        // then
        val captor = argumentCaptor<List<Book>>()
        Mockito.verify(view).showBookList(captor.capture())
        Assert.assertEquals(2, captor.firstValue.size)
    }
}