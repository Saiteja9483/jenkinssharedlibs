def call(credId,user,ip){
  sshagent([credId]) {
                         sh "mv target/myweb*.war target/app.war"
    sh "scp -o StrictHostKeyChecking=no target/app.war ${user}@${ip}:/opt/tomcat/webapps "
    sh "ssh ${user}@${ip} sudo /opt/tomcat/bin/startup.sh"
  }
}
