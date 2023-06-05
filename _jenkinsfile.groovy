pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building the code...'
            }
            
        }

        stage('Unit and Integration Tests') {
            steps {
                echo 'Running unit and integration tests...'
                
            }
            post {
            always {
                        mail to: 'joemac3035@gmail.com',
                        subject: 'Build status email',
                        body: 'Build successful'
                        emailext attachLog: true, body: 'Pipeline finished', subject: 'Pipeline status: ${currentBuild.currentResult}', to: 'joemac3035@gmail.com'
                    }
            }
        }

        stage('Code Analysis') {
            steps {
                echo 'Running unit and integration tests...'
                
            }
        }

        stage('Security Scan') {
            steps {
                echo 'Performing security scan...'
            }
        }

        stage('Deploy to Staging') {
            steps {
                echo 'Deploying to staging environment...'
            }
        }

        stage('Integration Tests on Staging') {
            steps {
                echo 'Running integration tests on staging environment...'
            }
        }

        stage('Deploy to Production') {
            steps {
                echo 'Deploying to production environmnent...'
                }
            }
        }
    }

    