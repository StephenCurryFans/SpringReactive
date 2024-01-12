package org.stephen.reactive.entity


import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table



@Table("t_user")
data class User(@Id var id: Int?, var name: String, var email: String)

