node {
  stage('SCM') {
    checkout scm
  }
  stage('SonarQube Analysis') {
    def mvn = tool 'm1';
    withSonarQubeEnv() {
      bat "${mvn}/bin/mvn clean verify sonar:sonar -Dsonar.login=squ_231cbdc2c2fdde3d88d4ee21dfe228f6b60d099d -Dsonar.projectKey=Admision1 -Dsonar.projectName='Admision1'"
    }
  }
  
  
}