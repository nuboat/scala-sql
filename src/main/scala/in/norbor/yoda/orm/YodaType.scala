package in.norbor.yoda.orm

import scala.reflect.runtime.universe._


/**
  * @author Peerapat A on April 18, 2018
  */
object YodaType extends Enumeration {
  type SchemaType = Value

  val Boolean: Value = Value(0)
  val JBoolean: Value = Value(1, "Boolean")
  val Int: Value = Value(2)
  val JInt: Value = Value(3, "Integer")
  val Integer: Value = Value(4, "Integer")
  val Long: Value = Value(5)
  val JLong: Value = Value(6, "Long")
  val Double: Value = Value(7)
  val JDouble: Value = Value(8, "Double")
  val Float: Value = Value(9)
  val JFloat: Value = Value(10, "Float")
  val String: Value = Value(11)
  val JBcrypt: Value = Value(12, "JBcrypt")
  val Blob: Value = Value(13)
  val Timestamp: Value = Value(14)
  val DateTime: Value = Value(15)
  val BytesArray: Value = Value(16, "Blob")

  def of(sym: MethodSymbol): SchemaType = sym.info.toString
    .replace("scala.", "")
    .replace("java.lang.", "")
    .replace("in.norbor.yoda.jtype.", "") match {

    case "=> Boolean" => Boolean
    case "=> JBoolean" => JBoolean
    case "=> Int" => Int
    case "=> JInt" => JInt
    case "=> Integer" => Integer
    case "=> Long" => Long
    case "=> JLong" => JLong
    case "=> Double" => Double
    case "=> JDouble" => JDouble
    case "=> Float" => Float
    case "=> JFloat" => JFloat
    case "=> String" => String
    case "=> JBcrypt" => JBcrypt
    case "=> java.sql.Blob" => Blob
    case "=> java.sql.Timestamp" => Timestamp
    case "=> org.joda.time.DateTime" => DateTime
    case "=> Array[Byte]" => BytesArray
    case _ => throw new IllegalArgumentException(s"Does not support ${sym.info.toString}")
  }

}