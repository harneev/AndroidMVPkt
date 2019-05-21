package ca.harneev.model.scheduler

import io.reactivex.Scheduler

/**
 * @author Harneev Sethi
 */
interface BaseScheduler {
    fun io(): Scheduler
    fun computation(): Scheduler
    fun ui(): Scheduler
}