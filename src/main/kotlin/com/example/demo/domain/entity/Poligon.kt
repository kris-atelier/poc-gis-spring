package com.example.demo.domain.entity

import javax.persistence.*

@Entity
@Table(name = "Poligon")
open class Poligon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gid", nullable = false)
    open var id: Int? = null

    @Column(name = "pnu", length = 19)
    open var pnu: String? = null

    @Column(name = "jibun", length = 100)
    open var jibun: String? = null

    @Column(name = "bchk", length = 1)
    open var bchk: String? = null

    @Column(name = "sgg_oid")
    open var sggOid: Double? = null

    @Column(name = "col_adm_se", length = 5)
    open var colAdmSe: String? = null
}