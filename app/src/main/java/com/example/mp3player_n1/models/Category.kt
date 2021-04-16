package com.example.mp3player_n1.models

class Category {
    var name:String?=null
    var image:Int?=null
    var position:Int?=null

    constructor(name: String?, image: Int?,position:Int) {
        this.name = name
        this.image = image
        this.position = position
    }
}