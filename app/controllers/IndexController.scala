package controllers

import play.api.mvc.Controller
import play.api.mvc.Action

/**
 * @author miyamoto
 */

class IndexController extends Controller{
  
  def index() = Action {
    Ok(views.html.index())
  }
}