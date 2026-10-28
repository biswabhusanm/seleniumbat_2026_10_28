pipeline {
    agent any

    triggers {
        // Uses the Jenkins controller's configured timezone.
        cron('0 22 * * *')
    }

    options {
        timestamps()
        disableConcurrentBuilds()
        buildDiscarder(logRotator(numToKeepStr: '30'))
    }

    tools {
        // Configure these exact names under Manage Jenkins > Tools.
        jdk 'JDK11'
        maven 'Maven3'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        stage('Environment') {
            steps {
                bat 'java -version'
                bat 'mvn -version'
            }
        }
        stage('Run Selenium TestNG suite') {
            steps {
                bat 'mvn -B clean test'
            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts: 'target/surefire-reports/**, target/allure-results/**, screenshots/**, target/reporting-labs/**',
                             allowEmptyArchive: true,
                             fingerprint: true
            junit testResults: 'target/surefire-reports/*.xml', allowEmptyResults: true
        }
    }
}
