package com.cxsplay.chartdemo.bean

/**
 * Created by chuxiaoshan on 2019/12/3 10:24.
 *
 */
class Simple {
    var id: String? = null
    var name: String? = null

    constructor(id: String?, name: String?) {
        this.id = id
        this.name = name
    }

    constructor()

    override fun toString(): String {
        return "Simple(id=$id, name=$name)"
    }
}