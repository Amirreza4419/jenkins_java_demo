// Jenkinsfile - Pipeline as Code
// This file defines the entire CI/CD pipeline

pipeline {
    // Run on any available Jenkins agent
    agent any
    
    // Environment variables
    environment {
        // DockerHub credentials (stored in Jenkins)
        DOCKERHUB_CREDENTIALS = credentials('dockerhub-credentials')
        
        // Docker image name (CHANGE THIS to your DockerHub username)
        DOCKER_IMAGE = "amirreza4419/jenkins-java-demo"
        
        // Use BUILD_NUMBER as tag for versioning
        IMAGE_TAG = "${BUILD_NUMBER}"
    }
    
    // Pipeline stages
    stages {
        
        // Stage 1: Checkout code from Git
        stage('Checkout') {
            steps {
                echo '===== Checking out code from Git ====='
                checkout scm
                echo 'Checkout completed successfully!'
            }
        }
        
        // Stage 2: Build Java application with Maven
        stage('Build') {
            steps {
                echo '===== Building Java application with Maven ====='
                
                // Run Maven clean and package
                // This compiles code and creates JAR file
                sh 'mvn clean package -DskipTests'
                
                echo 'Build completed successfully!'
                echo 'JAR file created in target/ directory'
            }
        }
        
        // Stage 3: Run tests
        stage('Test') {
            steps {
                echo '===== Running tests ====='
                
                // Run Maven tests
                sh 'mvn test'
                
                echo 'Tests completed successfully!'
            }
            
            // Archive test results
            post {
                always {
                    // Publish test results (if JUnit plugin is installed)
                    junit allowEmptyResults: true, testResults: '**/target/surefire-reports/*.xml'
                }
            }
        }
        
        // Stage 4: Build Docker image
        stage('Build Docker Image') {
            steps {
                echo '===== Building Docker image ====='
                
                script {
                    // Build Docker image with tag
                    sh """
                        docker build -t ${DOCKER_IMAGE}:${IMAGE_TAG} .
                        docker tag ${DOCKER_IMAGE}:${IMAGE_TAG} ${DOCKER_IMAGE}:latest
                    """
                }
                
                echo "Docker image built: ${DOCKER_IMAGE}:${IMAGE_TAG}"
            }
        }
        
        // Stage 5: Push to DockerHub
        stage('Push to DockerHub') {
            steps {
                echo '===== Pushing Docker image to DockerHub ====='
                
                script {
                    // Login to DockerHub using credentials
                    sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
                    
                    // Push both tagged and latest versions
                    sh """
                        docker push ${DOCKER_IMAGE}:${IMAGE_TAG}
                        docker push ${DOCKER_IMAGE}:latest
                    """
                }
                
                echo "Image pushed successfully to DockerHub!"
                echo "You can pull it with: docker pull ${DOCKER_IMAGE}:${IMAGE_TAG}"
            }
        }
        
        // Stage 6: Clean up
        stage('Clean Up') {
            steps {
                echo '===== Cleaning up local Docker images ====='
                
                script {
                    // Remove local images to save space
                    sh """
                        docker rmi ${DOCKER_IMAGE}:${IMAGE_TAG} || true
                        docker rmi ${DOCKER_IMAGE}:latest || true
                    """
                }
                
                echo 'Cleanup completed!'
            }
        }
    }
    
    // Post-build actions
    post {
        success {
            echo '===== Pipeline completed successfully! ====='
            echo "Docker image available at: ${DOCKER_IMAGE}:${IMAGE_TAG}"
            
            // Optional: Send notification (if Slack/Email plugin is installed)
            // slackSend color: 'good', message: "Build ${BUILD_NUMBER} succeeded!"
        }
        
        failure {
            echo '===== Pipeline failed! ====='
            echo 'Check the console output for errors'
            
            // Optional: Send notification
            // slackSend color: 'danger', message: "Build ${BUILD_NUMBER} failed!"
        }
        
        always {
            echo '===== Logging out from DockerHub ====='
            sh 'docker logout'
            
            // Clean workspace (optional)
            // cleanWs()
        }
    }
}
