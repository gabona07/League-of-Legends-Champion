package com.example.leagueoflegends.model

data class Response(val data: Map<String, Champion>) {
    data class Champion(val id: String, val name: String, val title: String, val blurb: String, val image: Image) {
        data class Image(val full: String)
    }
}