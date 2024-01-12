package org.stephen.reactive.controller

import org.springframework.web.bind.annotation.*
import org.stephen.reactive.entity.User
import org.stephen.reactive.repo.UserRepo
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/user")
class HelloController(private val userRepo: UserRepo) {


    @PostMapping("/save")
    fun saveUser(@RequestBody user: User) = userRepo.save(user)

    @GetMapping("/all")
    fun findAll() = userRepo.findAll()


    @GetMapping("/{id}")
    fun findUserById(@PathVariable("id") id: Int): () -> Mono<User> = {
        if(id< 0){
            // 返回错误信息
            throw RuntimeException("id不能小于0")
        }
        userRepo.findById(id)
    }

}