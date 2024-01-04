package org.stephen.reactive.controller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.stephen.reactive.entity.User
import org.stephen.reactive.repo.UserRepo

@RestController
@RequestMapping("/hello")
class HelloController(private val userRepo: UserRepo) {


    @PostMapping("/save")
    fun saveUser(user: User) = userRepo.save(user)

}