import org.squeryl.adapters.H2Adapter
import org.squeryl.{Session, SessionFactory}
import play.api.db.DB
import play.api.GlobalSettings

import play.api.Application

object Global extends GlobalSettings {

  override def onStart(app: Application) {

    SessionFactory.concreteFactory = Some(() =>
      Session.create(
        DB.getConnection()(app),
        new H2Adapter))
  }

}
