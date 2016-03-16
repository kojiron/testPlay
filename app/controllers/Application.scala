package controllers

import play.api._
import play.api.mvc._
import play.api.data.Form
import play.api.data.Forms._

import javax.inject.Inject
import play.api.libs.concurrent.Execution.Implicits.defaultContext
import play.api.libs.json.Json
import scala.concurrent.Future
import play.api.libs.json.Reads

class Application extends Controller {

  def index = Action {
//    Ok(views.html.index("Your new application is ready."))
    Ok(views.html.index())
  }

  def hello = Action {
    Ok("hello scala & play !!")
  }

  def page2 = Action {
    Ok(views.html.page2("引数1")("引数2")("引数3"))
  }


  def create = Action {
    Ok(Json.obj())
  }


//  case class User(nickname: String, email: String, password: String, sex: Int, height: Int, weight: Int)//, photo: Blob)
//  val form = Form(mapping("nickname" -> text, "email" -> text, "password" -> text, "sex" -> number, "height" -> number, "weight" -> number)(User.apply)(User.unapply))
  val form_nickname = Form( "nickname" -> text )
  val form_email = Form( "email" -> text )
  val form_password = Form( "password" -> text )
  val form_sex = Form( "sex" -> number )
//  val form_height = Form( "height" -> bigDecimal )
//  val form_weight = Form( "weight" -> bigDecimal )
  val form_height = Form( "height" -> number )
  val form_weight = Form( "weight" -> number )

  def made = Action { implicit request =>

//    val user: User = form.bindFromRequest.get

    val nickname = form_nickname.bindFromRequest.get
    val email = form_email.bindFromRequest.get
    val password = form_password.bindFromRequest.get
    val sex = form_sex.bindFromRequest.get
    val height = form_height.bindFromRequest.get
    val weight = form_weight.bindFromRequest.get

//    Ok(views.html.made("作成アカウント情報確認"))
//    Ok(views.html.made(nickname + height + email))
    Ok(views.html.made("作成アカウント情報確認", nickname, email, password, sex, height, weight))
  }

}
