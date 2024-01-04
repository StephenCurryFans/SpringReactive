package org.stephen.reactive.repo

import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.stephen.reactive.entity.User

interface UserRepo: ReactiveCrudRepository<User,Int>