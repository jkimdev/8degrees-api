package com.jimmy.dao

import kotlinx.coroutines.*
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.experimental.*

object DatabaseFactory {
    fun init() {
        val driverClassName = "org.mariadb.jdbc.Driver"
        val jdbcURL = "jdbc:mariadb://host.docker.internal:3306/8degrees"
        val user = "root"
        var password = "dev@308"
        Database.connect(jdbcURL, driverClassName, user, password)
//        transaction(database) {
//            SchemaUtils.create(Performances)
//        }
    }
}

suspend fun <T> dbQuery(block: suspend () -> T): T =
    newSuspendedTransaction(Dispatchers.IO) { block() }