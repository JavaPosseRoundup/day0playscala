package models

import org.squeryl.{Schema, KeyedEntity}

case class Bar(name: String) extends KeyedEntity[Long] {
  val id: Long = 0
}

object AppDB extends Schema {
  val barTable = table[Bar]("BAR")
}