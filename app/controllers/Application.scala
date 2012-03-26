package controllers

import play.api.mvc._
import models.Bar
import scala.collection.mutable.ArrayBuffer

import com.codahale.jerkson.Json
import play.api.data.Form
import play.api.data.Forms.{mapping, text, optional}

object Application extends Controller {
  
  var bars = ArrayBuffer[Bar]()
  
  val barForm = Form(
    mapping(
      "id" -> optional(text),
      "name" -> text
    )(Bar.apply)(Bar.unapply)
  )

  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }
  
  def listBars = Action {
    Ok(Json.generate(bars)).as(JSON)
  }

  def addBar = Action { implicit request =>
    barForm.bindFromRequest.fold(
      errors => BadRequest,
      bar => {
          bars += bar
          Redirect(routes.Application.index())
      }
    )
  }
  
}