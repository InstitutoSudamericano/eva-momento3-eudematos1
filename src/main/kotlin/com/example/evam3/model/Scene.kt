package com.example.evam3.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.math.BigDecimal


@Entity
@Table(name = "scene")

class Scene{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var description: String? = null
    var budget: BigDecimal? = null
    var minutes: Long? = null
    @Column (name="film_id")
    var filmid: Long? = null
}
