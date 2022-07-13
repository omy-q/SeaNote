package com.example.seanote.base

class SeaNoteBasePresenter<T : SeaNoteBaseView> {
    protected var view: T? = null

    open fun attachView(view: T) {
        this.view = view
    }

    open fun detachView() {
        view = null
    }
}