job('Aplicacion2 Node.js DSL') {
  	description('Job DSL de ejemplo para el curso de Jenkins')
  scm {
    git('https://github.com/apolcarv/nodejsapp.git','main') { node ->
      node / gitConfigName('apolcarv1')
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
