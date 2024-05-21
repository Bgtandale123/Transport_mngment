node{
def mavenHome = tool name: "maven3.8.5" 
 
echo "The node name is :${env.NODE_NAME}"
echo "The Job name is:${env.JOB_NAME}" 
echo "The Build number is:${env.BUILD_NUMBER}"
 
//Checkout Stage
stage('CheckoutCode'){
git branch: 'dev', credentialsId: '3b257769-cd49-4341-8c10-29721c76969c', url: 'https://github.com/more-tushar/transport_mngment.git'
}
//Build Stage
stage('Build'){
sh "$mavenHome/bin/mvn clean package"
}
//Generate SonarQube Report
stage('SonarQubeReport'){
sh "$mavenHome/bin/mvn sonar:sonar"
}
//Upload Artifact into Articatory repo
// stage('UploadArtifcatsIntoNexus'){
// sh "$mavenHome/bin/mvn deploy"
// }
//Deploy App into Tomcat Server
stage('DeployAppIntoTomcatServer'){
sshagent(['5d783da5-d5c4-44e8-866e-070453ae66cd']) {
 sh "scp -o StrictHostKeyChecking=no target/ExpertIt_edi.war ubuntu@54.91.94.137:/opt/apache-tomcat-9.0.89/webapps"
  }  
 }
} //Node Closing
