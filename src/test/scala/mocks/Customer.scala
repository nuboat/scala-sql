package mocks

import in.norbor.yoda.annotations.{ColumnSchema, TableSchema}
import org.joda.time.DateTime

/**
  * Created by Peerapat A on Mar 22, 2017
  */
@TableSchema(name = "customers", pk = "id")
case class Customer(@ColumnSchema(name = "id") id: Long
                    , @ColumnSchema(name = "full_name"
                                  , dbType = "VARCHAR"
                                  , isUnique = false
                                  , defaultValue = "Somchai") name: String
                    , sex: Int
                    , born: DateTime
                    , created: DateTime)
