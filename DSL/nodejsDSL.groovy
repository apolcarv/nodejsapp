job('Aplicacion Node.js DSL') {
  	description('Aplicación Node JS DSL para el curso de Jenkins')
    scm {
       git('https://github.com/apolcarv/nodejsapp.git','master') { node ->
           node / gitConfigName('apolcarv')
           node / gitConfigEmail('alejandropolocarvajal@gmail.com')
        }
    }
    triggers {
        scm('H/7 * * * *')
    }
    wrappers {
        nodejs('nodejs')
    }
    steps {
        shell("npm install")
    }
    publishers {
      mailer('alejandropolocarvajal@gmail.com', true, true)
  }  
}
