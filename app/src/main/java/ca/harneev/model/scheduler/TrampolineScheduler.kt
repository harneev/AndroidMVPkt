package ca.harneev.model.scheduler

import io.reactivex.schedulers.Schedulers

/**
 * Trampoline executes all tasks in a FIFO manner on one of the participating threads
 *
 * @author Harneev Sethi
 */
class TrampolineScheduler : BaseScheduler {
    override fun computation() = Schedulers.trampoline()
    override fun ui() = Schedulers.trampoline()
    override fun io() = Schedulers.trampoline()
}