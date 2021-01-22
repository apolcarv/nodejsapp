job('Aplicacion Node.js Docker DSL') {
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
    steps {dockerBuildAndPublish {
            repositoryName('apolcarv1/nodejsapp')
            tag('${GIT_REVISION,length=7}')
            registryCredentials('docker-hub')
            forcePull(false)
            createFingerprints(false)
            skipDecorate()
        }
    }
    publishers {
      mailer('alejandropolocarvajal@gmail.com', true, true)
	  
  }  
}
