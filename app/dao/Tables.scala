package dao
// AUTO-GENERATED Slick data model
/** Stand-alone Slick data model for immediate use */
object Tables extends {
  val profile = slick.driver.MySQLDriver
} with Tables

/** Slick data model trait for extension, choice of backend or usage in the cake pattern. (Make sure to initialize this late.) */
trait Tables {
  val profile: slick.driver.JdbcProfile
  import profile.api._
  import slick.model.ForeignKeyAction
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import slick.jdbc.{GetResult => GR}

  /** DDL for all tables. Call .create to execute. */
  lazy val schema: profile.SchemaDescription = User.schema
  @deprecated("Use .schema instead of .ddl", "3.0")
  def ddl = schema

  /** Entity class storing rows of table User
   *  @param name Database column name SqlType(TEXT)
   *  @param mail Database column mail SqlType(TEXT)
   *  @param password Database column password SqlType(TEXT)
   *  @param sex Database column sex SqlType(TEXT)
   *  @param height Database column height SqlType(DECIMAL)
   *  @param weight Database column weight SqlType(DECIMAL) */
  case class UserRow(name: String, mail: String, password: String, sex: String, height: scala.math.BigDecimal, weight: scala.math.BigDecimal)
  /** GetResult implicit for fetching UserRow objects using plain SQL queries */
  implicit def GetResultUserRow(implicit e0: GR[String], e1: GR[scala.math.BigDecimal]): GR[UserRow] = GR{
    prs => import prs._
    UserRow.tupled((<<[String], <<[String], <<[String], <<[String], <<[scala.math.BigDecimal], <<[scala.math.BigDecimal]))
  }
  /** Table description of table user. Objects of this class serve as prototypes for rows in queries. */
  class User(_tableTag: Tag) extends Table[UserRow](_tableTag, "user") {
    def * = (name, mail, password, sex, height, weight) <> (UserRow.tupled, UserRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(name), Rep.Some(mail), Rep.Some(password), Rep.Some(sex), Rep.Some(height), Rep.Some(weight)).shaped.<>({r=>import r._; _1.map(_=> UserRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column name SqlType(TEXT) */
    val name: Rep[String] = column[String]("name")
    /** Database column mail SqlType(TEXT) */
    val mail: Rep[String] = column[String]("mail")
    /** Database column password SqlType(TEXT) */
    val password: Rep[String] = column[String]("password")
    /** Database column sex SqlType(TEXT) */
    val sex: Rep[String] = column[String]("sex")
    /** Database column height SqlType(DECIMAL) */
    val height: Rep[scala.math.BigDecimal] = column[scala.math.BigDecimal]("height")
    /** Database column weight SqlType(DECIMAL) */
    val weight: Rep[scala.math.BigDecimal] = column[scala.math.BigDecimal]("weight")

    /** Index over (mail) (database name user_idx) */
    val index1 = index("user_idx", mail)
  }
  /** Collection-like TableQuery object for table User */
  lazy val User = new TableQuery(tag => new User(tag))
}
