package com.demo;

/**
 * Simple Java Application for CI/CD Demo
 * This application demonstrates a basic Java program that can be built with Maven
 */
public class App {
    public static void main(String[] args) {
        System.out.println("================================");
        System.out.println("Hello from Jenkins CI/CD Pipeline!");
        System.out.println("================================");
        System.out.println("Build Date: " + java.time.LocalDateTime.now());
        System.out.println("This application was:");
        System.out.println("  ✓ Built with Maven");
        System.out.println("  ✓ Packaged in Docker");
        System.out.println("  ✓ Automated with Jenkins");
        System.out.println("================================");
        System.out.println("Hello from Jenkins CI/CD Pipeline - VERSION 2!");
    }
}
