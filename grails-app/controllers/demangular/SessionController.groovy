package demangular

import com.unboundid.ldap.sdk.*

class SessionController {
	static allowedMethods = [login: "POST", index: "GET", logout: "DELETE"]

	def index() { }

    def create() { 
    	//recuperation des parametres de la requete (login & password)
    	String login = params.login
    	String password = params.password
        try{
           //recuperation de l'adresse du serveur ldap et de son port via le fichier application.yml
           String host = grailsApplication.config.getProperty('config.ldap.host',String)
           Integer port = grailsApplication.config.getProperty('config.ldap.port',Integer)
           //connexion au ldap avec unboundid
    	   LDAPConnection connection = new LDAPConnection(host,port)
    	   //recuperation du string de filtre pour le bind dans application.yml
    	   String bindFilter = grailsApplication.config.getProperty('config.ldap.bind-filter',String)
    	   //utilisation d'un moteur de template afin de reconstruire le filtre de binding avec les parametres de la requete
    	   def binding = ["login":login]
    	   def engine = new groovy.text.SimpleTemplateEngine()
    	   def template = engine.createTemplate(bindFilter).make(binding)
    	   BindResult bindResult = connection.bind(template.toString(),password)
    	   if (bindResult.resultCode == ResultCode.SUCCESS){
    		  session["login"] = login
    		  render(view:'/index')
    	   }else{
    		  log.error "failure"
              flash.message = "Error authenticating"
    		  redirect(controller: "session", action: "new")
    	   }
        }catch(Exception e){
        	log.error e.message
            flash.message = e.message
            redirect(controller: "session", action: "new")
        }
    }

    def destroy() { 
        session["login"] = null
        redirect(controller: "session", action: "create")
    }
}
