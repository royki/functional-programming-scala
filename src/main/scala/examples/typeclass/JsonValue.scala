package examples.typeclass

/**
 * Represents an ADT for Json. (Limited functionality)
 */
sealed trait JsonValue
case class JsonObject  (entries: Map[String, JsonValue]) extends JsonValue
case class JsonArray   (entries: Seq[JsonValue])         extends JsonValue
case class JsonString  (value: String)                   extends JsonValue
case class JsonNumber  (value: BigDecimal)               extends JsonValue
case class JsonBoolean (value: Boolean)                  extends JsonValue
case class JsonNull    ()                                extends JsonValue

/**
 *
 * Converts input into string representation of Json
 *
 */
object JsonWriter {

  def write(value: JsonValue): String = {

    value match {

      case JsonObject(entries) => {
        val serializedEntries = for ( (key, value) <- entries ) yield "\"" + key + "\"" + ": " + write(value)
        s"{ ${serializedEntries.mkString(", ")} }"
      }

      case JsonArray(entries)  => {
        val serializedEntries = entries map write
        s"[ ${serializedEntries.mkString(",")} ]"
      }

      case JsonString(value)   => "\"" + value + "\""
      case JsonNumber(value)   => value.toString()
      case JsonBoolean(value)  => value.toString
      case JsonNull()          => "null"
    }
  }

  /**
   * Converts a given type[T: Json] to Json representation of String
   * using type class pattern. Its sort of like an implicit adapter pattern.
   *
   * @param a
   * @tparam A
   * @return a Json String
   */
  def write[A: Json](a: A): String = {
    val convertible: Json[A] = implicitly[Json[A]]

    write(convertible.json(a))
  }

}