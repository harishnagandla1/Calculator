node {
    stage('Preparation') {
        // Get some code from a GitHub repository
        git branch: 'main', credentialsId: 'b9ce2f10-b129-4323-aedc-1ba507a50952', url: 'https://github.com/harishnagandla1/Calculator.git'
    }
    stage('Build') {
       env.PATH = "C:/Program Files/Maven/apache-maven-3.9.7/bin;c:\\Windows\\System32"
       bat 'mvn clean -PSmoke package'
    }
    stage('Results') {
        archiveArtifacts artifacts: 'target/*.jar', followSymlinks: false
    }

    stage('GenrateReports') {
       publishHTML([allowMissing: false, alwaysLinkToLastBuild: false, keepAll: false, reportDir: 'reports\\', reportFiles: '*.html', reportName: 'Extent Report', reportTitles: '', useWrapperFileDirectly: true])
    }

    stage('Notification') {
     emailext body: '''Hi Team,

           $DEFAULT_CONTENT

       This Jenkins Job related to Test Calculator Application Automation Test with TestNg Automation Framework, Maven build management and Java Project. Please find results of Jenkins Job build.

       Note: Please Don\'t reply to this mail, It is autogenerated.

       Thanks & Regards,
       Jenkins''', subject: '$DEFAULT_SUBJECT', to: 'harishnagandla1@gmail.com'
    }

}