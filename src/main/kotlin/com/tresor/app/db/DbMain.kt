package com.tresor.app.db

fun main(args: Array<String>) {
    DbMigration(Db.tresor).migrate()
}