package org.stephen.reactive

import jakarta.annotation.Resource
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.stephen.reactive.entity.User
import org.stephen.reactive.repo.UserRepo

@SpringBootTest
class UserCrudTest {

    @Resource
    lateinit var userRepo: UserRepo


    @Test
    fun testInsert() {
        val mono = userRepo.save(User( null,"stephen", "stephen@gmail.com"))
        mono.subscribe {
            println("输出结果$it")
        }
    }

}