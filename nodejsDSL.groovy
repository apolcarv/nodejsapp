job('Aplicacion2 Node.js DSL') {
  	description('Job DSL de ejemplo para el curso de Jenkins')
  scm {
    git('https://github.com/apolcarv/jenkins.job.parametrizado.git','main') { node ->
      node / gitConfigName('apolcarv1')
      node / gitConfigEmail('alejandropolocarvajal@gmail.com')
    }
  }
  parameters {
      stringParam('nombre', defaultValue = 'Alejandro', description = 'Parametro de cadena para el job Booleano')
      choiceParam('planeta', ['Mercurio','venus','tierra','martes','jupiter','saturno','urano','neptuno'])
  	  booleanParam('agente', false)	
  }
  triggers {
      cron('H/7 * * * *')
  }
  steps {
     shell("npm install")
  }
  publishers {
      mailer('alejandropolocarvajal@gmail.com', true, true)
  }  
}
